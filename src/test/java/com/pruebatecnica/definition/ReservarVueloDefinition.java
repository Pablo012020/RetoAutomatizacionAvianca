package com.pruebatecnica.definition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import com.pruebatecnica.steps.ReservarVueloSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ReservarVueloDefinition {
	
	@Steps
	ReservarVueloSteps reservarVueloSteps;
	
	@Given("^Ingreso a la pagina principal de Avianca$")
	public void ingreso_a_la_pagina_principal_de_Avianca() throws FileNotFoundException, IOException {
		reservarVueloSteps.ingreso_a_la_pagina_principal_de_Avianca();
	}

	@When("^Ingreso origen y destino de vuelo para busqueda$")
	public void ingreso_origen_y_destino_de_vuelo_para_busqueda(Map<String, String> data) throws FileNotFoundException, IOException, ParseException {
		reservarVueloSteps.ingreso_origen_y_destino_de_vuelo_para_busqueda(data);
	}

	@When("^Selecciono segundo vuelo origen y destino despues de la busqueda$")
	public void selecciono_segundo_vuelo_origen_y_destino_despues_de_la_busqueda() {
	    reservarVueloSteps.selecciono_segundo_vuelo_origen_y_destino_despues_de_la_busqueda();
	}

	@Then("^Valido la seleccion de vuelo$")
	public void valido_la_seleccion_de_vuelo() {
	    reservarVueloSteps.valido_la_seleccion_de_vuelo();
	}

}
