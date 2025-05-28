package quemepongo.v5.domain.sugerencias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v5.domain.atuendos.Atuendo;
import quemepongo.v5.domain.prendas.Color;
import quemepongo.v5.domain.prendas.Material;
import quemepongo.v5.domain.prendas.Prenda;
import quemepongo.v5.domain.prendas.TipoPrenda;
import quemepongo.v5.domain.prendas.builders.PrendaBuilder;
import quemepongo.v5.domain.usuarios.Usuario;

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

    Usuario usuario = new Usuario(30, todasLasPrendas, new MotorSugerenciaBasico());

    Atuendo atuendo = usuario.sugerirAtuendo();

    assertNotNull(atuendo);
    assertEquals(prendasSuperiores.get(0), atuendo.getPrendaSuperior());
    assertEquals(prendasInferiores.get(0), atuendo.getPrendaInferior());
    assertEquals(calzados.get(0), atuendo.getPrendaCalzado());
  }

  @Test
  void sugerirAtuendos_cuandoHayPrendasValidas_deberiaDevolverTodasLasCombinaciones() {
    List<Prenda> prendasSuperiores = List.of(
        new PrendaBuilder(TipoPrenda.CAMISA)
            .conMaterial(Material.ALGODON)
            .conColorPrincipal(Color.crearBlanco())
            .build(),
        new PrendaBuilder(TipoPrenda.REMERA)
            .conMaterial(Material.ALGODON)
            .conColorPrincipal(Color.crearRojo())
            .build()
    );

    List<Prenda> prendasInferiores = List.of(
        new PrendaBuilder(TipoPrenda.PANTALON)
            .conMaterial(Material.JEAN)
            .conColorPrincipal(Color.crearAzul())
            .build(),
        new PrendaBuilder(TipoPrenda.SHORT)
            .conMaterial(Material.ALGODON)
            .conColorPrincipal(Color.crearNegro())
            .build()
    );

    List<Prenda> calzados = List.of(
        new PrendaBuilder(TipoPrenda.ZAPATO)
            .conMaterial(Material.CUERO)
            .conColorPrincipal(Color.crearNegro())
            .build(),
        new PrendaBuilder(TipoPrenda.ZAPATILLA)
            .conMaterial(Material.TELA)
            .conColorPrincipal(Color.crearBlanco())
            .build()
    );

    List<Prenda> todasLasPrendas = Stream.concat(
        Stream.concat(prendasSuperiores.stream(), prendasInferiores.stream()),
        calzados.stream()
    ).toList();

    Usuario usuario = new Usuario(30, todasLasPrendas, new MotorSugerenciaBasico());

    List<Atuendo> atuendos = usuario.sugerirAtuendos();

    int combinacionesEsperadas = prendasSuperiores.size() * prendasInferiores.size() * calzados.size();
    assertNotNull(atuendos);
    assertEquals(combinacionesEsperadas, atuendos.size());
  }
}
