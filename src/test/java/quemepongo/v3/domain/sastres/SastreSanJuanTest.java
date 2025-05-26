package quemepongo.v3.domain.sastres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.prendas.*;
import quemepongo.v3.domain.sastres.SastreSanJuan;
import quemepongo.v3.domain.atuendos.Atuendo;

public class SastreSanJuanTest {
  @Test
  void testFabricarParteSuperior() {
    SastreSanJuan sastre = new SastreSanJuan();
    Atuendo uniforme = sastre.fabricarAtuendo();

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
