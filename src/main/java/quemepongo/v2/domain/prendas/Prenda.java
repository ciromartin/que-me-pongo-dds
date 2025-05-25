package quemepongo.v2.domain.prendas;

public class Prenda {
  private TipoPrenda tipo;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;
  private Material material;

  public Prenda(TipoPrenda tipo,
                Color colorPrincipal,
                Color colorSecundario,
                Trama trama,
                Material material) {
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

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public Trama getTrama() {
    return trama;
  }

  public Material getMaterial() {
    return material;
  }
}
