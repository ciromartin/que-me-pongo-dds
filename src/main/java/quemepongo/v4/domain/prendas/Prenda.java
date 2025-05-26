package quemepongo.v4.domain.prendas;

public class Prenda {
  private final TipoPrenda tipo;
  private final Material material;
  private final Trama trama;
  private final Formalidad formalidad;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  public Prenda(TipoPrenda tipo,
                Material material,
                Trama trama,
                Formalidad formalidad,
                Color colorPrincipal,
                Color colorSecundario) {
    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.formalidad = formalidad;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public Categoria getCategoria() {
    return tipo.getCategoria();
  }

  public boolean esSuperior() {
    return tipo.esSuperior();
  }

  public boolean esInferior() {
    return tipo.esInferior();
  }

  public boolean esCalzado() {
    return tipo.esCalzado();
  }

  public Material getMaterial() {
    return material;
  }

  public Trama getTrama() {
    return trama;
  }

  public boolean esInformal() {
    return formalidad == Formalidad.INFORMAL;
  }

  public Formalidad getFormalidad() {
    return formalidad;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
