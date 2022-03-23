package com.pruebatecnica.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import org.openqa.selenium.By;
import com.pruebatecnica.utilitarios.MetodosGenericos;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@DefaultUrl ("https://www.avianca.com/")
public class ReservarVueloPageObjects  extends  PageObject {
	
	MetodosGenericos metodosGenericos;
	
	private static Logger log = LogManager.getLogger(ReservarVueloPageObjects.class);
	
	@FindBy(xpath = "//div[@id='tabHome']//following::a[@id='reservatuvuelo']")
	WebElementFacade lblTabReservarVuelo;
	
	@FindBy(xpath = "//a[@role='presentation']//input[@id='radioIdayVuelta']")
	WebElementFacade lblTabIdaYVuelta;
	
	@FindBy(xpath = "(//input[@aria-label='Selecciona o autocompleta la ciudad de origen'])[2]")
	WebElementFacade inputOrigenVuelo;
	
	String strButtonOrigenVuelo = "(//div[contains(@class,'bs-list-countries')])[3]//div//b[contains(text(),'strTemporal')]"; 
	
	@FindBy(xpath = "(//div[@class='form-group new-animate ']//input)[1]")
	WebElementFacade inputFinVuelo;
	
	String strButtonFinVuelo =  "(//div[contains(@class,'bs-list-countries')])[4]//div//b[contains(text(),'strTemporal')]";
	
	
	@FindBy(xpath = "(//input[@name='pbFechaIda'])[1]")
	WebElementFacade inputFechaIda;
	
	@FindBy(xpath = "(//input[@name='pbFechaRegreso'])[1]")
	WebElementFacade inputFechaVuelta;
	
	@FindBy(xpath = "//span[@class='text errorIntegradas']")
	WebElementFacade buttonIconoCalendario;
	
	@FindBy(xpath = "(//button[contains(text(),'Buscar vuelos')])[3]")
	WebElementFacade buttonBuscarVuelo;
	
	String strLblFechaVuelo =  "(//div[contains(text(),'strTemporal')])[2]";
	String strButtonDiaVuelo = "((//div[contains(text(),'strTemporal1')])[2]//following::div//div[contains(text(),'strTemporal2')])[1]";
	
	@FindBy(xpath = "//h1[contains(text(),'Selecciona tu vuelo de ida')]")
	WebElementFacade lblSeccionVuelosIda;
	
	@FindBy(xpath = "((//div[@class='recap-price'])[2]//button)[1]")
	WebElementFacade buttonSegundoVueloEconomicoIdaVuelta;
	
	@FindBy(xpath = "//div[@class='ff-card selected']//button[@class='ff-price-container']")
	WebElementFacade buttonPrecioVueloEconomicoIda;
	
	@FindBy(xpath = "//h1[contains(text(),'Selecciona tu vuelo de regreso')]")
	WebElementFacade lblSeccionVuelosVuelta;
	
	@FindBy(xpath = "//div[@class='ff-card selected']//button[@class='ff-price-container']")
	WebElementFacade buttonPrecioVueloEconomicoVuelta;
	
	@FindBy(xpath = "//h1[contains(text(),'Resumen de viaje')]")
	WebElementFacade lblSeccionResumenViaje;
	
	String strInformacionVuelo = "(//div[@class='mat-form-field-infix']//input)[strTemporal]";
	String strPreciosVuelo = "(//*[contains(@class,('amount'))])[strTemporal]";
	
	@FindBy(xpath = "//i[@class='icon close']")
	WebElementFacade iconoCerrarVentana;

	public void ingreso_a_la_pagina_principal_de_Avianca() {
		open();
		metodosGenericos.esperaCargaPagina(10);
		Serenity.takeScreenshot();
	}
	
	public void valido_ingreso_a_la_pagina_principal() throws FileNotFoundException, IOException {
		metodosGenericos.validarMensajeLabel("Reserva tu vuelo", lblTabReservarVuelo);
	}

