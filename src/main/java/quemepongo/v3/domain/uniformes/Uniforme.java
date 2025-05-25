package quemepongo.v3.domain.uniformes;

import quemepongo.v3.domain.guards.Guard;
import quemepongo.v3.domain.prendas.Categoria;
import quemepongo.v3.domain.prendas.Prenda;

public class Uniforme {
  private final Prenda prendaSuperior;
  private final Prenda prendaInferior;
  private final Prenda prendaCalzado;

  public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado) {
    Guard.notNull(prendaSuperior, "La prenda superior no puede ser nula");
    Guard.notNull(prendaInferior, "La prenda inferior no puede ser nula");
    Guard.notNull(prendaCalzado, "La prenda de calzado no puede ser nula");

    if (prendaSuperior.getCategoria() != Categoria.SUPERIOR) {
      throw new IllegalArgumentException("La prenda superior debe pertenecer a la categoría SUPERIOR");
    }
    if (prendaInferior.getCategoria() != Categoria.INFERIOR) {
      throw new IllegalArgumentException("La prenda inferior debe pertenecer a la categoría INFERIOR");
    }
    if (prendaCalzado.getCategoria() != Categoria.CALZADO) {
      throw new IllegalArgumentException("La prenda de calzado debe pertenecer a la categoría CALZADO");
    }

    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.prendaCalzado = prendaCalzado;
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getPrendaCalzado() {
    return prendaCalzado;
  }
}
