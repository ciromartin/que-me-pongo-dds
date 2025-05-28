package quemepongo.v5.domain.climas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CondicionClimaticaTest {
  @Test
  void constructor_deberiaCrearInstanciaCorrectamente() {
    CondicionClimatica condicion = new CondicionClimatica("Buenos Aires", "Clear", "25", "C");

    assertEquals("Buenos Aires", condicion.getCiudad());
    assertEquals("Clear", condicion.getDescripcion());
    assertEquals(25, condicion.getTemperatura());
    assertEquals("C", condicion.getUnidadTemperatura());
  }

  @Test
  void constructor_deberiaLanzarExcepcion_siCiudadEsNula() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
        new CondicionClimatica(null, "Clear", "25", "C"));
    assertEquals("La ciudad no puede ser nula", exception.getMessage());
  }

  @Test
  void constructor_deberiaLanzarExcepcion_siDescripcionEsNula() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
        new CondicionClimatica("Buenos Aires", null, "25", "C"));
    assertEquals("La descripción no puede ser nula", exception.getMessage());
  }

  @Test
  void constructor_deberiaLanzarExcepcion_siTemperaturaEsNula() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
        new CondicionClimatica("Buenos Aires", "Clear", null, "C"));
    assertEquals("La temperatura no puede ser nula", exception.getMessage());
  }

  @Test
  void constructor_deberiaLanzarExcepcion_siUnidadTemperaturaEsNula() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
        new CondicionClimatica("Buenos Aires", "Clear", "25", null));
    assertEquals("La unidad de temperatura no puede ser nula", exception.getMessage());
  }
}
