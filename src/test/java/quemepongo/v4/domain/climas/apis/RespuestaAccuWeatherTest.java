package quemepongo.v4.domain.climas.apis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import quemepongo.v5.domain.climas.CondicionClimatica;
import quemepongo.v5.domain.climas.apis.RespuestaAccuWeather;

class RespuestaAccuWeatherTest {
  @Test
  void mapearACondicionesClimaticas_deberiaMapearCorrectamente() {
    String ciudad = "Buenos Aires";
    List<Map<String, Object>> datosClimaticos = List.of(
        Map.of(
            "Temperature", Map.of("Value", 25, "Unit", "C"),
            "IconPhrase", "Clear"
        ),
        Map.of(
            "Temperature", Map.of("Value", 30, "Unit", "C"),
            "IconPhrase", "Sunny"
        )
    );

    List<CondicionClimatica> condiciones = RespuestaAccuWeather.mapearACondicionesClimaticas(ciudad, datosClimaticos);

    assertEquals(2, condiciones.size());
    assertEquals("Buenos Aires", condiciones.get(0).getCiudad());
    assertEquals("Clear", condiciones.get(0).getDescripcion());
    assertEquals(25, condiciones.get(0).getTemperatura());
    assertEquals("C", condiciones.get(0).getUnidadTemperatura());

    assertEquals("Buenos Aires", condiciones.get(1).getCiudad());
    assertEquals("Sunny", condiciones.get(1).getDescripcion());
    assertEquals(30, condiciones.get(1).getTemperatura());
    assertEquals("C", condiciones.get(1).getUnidadTemperatura());
  }
}