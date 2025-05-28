package quemepongo.v4.domain.usuarios;

import java.util.List;
import quemepongo.v4.domain.atuendos.Atuendo;
import quemepongo.v4.domain.prendas.Prenda;
import quemepongo.v4.domain.sugerencias.MotorSugerencia;

public class Usuario {
  private final int edad;
  private final List<Prenda> prendas;
  private MotorSugerencia motorSugerencia;

  public Usuario(int edad, List<Prenda> prendas, MotorSugerencia motorSugerencia) {
    this.edad = edad;
    this.prendas = List.copyOf(prendas);
    this.motorSugerencia = motorSugerencia;
  }

  public void setMotorSugerencia(MotorSugerencia motorSugerencia) {
    this.motorSugerencia = motorSugerencia;
  }

  public List<Prenda> getPrendas() {
    return List.copyOf(prendas);
  }

  public Atuendo sugerirAtuendo() {
    return motorSugerencia.sugerirAtuendo(this);
  }

  public List<Atuendo> sugerirAtuendos() {
    return motorSugerencia.sugerirAtuendos(this);
  }

  public boolean esEdadAvanzada() {
    return edad >= 56;
  }
}
