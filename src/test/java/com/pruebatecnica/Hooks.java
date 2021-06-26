package com.pruebatecnica;

import com.pruebatecnica.utilitarios.MetodosGenericos;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	MetodosGenericos metodosGenericos;
	
	 @Before
	    public void beforeScenario(){
		 
	    } 
	 
	 @After
	    public void afterScenario(){
		 metodosGenericos.cerrarsesiondriver(); 
	    }
}
