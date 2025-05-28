package quemepongo.v4.domain.asesores;

import quemepongo.v4.domain.atuendos.Atuendo;
import quemepongo.v4.domain.sugerencias.MotorSugerencia;

public interface Asesor {
  Atuendo sugerirAtuendo(String direccion);
}
