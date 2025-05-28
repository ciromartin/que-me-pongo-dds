package quemepongo.v4.domain.climas.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import quemepongo.v4.domain.caches.Cache;
import quemepongo.v4.domain.climas.CondicionClimatica;

public class ServicioMetereologicoAccuWeatherCache implements ServicioMetereologico {
  private final Duration periodoDeValidez;
  private final Cache<String, List<CondicionClimatica>> cache;
  private final ServicioMetereologico servicioMetereologico;

  public ServicioMetereologicoAccuWeatherCache(
      Duration periodoDeValidez,
      Cache<String, List<CondicionClimatica>> cache,
      ServicioMetereologico servicioMetereologico) {
    this.periodoDeValidez = periodoDeValidez;
    this.cache = cache;
    this.servicioMetereologico = servicioMetereologico;
  }

  private LocalDateTime proximaExpiracion() {
    return LocalDateTime.now().plus(this.periodoDeValidez);
  }

  @Override
  public List<CondicionClimatica> obtenerCondicionesClimaticas(String ciudad) {
    if (cache.contiene(ciudad)) {
      return cache.obtener(ciudad);
    }

    List<CondicionClimatica> condicionClimaticas = servicioMetereologico.obtenerCondicionesClimaticas(ciudad);
    cache.guardar(ciudad, condicionClimaticas, proximaExpiracion());
    return condicionClimaticas;
  }
}
