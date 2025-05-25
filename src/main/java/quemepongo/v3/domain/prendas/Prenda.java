package quemepongo.v3.domain.prendas;

public class Prenda {
  private final TipoPrenda tipo;
  private final Material material;
  private final Trama trama;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  public Prenda(TipoPrenda tipo,
                Material material,
                Trama trama,
                Color colorPrincipal,
                Color colorSecundario) {
    this.tipo = tipo;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
    this.material = material;
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public Categoria getCategoria() {
    return tipo.getCategoria();
  }

  public Material getMaterial() {
    return material;
  }

  public Trama getTrama() {
    return trama;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
