#Author: emilion04211992@hotmail.com
@ReservarVuelo
Feature: Reservar Vuelo Avianca
  Yo quiero realizar una reserva de vuelo en Avianca

  @SeleccionSegundoVuelo
  Scenario Outline: Seleccion de segundo vuelo despues de la busqueda en Avianca
    Given Ingreso a la pagina principal de Avianca
    When Ingreso origen y destino de vuelo para busqueda
      | DesdeViaje     | <inputDesdeViaje>     |
      | HaciaViaje     | <inputHaciaViaje>     |
      | FechaVuelo     | <inputFechaVuelo>     |
      | DiaVueloIda    | <inputDiaVueloIda>    |
      | DiaVueloVuelta | <inputDiaVueloVuelta> |
    And Selecciono segundo vuelo origen y destino despues de la busqueda
    Then Valido la seleccion de vuelo

    Examples: 
      | inputDesdeViaje | inputHaciaViaje | inputFechaVuelo | inputDiaVueloIda | inputDiaVueloVuelta |
      ##@externaldata@src/test/resources/data/RetoTecnico.xlsx@VueloAvianca
|Bogotá|Santa Marta|Julio 2021|1|5|
|Cali|Cartagena|Julio 2021|16|19|
