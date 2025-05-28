package quemepongo.v4.domain.sastres;

import quemepongo.v4.domain.atuendos.Atuendo;
import quemepongo.v4.domain.prendas.Prenda;


public abstract class Sastre {
  public Atuendo fabricarAtuendo() {
    return new Atuendo(
        this.fabricarParteSuperior(),
        this.fabricarParteInferior(),
        this.fabricarCalzado()
    );
  }

  abstract Prenda fabricarParteSuperior();

  abstract Prenda fabricarParteInferior();

  abstract Prenda fabricarCalzado();
}
