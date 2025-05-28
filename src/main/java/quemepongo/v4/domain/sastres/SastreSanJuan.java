package quemepongo.v4.domain.sastres;

import quemepongo.v4.domain.prendas.*;
import quemepongo.v4.domain.prendas.builders.PrendaBuilder;

public class SastreSanJuan extends Sastre {
  @Override
  Prenda fabricarParteSuperior() {
    return new PrendaBuilder(TipoPrenda.CHOMBA)
        .conMaterial(Material.PIQUE)
        .conTrama(Trama.LISO)
        .conColorPrincipal(Color.crearVerde())
        .build();
  }

  @Override
  Prenda fabricarParteInferior() {
    return new PrendaBuilder(TipoPrenda.PANTALON)
        .conMaterial(Material.ACETATO)
        .conTrama(Trama.LISO)
        .conColorPrincipal(new Color(64, 64, 64)) // Gris
        .build();
  }

  @Override
  Prenda fabricarCalzado() {
    return new PrendaBuilder(TipoPrenda.ZAPATO)
        .conMaterial(Material.CUERO)
        .conTrama(Trama.LISO)
        .conColorPrincipal(Color.crearBlanco())
        .build();
  }
}
