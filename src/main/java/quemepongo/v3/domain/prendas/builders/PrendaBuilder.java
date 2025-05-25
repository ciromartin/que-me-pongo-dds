package quemepongo.v3.domain.prendas.builders;

import quemepongo.v3.domain.prendas.*;

public class PrendaBuilder {
  private TipoPrenda tipo;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;
  private Material material;

  public PrendaBuilder(TipoPrenda tipo) {
    this.clear();
    this.tipo = tipo;
  }

  public PrendaBuilder(Prenda prenda) {
    this.tipo = prenda.getTipo();
    this.colorPrincipal = prenda.getColorPrincipal();
    this.colorSecundario = prenda.getColorSecundario();
    this.trama = prenda.getTrama();
    this.material = prenda.getMaterial();
  }

  private void clear() {
    this.tipo = null;
    this.colorPrincipal = null;
    this.colorSecundario = null;
    this.trama = Trama.LISO;
    this.material = null;
  }

  public PrendaBuilder conColorPrincipal(Color color) {
    this.colorPrincipal = color;
    return this;
  }

  public PrendaBuilder conColorSecundario(Color color) {
    this.colorSecundario = color;
    return this;
  }

  public PrendaBuilder conTrama(Trama trama) {
    this.trama = trama;
    return this;
  }

  public PrendaBuilder conMaterial(Material material) {
    this.material = material;
    return this;
  }

  private void validarObligatorios() {
    if (tipo == null) throw new IllegalArgumentException("El tipo de prenda es obligatorio");
    if (colorPrincipal == null)
      throw new IllegalArgumentException("El color principal es obligatorio");
    if (trama == null) throw new IllegalArgumentException("La trama es obligatoria");
    if (material == null) throw new IllegalArgumentException("El material es obligatorio");
  }

  public Prenda borrador() {
    return new Prenda(
        this.tipo,
        this.colorPrincipal,
        this.colorSecundario,
        this.trama,
        this.material);
  }

  public Prenda build() {
    validarObligatorios();
    return new Prenda(
        this.tipo,
        this.colorPrincipal,
        this.colorSecundario,
        this.trama,
        this.material);
  }
}
