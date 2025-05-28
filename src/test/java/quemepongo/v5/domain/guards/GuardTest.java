package quemepongo.v5.domain.guards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GuardTest {
  @Test
  void notNull_cuandoElParametroEsNoNulo_deberiaRetornarElMismoObjeto() {
    String valor = "test";
    String resultado = Guard.notNull(valor, "El valor no puede ser nulo");
    assertEquals(valor, resultado);
  }

  @Test
  void notNull_cuandoElParametroEsNulo_deberiaLanzarExcepcion() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> Guard.notNull(null, "El valor no puede ser nulo")
    );
    assertEquals("El valor no puede ser nulo", exception.getMessage());
  }
}
