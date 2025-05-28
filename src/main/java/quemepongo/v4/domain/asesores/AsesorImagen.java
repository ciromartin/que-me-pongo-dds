package quemepongo.v4.domain.asesores;

import java.util.List;
import quemepongo.v4.domain.atuendos.Atuendo;
import quemepongo.v4.domain.climas.CondicionClimatica;
import quemepongo.v4.domain.climas.services.ServicioMetereologico;
import quemepongo.v4.domain.exceptions.AtuendoNoValido;
import quemepongo.v4.domain.sugerencias.MotorSugerencia;
import quemepongo.v4.domain.usuarios.Usuario;

public class AsesorImagen implements Asesor {
  private final Usuario usuario;
  private final ServicioMetereologico servicioMetereologico;
  private final MotorSugerencia motorSugerencia;

  public AsesorImagen(Usuario usuario, ServicioMetereologico servicioMetereologico, MotorSugerencia motorSugerencia) {
    this.usuario = usuario;
    this.servicioMetereologico = servicioMetereologico;
    this.motorSugerencia = motorSugerencia;
  }

  @Override
  public Atuendo sugerirAtuendo(String ciudad) {
    List<CondicionClimatica> condicionesClimaticas = servicioMetereologico.obtenerCondicionesClimaticas(ciudad);
    validarCondicionesClimaticas(condicionesClimaticas);
    List<Atuendo> atuendos = this.motorSugerencia.sugerirAtuendos(usuario);
    validarAtuendosDisponibles(atuendos);
    atuendos = filtrarAtuendosApropiadosParaClima(atuendos, condicionesClimaticas.get(0));
    validarAtuendosApropiados(atuendos);
    return atuendos.get(0);
  }

  private List<Atuendo> filtrarAtuendosApropiadosParaClima(List<Atuendo> atuendos, CondicionClimatica condicionClimatica) {
    return atuendos.stream()
        .filter(atuendo -> atuendo.esApropiadoParaClima(condicionClimatica.getTemperatura()))
        .toList();
  }

  private void validarCondicionesClimaticas(List<CondicionClimatica> condicionesClimaticas) {
    if (condicionesClimaticas.isEmpty()) {
      throw new AtuendoNoValido("No se encontraron condiciones climáticas para la ciudad especificada.");
    }
  }

  private void validarAtuendosDisponibles(List<Atuendo> atuendos) {
    if (atuendos.isEmpty()) {
      throw new AtuendoNoValido("No se puede sugerir un atuendo porque no hay atuendos disponibles.");
    }
  }

  private void validarAtuendosApropiados(List<Atuendo> atuendos) {
    if (atuendos.isEmpty()) {
      throw new AtuendoNoValido("No hay atuendos apropiados para las condiciones climáticas actuales.");
    }
  }
}
