package quemepongo.v2.domain.sastres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v2.domain.prendas.*;
import quemepongo.v2.domain.sastres.*;
import quemepongo.v2.domain.uniformes.Uniforme;

public class SastreJohnsonTest {
  @Test
  void testFabricarUniforme() {
    SastreJohnson sastre = new SastreJohnson();
    Uniforme uniforme = sastre.fabricarUniforme();

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
