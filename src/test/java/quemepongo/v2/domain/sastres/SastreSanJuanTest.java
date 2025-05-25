package quemepongo.v2.domain.sastres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v2.domain.prendas.*;
import quemepongo.v3.domain.prendas.Color;
import quemepongo.v3.domain.sastres.SastreSanJuan;
import quemepongo.v3.domain.uniformes.Uniforme;

public class SastreSanJuanTest {
  @Test
  void testFabricarParteSuperior() {
    quemepongo.v3.domain.sastres.SastreSanJuan sastre = new SastreSanJuan();
    Uniforme uniforme = sastre.fabricarUniforme();

    assertEquals(quemepongo.v3.domain.prendas.TipoPrenda.CHOMBA, uniforme.getPrendaSuperior().getTipo());
    assertEquals(quemepongo.v3.domain.prendas.Material.PIQUE, uniforme.getPrendaSuperior().getMaterial());
    assertEquals(quemepongo.v3.domain.prendas.Trama.LISO, uniforme.getPrendaSuperior().getTrama());
    assertEquals(quemepongo.v3.domain.prendas.Color.crearVerde(), uniforme.getPrendaSuperior().getColorPrincipal());

    assertEquals(quemepongo.v3.domain.prendas.TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    assertEquals(quemepongo.v3.domain.prendas.Material.ACETATO, uniforme.getPrendaInferior().getMaterial());
    assertEquals(quemepongo.v3.domain.prendas.Trama.LISO, uniforme.getPrendaInferior().getTrama());
    assertEquals(new quemepongo.v3.domain.prendas.Color(64, 64, 64), uniforme.getPrendaInferior().getColorPrincipal()); // Gris

    assertEquals(quemepongo.v3.domain.prendas.TipoPrenda.ZAPATO, uniforme.getPrendaCalzado().getTipo());
    assertEquals(quemepongo.v3.domain.prendas.Material.CUERO, uniforme.getPrendaCalzado().getMaterial());
    assertEquals(quemepongo.v3.domain.prendas.Trama.LISO, uniforme.getPrendaCalzado().getTrama());
    assertEquals(Color.crearBlanco(), uniforme.getPrendaCalzado().getColorPrincipal());
  }
}
