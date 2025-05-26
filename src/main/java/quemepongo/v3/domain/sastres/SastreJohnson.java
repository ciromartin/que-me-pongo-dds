package quemepongo.v3.domain.sastres;


import quemepongo.v3.domain.prendas.*;
import quemepongo.v3.domain.prendas.builders.PrendaBuilder;

public class SastreJohnson extends Sastre {
  @Override
  Prenda fabricarParteSuperior() {
    return new PrendaBuilder(TipoPrenda.CAMISA)
        .conMaterial(Material.ALGODON)
        .conTrama(Trama.LISO)
        .conColorPrincipal(Color.crearBlanco())
        .build();
  }

  @Override
  Prenda fabricarParteInferior() {
    return new PrendaBuilder(TipoPrenda.PANTALON)
        .conMaterial(Material.POLIESTER)
        .conTrama(Trama.LISO)
        .conColorPrincipal(Color.crearNegro())
        .build();
  }

  @Override
  Prenda fabricarCalzado() {
    return new PrendaBuilder(TipoPrenda.ZAPATO)
        .conMaterial(Material.CUERO)
        .conTrama(Trama.LISO)
        .conColorPrincipal(Color.crearNegro())
        .build();
  }
}
