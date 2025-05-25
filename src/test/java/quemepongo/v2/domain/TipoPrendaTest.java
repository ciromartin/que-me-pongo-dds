package quemepongo.v2.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v2.domain.prendas.Categoria;
import quemepongo.v2.domain.prendas.TipoPrenda;

public class TipoPrendaTest {
  @Test
  void getCategoria_cuandoEsCamisa_deberiaSerSuperior() {
    assertEquals(Categoria.SUPERIOR, TipoPrenda.CAMISA.getCategoria());
  }

  @Test
  void getCategoria_cuandoEsPantalon_deberiaSerInferior() {
    assertEquals(Categoria.INFERIOR, TipoPrenda.PANTALON.getCategoria());
  }

  @Test
  void getCategoria_cuandoEsZapato_deberiaSerCalzado() {
    assertEquals(Categoria.CALZADO, TipoPrenda.ZAPATO.getCategoria());
  }

  @Test
  void getCategoria_cuandoEsAnteojos_deberiaSerAccesorio() {
    assertEquals(Categoria.ACCESORIO, TipoPrenda.ANTEOJOS.getCategoria());
  }
}
