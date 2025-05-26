package quemepongo.v3.domain.domain.sugerencias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.prendas.Prenda;
import quemepongo.v3.domain.sugerencias.MotorSugerenciaFormalidad;
import quemepongo.v3.domain.usuarios.Usuario;

public class MotorSugerenciaFormalidadTest {
  private MotorSugerenciaFormalidad motorSugerenciaFormalidad;
  private Usuario usuarioMock;
  private List<Prenda> prendasMock;
  private Prenda prendaFormalMock;
  private Prenda prendaInformalMock;

  @BeforeEach
  void setUp() {
    motorSugerenciaFormalidad = new MotorSugerenciaFormalidad();
    usuarioMock = mock(Usuario.class);
    prendaFormalMock = mock(Prenda.class);
    prendaInformalMock = mock(Prenda.class);
    prendasMock = List.of(prendaFormalMock, prendaInformalMock);
  }

  @Test
  void validarPrendasDe_cuandoUsuarioEsEdadAvanzada_deberiaFiltrarPrendasInformales() {
    when(usuarioMock.esEdadAvanzada()).thenReturn(true);
    when(usuarioMock.getPrendas()).thenReturn(prendasMock);
    when(prendaFormalMock.esInformal()).thenReturn(false);
    when(prendaInformalMock.esInformal()).thenReturn(true);

    List<Prenda> resultado = motorSugerenciaFormalidad.validarPrendasDe(usuarioMock);

    assertEquals(List.of(prendaFormalMock), resultado);
  }

  @Test
  void validarPrendasDe_cuandoUsuarioNoEsEdadAvanzada_deberiaDevolverTodasLasPrendas() {
    when(usuarioMock.esEdadAvanzada()).thenReturn(false);
    when(usuarioMock.getPrendas()).thenReturn(prendasMock);

    List<Prenda> resultado = motorSugerenciaFormalidad.validarPrendasDe(usuarioMock);

    assertEquals(prendasMock, resultado);
  }
}
