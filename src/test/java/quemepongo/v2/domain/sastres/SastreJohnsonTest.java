package quemepongo.v2.domain.sastres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v2.domain.prendas.*;
import quemepongo.v3.domain.prendas.Color;
import quemepongo.v3.domain.sastres.SastreJohnson;
import quemepongo.v3.domain.uniformes.Uniforme;

public class SastreJohnsonTest {
  @Test
  void testFabricarUniforme() {
    quemepongo.v3.domain.sastres.SastreJohnson sastre = new SastreJohnson();
    Uniforme uniforme = sastre.fabricarUniforme();

    assertEquals(quemepongo.v3.domain.prendas.TipoPrenda.CAMISA, uniforme.getPrendaSuperior().getTipo());
    assertEquals(quemepongo.v3.domain.prendas.Material.ALGODON, uniforme.getPrendaSuperior().getMaterial());
    assertEquals(quemepongo.v3.domain.prendas.Trama.LISO, uniforme.getPrendaSuperior().getTrama());
    assertEquals(quemepongo.v3.domain.prendas.Color.crearBlanco(), uniforme.getPrendaSuperior().getColorPrincipal());

    assertEquals(quemepongo.v3.domain.prendas.TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    assertEquals(quemepongo.v3.domain.prendas.Material.POLIESTER, uniforme.getPrendaInferior().getMaterial());
    assertEquals(quemepongo.v3.domain.prendas.Trama.LISO, uniforme.getPrendaInferior().getTrama());
    assertEquals(quemepongo.v3.domain.prendas.Color.crearNegro(), uniforme.getPrendaInferior().getColorPrincipal());

    assertEquals(quemepongo.v3.domain.prendas.TipoPrenda.ZAPATO, uniforme.getPrendaCalzado().getTipo());
    assertEquals(quemepongo.v3.domain.prendas.Material.CUERO, uniforme.getPrendaCalzado().getMaterial());
    assertEquals(quemepongo.v3.domain.prendas.Trama.LISO, uniforme.getPrendaCalzado().getTrama());
    assertEquals(Color.crearNegro(), uniforme.getPrendaCalzado().getColorPrincipal());
  }
}
