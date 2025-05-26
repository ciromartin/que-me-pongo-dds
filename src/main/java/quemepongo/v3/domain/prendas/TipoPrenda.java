package quemepongo.v3.domain.prendas;

public enum TipoPrenda {
  REMERA(Categoria.SUPERIOR),
  CAMISA(Categoria.SUPERIOR),
  CHOMBA(Categoria.SUPERIOR),
  PANTALON(Categoria.INFERIOR),
  SHORT(Categoria.INFERIOR),
  ZAPATO(Categoria.CALZADO),
  ZAPATILLA(Categoria.CALZADO),
  ANTEOJOS(Categoria.ACCESORIO);

  private Categoria categoria;

  TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }


  public boolean esSuperior() {
    return this.categoria == Categoria.SUPERIOR;
  }

  public boolean esInferior() {
    return this.categoria == Categoria.INFERIOR;
  }

  public boolean esCalzado() {
    return this.categoria == Categoria.CALZADO;
  }
}
