package quemepongo.v3.domain.domain.uniformes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import quemepongo.v3.domain.prendas.*;
import quemepongo.v3.domain.prendas.builders.PrendaBuilder;
import quemepongo.v3.domain.uniformes.Uniforme;


public class UniformeTest {
  static Stream<Arguments> provideInvalidUniformes() {
    return Stream.of(
        Arguments.of(null,
            new PrendaBuilder(TipoPrenda.PANTALON)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            new PrendaBuilder(TipoPrenda.ZAPATO)
                .conMaterial(Material.CUERO)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            "La prenda superior no puede ser nula"),
        Arguments.of(new PrendaBuilder(TipoPrenda.CAMISA)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearBlanco())
                .build(),
            null,
            new PrendaBuilder(TipoPrenda.ZAPATO)
                .conMaterial(Material.CUERO)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            "La prenda inferior no puede ser nula"),
        Arguments.of(new PrendaBuilder(TipoPrenda.CAMISA)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearBlanco())
                .build(),
            new PrendaBuilder(TipoPrenda.PANTALON)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            null,
            "La prenda de calzado no puede ser nula"),
        Arguments.of(new PrendaBuilder(TipoPrenda.ZAPATO)
                .conMaterial(Material.CUERO)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            new PrendaBuilder(TipoPrenda.PANTALON)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            new PrendaBuilder(TipoPrenda.ZAPATO)
                .conMaterial(Material.CUERO)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            "La prenda superior debe pertenecer a la categoría SUPERIOR"),
        Arguments.of(new PrendaBuilder(TipoPrenda.CAMISA)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearBlanco())
                .build(),
            new PrendaBuilder(TipoPrenda.ZAPATO)
                .conMaterial(Material.CUERO)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            new PrendaBuilder(TipoPrenda.ZAPATO)
                .conMaterial(Material.CUERO)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            "La prenda inferior debe pertenecer a la categoría INFERIOR"),
        Arguments.of(new PrendaBuilder(TipoPrenda.CAMISA)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearBlanco())
                .build(),
            new PrendaBuilder(TipoPrenda.PANTALON)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearNegro())
                .build(),
            new PrendaBuilder(TipoPrenda.CAMISA)
                .conMaterial(Material.ALGODON)
                .conTrama(Trama.LISO)
                .conColorPrincipal(Color.crearBlanco())
                .build(),
            "La prenda de calzado debe pertenecer a la categoría CALZADO")
    );
  }

  @ParameterizedTest
  @MethodSource("provideInvalidUniformes")
  void testInvalidUniformes(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado, String expectedMessage) {
    Exception exception = assertThrows(IllegalArgumentException.class, () ->
        new Uniforme(prendaSuperior, prendaInferior, prendaCalzado)
    );

    assertEquals(expectedMessage, exception.getMessage());
  }
}
