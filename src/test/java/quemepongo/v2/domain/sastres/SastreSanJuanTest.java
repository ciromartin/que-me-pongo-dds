package quemepongo.v2.domain.sastres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v2.domain.prendas.*;
import quemepongo.v2.domain.uniformes.*;

public class SastreSanJuanTest {
  @Test
  void testFabricarParteSuperior() {
    SastreSanJuan sastre = new SastreSanJuan();
    Uniforme uniforme = sastre.fabricarUniforme();

    assertEquals(TipoPrenda.CHOMBA, uniforme.getPrendaSuperior().getTipo());
    assertEquals(Material.PIQUE, uniforme.getPrendaSuperior().getMaterial());
    assertEquals(Trama.LISO, uniforme.getPrendaSuperior().getTrama());
    assertEquals(Color.crearVerde(), uniforme.getPrendaSuperior().getColorPrincipal());

    assertEquals(TipoPrenda.PANTALON, uniforme.getPrendaInferior().getTipo());
    assertEquals(Material.ACETATO, uniforme.getPrendaInferior().getMaterial());
    assertEquals(Trama.LISO, uniforme.getPrendaInferior().getTrama());
    assertEquals(new Color(64, 64, 64), uniforme.getPrendaInferior().getColorPrincipal()); // Gris

    assertEquals(TipoPrenda.ZAPATO, uniforme.getPrendaCalzado().getTipo());
    assertEquals(Material.CUERO, uniforme.getPrendaCalzado().getMaterial());
    assertEquals(Trama.LISO, uniforme.getPrendaCalzado().getTrama());
    assertEquals(Color.crearBlanco(), uniforme.getPrendaCalzado().getColorPrincipal());
  }
}
