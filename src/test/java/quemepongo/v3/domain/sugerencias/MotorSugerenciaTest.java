package quemepongo.v3.domain.sugerencias;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.atuendos.Atuendo;
import quemepongo.v3.domain.prendas.Color;
import quemepongo.v3.domain.prendas.Material;
import quemepongo.v3.domain.prendas.Prenda;
import quemepongo.v3.domain.prendas.TipoPrenda;
import quemepongo.v3.domain.prendas.builders.PrendaBuilder;
import quemepongo.v3.domain.sugerencias.MotorSugerencia;
import quemepongo.v3.domain.sugerencias.MotorSugerenciaBasico;
import quemepongo.v3.domain.usuarios.Usuario;

public class MotorSugerenciaTest {
  private MotorSugerencia motorSugerencia;
  private Usuario usuario;
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  @BeforeEach
  void setUp() {
    motorSugerencia = new MotorSugerenciaBasico();


    prendaSuperior = new PrendaBuilder(TipoPrenda.CAMISA)
        .conMaterial(Material.ALGODON)
        .conColorPrincipal(Color.crearBlanco())
        .build();

    prendaInferior = new PrendaBuilder(TipoPrenda.PANTALON)
        .conMaterial(Material.JEAN)
        .conColorPrincipal(Color.crearAzul())
        .build();

    calzado = new PrendaBuilder(TipoPrenda.ZAPATO)
        .conMaterial(Material.CUERO)
        .conColorPrincipal(Color.crearNegro())
        .build();

    usuario = new Usuario(30, List.of(prendaSuperior, prendaInferior, calzado), motorSugerencia);
  }

  @Test
  void sugerirAtuendo_cuandoHayPrendasValidas_deberiaDevolverAtuendo() {
    Atuendo atuendo = motorSugerencia.sugerirAtuendo(usuario);
    assertNotNull(atuendo);
  }

  @Test
  void sugerirAtuendo_conListasDePrendas_deberiaDevolverAtuendo() {
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

    usuario = new Usuario(30, todasLasPrendas, motorSugerencia);

    Atuendo atuendo = motorSugerencia.sugerirAtuendo(usuario);

    assertNotNull(atuendo);
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

    usuario = new Usuario(30, todasLasPrendas, motorSugerencia);

    List<Atuendo> atuendos = motorSugerencia.sugerirAtuendos(usuario);


    int combinacionesEsperadas = prendasSuperiores.size() * prendasInferiores.size() * calzados.size();
    assertNotNull(atuendos);
    assertEquals(combinacionesEsperadas, atuendos.size());
  }

  @Test
  void sugerirAtuendo_cuandoFaltanPrendasSuperiores_deberiaLanzarExcepcion() {
    usuario = new Usuario(30, List.of(prendaInferior, calzado), motorSugerencia);
    assertThrows(IllegalStateException.class, () -> motorSugerencia.sugerirAtuendo(usuario));
  }

  @Test
  void sugerirAtuendo_cuandoFaltanPrendasInferiores_deberiaLanzarExcepcion() {
    usuario = new Usuario(30, List.of(prendaSuperior, calzado), motorSugerencia);
    assertThrows(IllegalStateException.class, () -> motorSugerencia.sugerirAtuendo(usuario));
  }

  @Test
  void sugerirAtuendo_cuandoFaltanCalzados_deberiaLanzarExcepcion() {
    usuario = new Usuario(30, List.of(prendaSuperior, prendaInferior), motorSugerencia);
    assertThrows(IllegalStateException.class, () -> motorSugerencia.sugerirAtuendo(usuario));
  }
}
