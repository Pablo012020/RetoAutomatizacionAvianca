package com.pruebatecnica;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import com.pruebatecnica.utilitarios.BeforeSuite;
import com.pruebatecnica.utilitarios.DataToFeature;
import com.pruebatecnica.utilitarios.RunnerPersonalizado;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features="src/test/resources/features/reservarvuelo.feature", glue= {"com.pruebatecnica"}, tags="@ReservarVuelo")

public class RunnerTags {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		 DataToFeature.overrideFeatureFiles("src/test/resources/features/");
		 System.out.println("F I N A L I Z A C I Ó N   S E T   D E   D A T O S - - -"); 
	}
}
