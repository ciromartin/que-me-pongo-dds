package quemepongo.v5.domain.sugerencias;

import java.util.List;
import quemepongo.v5.domain.prendas.Prenda;
import quemepongo.v5.domain.usuarios.Usuario;

public class MotorSugerenciaBasico extends MotorSugerencia {
  @Override
  public List<Prenda> validarPrendasDe(Usuario usuario) {
    return usuario.getPrendas();
  }
}
