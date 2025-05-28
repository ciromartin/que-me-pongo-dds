package quemepongo.v5.domain.asesores;

import quemepongo.v5.domain.atuendos.Atuendo;

public interface Asesor {
  Atuendo sugerirAtuendo(String direccion);
}
