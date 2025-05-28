package quemepongo.v4.domain.climas.apis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AccuWeatherAPITest {
  @Test
  void getWeather_deberiaRetornarDatosClimaticosCorrectos() {
    AccuWeatherAPI api = new AccuWeatherAPI();
    String ciudad = "Villa Vil";

    List<Map<String, Object>> datosClimaticos = api.getWeather(ciudad);

    assertNotNull(datosClimaticos);
    assertEquals(1, datosClimaticos.size());

    Map<String, Object> primerDato = datosClimaticos.get(0);
    assertEquals("2019-05-03T01:00:00-03:00", primerDato.get("DateTime"));
    assertEquals(1556856000, primerDato.get("EpochDateTime"));
    assertEquals(33, primerDato.get("WeatherIcon"));
    assertEquals("Clear", primerDato.get("IconPhrase"));
    assertEquals(false, primerDato.get("IsDaylight"));
    assertEquals(0, primerDato.get("PrecipitationProbability"));
    assertEquals("http://m.accuweather.com/en/ar/villa-vil/7984/", primerDato.get("MobileLink"));
    assertEquals("http://www.accuweather.com/en/ar/villa-vil/7984", primerDato.get("Link"));

    Map<String, Object> temperatura = (Map<String, Object>) primerDato.get("Temperature");
    assertNotNull(temperatura);
    assertEquals(25, temperatura.get("Value"));
    assertEquals("C", temperatura.get("Unit"));
    assertEquals(18, temperatura.get("UnitType"));
  }
}