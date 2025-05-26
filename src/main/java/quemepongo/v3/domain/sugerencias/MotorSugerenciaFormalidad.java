package quemepongo.v3.domain.sugerencias;


import java.util.List;
import quemepongo.v3.domain.prendas.Prenda;
import quemepongo.v3.domain.usuarios.Usuario;

public class MotorSugerenciaFormalidad extends MotorSugerencia {
  @Override
  public List<Prenda> validarPrendasDe(Usuario usuario) {
    List<Prenda> prendas = usuario.getPrendas();
    return usuario.esEdadAvanzada()
        ? prendas.stream().filter(prenda -> !prenda.esInformal()).toList()
        : prendas;
  }
}
