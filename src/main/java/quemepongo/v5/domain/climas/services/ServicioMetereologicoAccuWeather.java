package quemepongo.v5.domain.climas.services;

import java.util.List;
import java.util.Map;
import quemepongo.v5.domain.climas.CondicionClimatica;
import quemepongo.v5.domain.climas.apis.AccuWeatherAPI;
import quemepongo.v5.domain.climas.apis.RespuestaAccuWeather;

public class ServicioMetereologicoAccuWeather implements ServicioMetereologico {
  private final AccuWeatherAPI api;

  public ServicioMetereologicoAccuWeather(AccuWeatherAPI api) {
    this.api = api;
  }

  @Override
  public List<CondicionClimatica> obtenerCondicionesClimaticas(String ciudad) {
    List<Map<String, Object>> datosClimaticos = this.api.getWeather(ciudad);
    if (datosClimaticos.isEmpty()) {
      throw new IllegalArgumentException("No se encontraron condiciones climáticas para la ciudad: " + ciudad);
    }
    return RespuestaAccuWeather.mapearACondicionesClimaticas(ciudad, datosClimaticos);
  }
}
