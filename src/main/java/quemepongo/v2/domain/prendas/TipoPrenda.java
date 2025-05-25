package quemepongo.v2.domain.prendas;

public enum TipoPrenda {
  CAMISA(Categoria.SUPERIOR),
  PANTALON(Categoria.INFERIOR),
  ZAPATO(Categoria.CALZADO),
  ANTEOJOS(Categoria.ACCESORIO);

  private Categoria categoria;

  TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }


}
