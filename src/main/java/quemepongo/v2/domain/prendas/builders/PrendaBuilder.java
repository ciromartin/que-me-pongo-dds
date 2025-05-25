package quemepongo.v2.domain.prendas.builders;

import quemepongo.v2.domain.prendas.*;

public class PrendaBuilder {
  private TipoPrenda tipo;
  private Material material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecundario;

  public PrendaBuilder(TipoPrenda tipo) {
    this.clear();
    this.tipo = tipo;
  }

  public PrendaBuilder(Prenda prenda) {
    this.tipo = prenda.getTipo();
    this.material = prenda.getMaterial();
    this.trama = prenda.getTrama();
    this.colorPrincipal = prenda.getColorPrincipal();
    this.colorSecundario = prenda.getColorSecundario();
  }

  private void clear() {
    this.tipo = null;
    this.material = null;
    this.trama = Trama.LISO;
    this.colorPrincipal = null;
    this.colorSecundario = null;
  }

  public PrendaBuilder conMaterial(Material material) {
    this.material = material;
    return this;
  }

  public PrendaBuilder conTrama(Trama trama) {
    this.trama = trama;
    return this;
  }

  public PrendaBuilder conColorPrincipal(Color color) {
    this.colorPrincipal = color;
    return this;
  }

  public PrendaBuilder conColorSecundario(Color color) {
    this.colorSecundario = color;
    return this;
  }

  private void validarObligatorios() {
    if (tipo == null) throw new IllegalArgumentException("El tipo de prenda es obligatorio");
    if (material == null) throw new IllegalArgumentException("El material es obligatorio");
    if (trama == null) throw new IllegalArgumentException("La trama es obligatoria");
    if (colorPrincipal == null) throw new IllegalArgumentException("El color principal es obligatorio");
  }

  public Prenda borrador() {
    return new Prenda(
        this.tipo,
        this.material,
        this.trama,
        this.colorPrincipal,
        this.colorSecundario
    );
  }

  public Prenda build() {
    validarObligatorios();
    return new Prenda(
        this.tipo,
        this.material,
        this.trama,
        this.colorPrincipal,
        this.colorSecundario
    );
  }
}
