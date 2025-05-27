package quemepongo.v4.domain.climas.services;

import java.util.List;
import java.util.Map;
import quemepongo.v4.domain.climas.CondicionClimatica;
import quemepongo.v4.domain.climas.apis.AccuWeatherAPI;
import quemepongo.v4.domain.climas.apis.RespuestaAccuWeather;

public class ServicioMetereologicoAccuWeather implements ServicioMetereologico {
  private final AccuWeatherAPI api;

  public ServicioMetereologicoAccuWeather(AccuWeatherAPI api) {
    this.api = api;
  }

  @Override
  public List<CondicionClimatica> obtenerCondicionesClimaticas(String ciudad) {
    List<Map<String, Object>> datosClimaticos = this.api.getWeather(ciudad);
    return RespuestaAccuWeather.mapearACondicionesClimaticas(ciudad, datosClimaticos);
  }
}
