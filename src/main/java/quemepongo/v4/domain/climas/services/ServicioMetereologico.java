package quemepongo.v4.domain.climas.services;

import java.util.List;
import quemepongo.v4.domain.climas.CondicionClimatica;

public interface ServicioMetereologico {
  List<CondicionClimatica> obtenerCondicionesClimaticas(String ciudad);
}