	public void ingreso_origen_y_destino_de_vuelo_para_busqueda(Map<String, String> data) throws FileNotFoundException, IOException, ParseException {
		metodosGenericos.eventoClick(lblTabReservarVuelo,true);
		metodosGenericos.eventoCheck(lblTabIdaYVuelta,true,true);
		metodosGenericos.limpiarIngresarValorInput(inputOrigenVuelo,data.get("DesdeViaje"),true);
		metodosGenericos.eventoClick(find(By.xpath(strButtonOrigenVuelo.replace("strTemporal", data.get("DesdeViaje")))), true);
		metodosGenericos.inputValorJavaScript(inputFinVuelo, data.get("HaciaViaje"),true);
		metodosGenericos.eventoClick(inputFinVuelo, true);
		metodosGenericos.eventoClick(find(By.xpath(strButtonFinVuelo.replace("strTemporal", data.get("HaciaViaje")))), true);
		metodosGenericos.eventoClickJavaScript(buttonIconoCalendario, true);
		metodosGenericos.eventoClick(find(By.xpath(strLblFechaVuelo.replace("strTemporal", data.get("FechaVuelo")))), true);
		metodosGenericos.esperarObjetoClickable(15, find(By.xpath(strButtonDiaVuelo.replace("strTemporal1", data.get("FechaVuelo")).replace("strTemporal2", data.get("DiaVueloIda")))));
		metodosGenericos.eventoClickJavaScript(find(By.xpath(strButtonDiaVuelo.replace("strTemporal1", data.get("FechaVuelo")).replace("strTemporal2", data.get("DiaVueloIda")))), true);
		metodosGenericos.eventoClickJavaScript(buttonIconoCalendario, true);
		metodosGenericos.esperarObjetoClickable(15, find(By.xpath(strButtonDiaVuelo.replace("strTemporal1", data.get("FechaVuelo")).replace("strTemporal2", data.get("DiaVueloVuelta")))));
		metodosGenericos.eventoClickJavaScript(find(By.xpath(strButtonDiaVuelo.replace("strTemporal1", data.get("FechaVuelo")).replace("strTemporal2", data.get("DiaVueloVuelta")))), true);
		metodosGenericos.eventoClick(buttonBuscarVuelo, true);
		metodosGenericos.esperaCargaPagina(10);
		metodosGenericos.esperarObjetoVisible(15, lblSeccionVuelosIda);
	}

	public void selecciono_segundo_vuelo_origen_y_destino_despues_de_la_busqueda() {
		metodosGenericos.eventoClick(buttonSegundoVueloEconomicoIdaVuelta, true);
		metodosGenericos.eventoClick(buttonPrecioVueloEconomicoIda, true);
		metodosGenericos.esperaCargaPagina(10);
		metodosGenericos.esperarObjetoVisible(15, lblSeccionVuelosVuelta);
		metodosGenericos.eventoClick(buttonSegundoVueloEconomicoIdaVuelta, true);
		metodosGenericos.eventoClick(buttonPrecioVueloEconomicoVuelta, true);
		metodosGenericos.esperaCargaPagina(10);
		metodosGenericos.esperarObjetoVisible(15, lblSeccionResumenViaje);
	}

	public void valido_la_seleccion_de_vuelo() {
		metodosGenericos.validarMensajeLabel("Resumen de viaje", lblSeccionResumenViaje);
		log.info("*************************Inicio Información de Viaje*************************");
		String strViajeDesde = find(By.xpath(strInformacionVuelo.replace("strTemporal", "1"))).getValue();
		log.info("Vuelo desde: "+strViajeDesde);
		String strViajeHacia = find(By.xpath(strInformacionVuelo.replace("strTemporal", "2"))).getValue();
		log.info("Vuelo Hacia: "+strViajeHacia);
		String strFechaIda = find(By.xpath(strInformacionVuelo.replace("strTemporal", "3"))).getValue();
		log.info("Fecha Vuelo Ida: "+strFechaIda);
		String strFechaRegreso = find(By.xpath(strInformacionVuelo.replace("strTemporal", "4"))).getValue();
		log.info("Fecha Vuelo Regreso: "+strFechaRegreso);
		String strNumeroPasajero = find(By.xpath(strInformacionVuelo.replace("strTemporal", "5"))).getValue();
		log.info("Número de Personas Reserva: "+strNumeroPasajero);
		String strPrecioIda = find(By.xpath(strPreciosVuelo.replace("strTemporal", "1"))).getText();
		log.info("Precio Vuelo Ida: "+strPrecioIda);
		String strPrecioRegreso = find(By.xpath(strPreciosVuelo.replace("strTemporal", "2"))).getText();
		log.info("Precio Vuelo Regreso: "+strPrecioRegreso);
		String strPrecioTotal = find(By.xpath(strPreciosVuelo.replace("strTemporal", "3"))).getText();
		log.info("Precio Vuelo Regreso: "+strPrecioTotal);
		log.info("*************************Fin Información de Viaje*************************");
	}
}
