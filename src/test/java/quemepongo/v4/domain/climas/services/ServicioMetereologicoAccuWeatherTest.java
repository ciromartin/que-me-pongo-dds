package quemepongo.v4.domain.climas.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v4.domain.climas.CondicionClimatica;
import quemepongo.v4.domain.climas.apis.AccuWeatherAPI;

class ServicioMetereologicoAccuWeatherTest {

  private AccuWeatherAPI apiMock;
  private ServicioMetereologicoAccuWeather servicio;
  private static final String CIUDAD = "Buenos Aires";

  @BeforeEach
  void setUp() {
    apiMock = mock(AccuWeatherAPI.class);
    servicio = new ServicioMetereologicoAccuWeather(apiMock);
  }

  @Test
  void obtenerCondicionesClimaticas_cuandoNoHayCache_deberiaConsultarApi() {
    List<Map<String, Object>> respuestaApi = List.of(
        Map.of("Temperature", Map.of("Value", 25, "Unit", "C"), "IconPhrase", "Clear")
    );
    when(apiMock.getWeather(CIUDAD)).thenReturn(respuestaApi);

    List<CondicionClimatica> condiciones = servicio.obtenerCondicionesClimaticas(CIUDAD);

    assertEquals(1, condiciones.size());
    assertEquals("Buenos Aires", condiciones.get(0).getCiudad());
    assertEquals("25", condiciones.get(0).getTemperatura());
    assertEquals("C", condiciones.get(0).getUnidadTemperatura());
    assertEquals("Clear", condiciones.get(0).getDescripcion());
    verify(apiMock, times(1)).getWeather(CIUDAD);
  }
}