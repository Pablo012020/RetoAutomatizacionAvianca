package com.pruebatecnica.utilitarios;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MetodosGenericos extends PageObject {

	public void cerrarsesiondriver() {
		getDriver().close();
		getDriver().quit();
	}
	
	public void esperaImplicita(int TiempoSegundos) {
		getDriver().manage().timeouts().implicitlyWait(TiempoSegundos, TimeUnit.SECONDS);
	}
	
	public void esperarObjetoClickable(int TiempoSegundos, WebElementFacade strXpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(),TiempoSegundos);
		wait.until(ExpectedConditions.elementToBeClickable(strXpath));
	}
	
	public void esperarObjetoVisible(int TiempoSegundos, WebElementFacade strXpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(),TiempoSegundos);
		wait.until(ExpectedConditions.visibilityOf(strXpath));
	}
	
	public void esperaCargaPagina(int TiempoSegundos) {
		getDriver().manage().timeouts().pageLoadTimeout(TiempoSegundos, TimeUnit.SECONDS);
	}
	
	public void validarMensajeLabel(String strMensaje, WebElementFacade strXpath) {
		try {
			esperarObjetoVisible(15, strXpath);
			String strLblMensaje = strXpath.getText();
			assertThat(strMensaje, is(containsString(strLblMensaje)));
			Serenity.takeScreenshot();
		}catch (Exception e) {
			Serenity.takeScreenshot();
			fail("No encontro mensaje o texto para validar: "+e.getMessage());
		}
	}
	
	public String obtenerValorProperties(String strNombreProperties, String strNombreParametro) throws FileNotFoundException, IOException {
		String strValor = "";
		Properties p = new Properties();
		p.load(new FileReader(strNombreProperties));
		strValor = p.getProperty(strNombreParametro);
		return strValor;
	}

	public void limpiarIngresarValorInput(WebElementFacade xpath, String strValor, boolean takeScreeshot) {
		esperarObjetoVisible(15, xpath);
		xpath.clear();
		xpath.sendKeys(strValor);
		if(takeScreeshot) {
			Serenity.takeScreenshot();
		}
	}
	
	public void inputValorJavaScript(WebElementFacade xpath, String strValor, boolean takeScreeshot) {
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("arguments[0].value='"+ strValor +"';", xpath);
		if(takeScreeshot) {
			Serenity.takeScreenshot();
		}
	}

	public void eventoClick(WebElementFacade xpath, boolean takeScreeshot) {
		esperarObjetoClickable(15, xpath);
		xpath.click();
		if(takeScreeshot) {Serenity.takeScreenshot();}
	}
	
	public void eventoClickJavaScript(WebElementFacade xpath, boolean takeScreeshot) {
		esperarObjetoClickable(15, xpath);
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", xpath);
		if(takeScreeshot) {Serenity.takeScreenshot();}
	}

	public void eventoCheck(WebElementFacade xpath, boolean checkear, boolean takeScreeshot) {
		esperarObjetoClickable(15, xpath);
		if(checkear){
			if (!xpath.isSelected()){
				eventoClick(xpath,false);
			}
		}else {
			if (xpath.isSelected()){
				eventoClick(xpath,false);
			}
		}
		if(takeScreeshot) {Serenity.takeScreenshot();}
	}
}
