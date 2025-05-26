package quemepongo.v3.domain.domain.usuarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.atuendos.Atuendo;
import quemepongo.v3.domain.prendas.Prenda;
import quemepongo.v3.domain.sugerencias.MotorSugerencia;
import quemepongo.v3.domain.sugerencias.MotorSugerenciaBasico;
import quemepongo.v3.domain.usuarios.Usuario;

public class UsuarioTest {
  private Usuario usuario;
  private MotorSugerencia motorSugerenciaMock;
  private List<Prenda> prendasMock;

  @BeforeEach
  void setUp() {
    prendasMock = List.of(mock(Prenda.class), mock(Prenda.class));
    motorSugerenciaMock = mock(MotorSugerencia.class);
    usuario = new Usuario(30, prendasMock, motorSugerenciaMock);
  }

  @Test
  void getPrendas_cuandoSeLlama_deberiaDevolverListaDePrendas() {
    assertEquals(prendasMock, usuario.getPrendas());
  }

  @Test
  void getSugerencia_cuandoSeInvoca_deberiaLlamarAlMotorDeSugerencias() {
    Atuendo atuendoMock = mock(Atuendo.class);
    when(motorSugerenciaMock.sugerirAtuendo(usuario)).thenReturn(atuendoMock);

    Atuendo sugerencia = usuario.sugerirAtuendo();

    assertEquals(atuendoMock, sugerencia);
    verify(motorSugerenciaMock).sugerirAtuendo(usuario);
  }

  @Test
  void testEsEdadAvanzada_True() {
    Usuario usuarioMayor = new Usuario(60, prendasMock, motorSugerenciaMock);
    assertTrue(usuarioMayor.esEdadAvanzada());
  }

  @Test
  void esEdadAvanzada_cuandoEdadEsMenor56_deberiaDevolverFalse() {
    Usuario usuarioMenor = new Usuario(30, prendasMock, motorSugerenciaMock);
    assertFalse(usuarioMenor.esEdadAvanzada());
  }
}
