package quemepongo.v5.domain.sastres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v5.domain.atuendos.Atuendo;
import quemepongo.v5.domain.prendas.Color;
import quemepongo.v5.domain.prendas.Material;
import quemepongo.v5.domain.prendas.TipoPrenda;
import quemepongo.v5.domain.prendas.Trama;
import quemepongo.v5.domain.sastres.SastreJohnson;

public class SastreJohnsonTest {
  @Test
  void testFabricarUniforme() {
    SastreJohnson sastre = new SastreJohnson();
    Atuendo uniforme = sastre.fabricarAtuendo();

    assertEquals(TipoPrenda.CAMISA, uniforme.getPrendaSuperior().getTipo());
    assertEquals(Material.ALGODON, uniforme.getPrendaSuperior().getMaterial());
    assertEquals(Trama.LISO, uniforme.getPrendaSuperior().getTrama());
    assertEquals(Color.crearBlanco(), uniforme.getPrendaSuperior().getColorPrincipal());

    assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    assertEquals(Material.POLIESTER, uniforme.getPrendaInferior().getMaterial());
    assertEquals(Trama.LISO, uniforme.getPrendaInferior().getTrama());
    assertEquals(Color.crearNegro(), uniforme.getPrendaInferior().getColorPrincipal());

    assertEquals(TipoPrenda.ZAPATO, uniforme.getPrendaCalzado().getTipo());
    assertEquals(Material.CUERO, uniforme.getPrendaCalzado().getMaterial());
    assertEquals(Trama.LISO, uniforme.getPrendaCalzado().getTrama());
    assertEquals(Color.crearNegro(), uniforme.getPrendaCalzado().getColorPrincipal());
  }
}
