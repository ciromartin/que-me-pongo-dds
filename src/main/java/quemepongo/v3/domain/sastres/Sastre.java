package quemepongo.v3.domain.sastres;

import quemepongo.v3.domain.atuendos.Atuendo;
import quemepongo.v3.domain.prendas.Prenda;


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
