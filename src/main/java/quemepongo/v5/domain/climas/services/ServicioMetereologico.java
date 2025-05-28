package quemepongo.v5.domain.climas.services;

import java.util.List;
import quemepongo.v5.domain.climas.CondicionClimatica;

public interface ServicioMetereologico {
  List<CondicionClimatica> obtenerCondicionesClimaticas(String ciudad);
}
