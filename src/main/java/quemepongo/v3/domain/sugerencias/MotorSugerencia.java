package quemepongo.v3.domain.sugerencias;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import quemepongo.v3.domain.atuendos.Atuendo;
import quemepongo.v3.domain.prendas.Prenda;
import quemepongo.v3.domain.usuarios.Usuario;

public abstract class MotorSugerencia {

  private Set<Prenda> getPrendasSuperiores(List<Prenda> prendas) {
    return prendas.stream()
        .filter(Prenda::esSuperior)
        .collect(Collectors.toSet());
  }

  private Set<Prenda> getPrendasInferiores(List<Prenda> prendas) {
    return prendas.stream()
        .filter(Prenda::esInferior)
        .collect(Collectors.toSet());
  }

  private Set<Prenda> getCalzados(List<Prenda> prendas) {
    return prendas.stream()
        .filter(Prenda::esCalzado)
        .collect(Collectors.toSet());
  }

  public Atuendo sugerirAtuendo(Usuario usuario) {
    List<Prenda> prendas = validarPrendasDe(usuario);

    Set<Prenda> prendasSuperiores = getPrendasSuperiores(prendas);
    Set<Prenda> prendasInferiores = getPrendasInferiores(prendas);
    Set<Prenda> calzados = getCalzados(prendas);

    validarAtuendoValido(prendasSuperiores, prendasInferiores, calzados);

    // Generar todas las combinaciones posibles
    List<List<Prenda>> combinaciones = new ArrayList<>(
        Sets.cartesianProduct(prendasSuperiores, prendasInferiores, calzados)
    );

    // Mezclar las combinaciones
    Collections.shuffle(combinaciones);

    // Seleccionar una combinación aleatoria
    List<Prenda> combinacionAleatoria = combinaciones.get(0);

    return new Atuendo(combinacionAleatoria.get(0), combinacionAleatoria.get(1), combinacionAleatoria.get(2));
  }

  private void validarAtuendoValido(Set<Prenda> prendasSuperiores,
                                    Set<Prenda> prendasInferiores,
                                    Set<Prenda> calzados) {
    if (prendasSuperiores.isEmpty()) {
      throw new IllegalStateException("Se necesita al menos una prenda superior para sugerir un atuendo.");
    }

    if (prendasInferiores.isEmpty()) {
      throw new IllegalStateException("Se necesita al menos una prenda inferior para sugerir un atuendo.");
    }

    if (calzados.isEmpty()) {
      throw new IllegalStateException("Se necesita al menos un calzado para sugerir un atuendo.");
    }
  }

  public abstract List<Prenda> validarPrendasDe(Usuario usuario);
}
