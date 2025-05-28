package quemepongo.v5.domain.prendas;

public class Prenda {
  private final TipoPrenda tipo;
  private final Material material;
  private final Trama trama;
  private final Formalidad formalidad;
  private final Integer temperaturaMaxima;
  private final Color colorPrincipal;
  private final Color colorSecundario;

  public Prenda(TipoPrenda tipo,
                Material material,
                Trama trama,
                Formalidad formalidad,
                Integer temperaturaMaxima,
                Color colorPrincipal,
                Color colorSecundario) {
    this.tipo = tipo;
    this.material = material;
    this.trama = trama;
    this.formalidad = formalidad;
    this.temperaturaMaxima = temperaturaMaxima;
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

  public Integer getTemperaturaMaxima() {
    return temperaturaMaxima;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public boolean esApropiadoParaClima(Integer temperatura) {
    return temperatura <= this.temperaturaMaxima;
  }
}
