package com.pruebatecnica.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.pruebatecnica.pageobjects.ReservarVueloPageObjects;

import net.thucydides.core.annotations.Step;

public class ReservarVueloSteps {
	
	ReservarVueloPageObjects reservarVueloPageObjects;

	@Step
	public void ingreso_a_la_pagina_principal_de_Avianca() throws FileNotFoundException, IOException {
		reservarVueloPageObjects.ingreso_a_la_pagina_principal_de_Avianca();
		reservarVueloPageObjects.valido_ingreso_a_la_pagina_principal();
	}

	@Step
	public void ingreso_origen_y_destino_de_vuelo_para_busqueda(Map<String, String> data) throws FileNotFoundException, IOException, ParseException {
		reservarVueloPageObjects.ingreso_origen_y_destino_de_vuelo_para_busqueda(data);
	}

	@Step
	public void selecciono_segundo_vuelo_origen_y_destino_despues_de_la_busqueda() {
		reservarVueloPageObjects.selecciono_segundo_vuelo_origen_y_destino_despues_de_la_busqueda();
	}

	@Step
	public void valido_la_seleccion_de_vuelo() {
		reservarVueloPageObjects.valido_la_seleccion_de_vuelo();
	}

}
