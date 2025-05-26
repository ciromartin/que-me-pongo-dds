package quemepongo.v3.domain.sastres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.prendas.*;
import quemepongo.v3.domain.sastres.SastreJohnson;
import quemepongo.v3.domain.atuendos.Atuendo;

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
