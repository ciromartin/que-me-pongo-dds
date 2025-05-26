package quemepongo.v3.domain.domain.sugerencias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.prendas.Prenda;
import quemepongo.v3.domain.sugerencias.MotorSugerenciaBasico;
import quemepongo.v3.domain.usuarios.Usuario;

public class MotorSugerenciaBasicoTest {
  private MotorSugerenciaBasico motorSugerenciaBasico;
  private Usuario usuarioMock;
  private List<Prenda> prendasMock;

  @BeforeEach
  void setUp() {
    motorSugerenciaBasico = new MotorSugerenciaBasico();
    usuarioMock = mock(Usuario.class);
    prendasMock = List.of(mock(Prenda.class), mock(Prenda.class));
  }

  @Test
  void validarPrendasDe_cuandoSeInvoca_deberiaDevolverPrendasDelUsuario() {
    when(usuarioMock.getPrendas()).thenReturn(prendasMock);


    List<Prenda> resultado = motorSugerenciaBasico.validarPrendasDe(usuarioMock);


    assertEquals(prendasMock, resultado);
  }
}
