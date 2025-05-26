package quemepongo.v2.domain.sastres;

import quemepongo.v2.domain.prendas.Prenda;
import quemepongo.v2.domain.uniformes.Uniforme;

public abstract class Sastre {
  public Uniforme fabricarUniforme() {
    return new Uniforme(
        this.fabricarParteSuperior(),
        this.fabricarParteInferior(),
        this.fabricarCalzado()
    );
  }

  abstract Prenda fabricarParteSuperior();

  abstract Prenda fabricarParteInferior();

  abstract Prenda fabricarCalzado();
}
