package quemepongo.v3.domain.domain.sugerencias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.atuendos.Atuendo;
import quemepongo.v3.domain.prendas.*;
import quemepongo.v3.domain.prendas.builders.PrendaBuilder;
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

  @Test
  void sugerirAtuendo_cuandoHayPrendasValidas_deberiaDevolverUnAtuendo() {
    List<Prenda> prendasSuperiores = List.of(
        new PrendaBuilder(TipoPrenda.CAMISA)
            .conMaterial(Material.ALGODON)
            .conColorPrincipal(Color.crearBlanco())
            .build()
    );

    List<Prenda> prendasInferiores = List.of(
        new PrendaBuilder(TipoPrenda.PANTALON)
            .conMaterial(Material.JEAN)
            .conColorPrincipal(Color.crearAzul())
            .build()
    );

    List<Prenda> calzados = List.of(
        new PrendaBuilder(TipoPrenda.ZAPATO)
            .conMaterial(Material.CUERO)
            .conColorPrincipal(Color.crearNegro())
            .build()
    );

    List<Prenda> todasLasPrendas = Stream.concat(
        Stream.concat(prendasSuperiores.stream(), prendasInferiores.stream()),
        calzados.stream()
    ).toList();

    when(usuarioMock.getPrendas()).thenReturn(todasLasPrendas);
    when(usuarioMock.esEdadAvanzada()).thenReturn(false);

    Atuendo atuendo = motorSugerenciaFormalidad.sugerirAtuendo(usuarioMock);

    assertNotNull(atuendo);
    assertEquals(prendasSuperiores.get(0), atuendo.getPrendaSuperior());
    assertEquals(prendasInferiores.get(0), atuendo.getPrendaInferior());
    assertEquals(calzados.get(0), atuendo.getPrendaCalzado());
  }
}
