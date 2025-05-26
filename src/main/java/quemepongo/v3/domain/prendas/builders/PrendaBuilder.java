package quemepongo.v3.domain.prendas.builders;

import quemepongo.v3.domain.guards.Guard;
import quemepongo.v3.domain.prendas.*;

public class PrendaBuilder {
  private final Trama defaultTrama = Trama.LISO;
  private final Formalidad defaultFormalidad = Formalidad.NEUTRO;

  private TipoPrenda tipo;
  private Material material;
  private Trama trama = defaultTrama;
  private Formalidad formalidad = defaultFormalidad;
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
    this.trama = defaultTrama;
    this.formalidad = defaultFormalidad;
    this.colorPrincipal = null;
    this.colorSecundario = null;
  }

  public PrendaBuilder conMaterial(Material material) {
    Guard.notNull(material, "el material no puede ser nulo");
    this.material = material;
    return this;
  }

  public PrendaBuilder conTrama(Trama trama) {
    Guard.notNull(trama, "la Trama no puede ser nulo");
    this.trama = trama;
    return this;
  }

  public PrendaBuilder conFormalidad(Formalidad formalidad) {
    Guard.notNull(formalidad, "la formalidad no puede ser nula");
    this.formalidad = formalidad;
    return this;
  }

  public PrendaBuilder conColorPrincipal(Color color) {
    Guard.notNull(color, "el color principal no puede ser nulo");
    this.colorPrincipal = color;
    return this;
  }

  public PrendaBuilder conColorSecundario(Color color) {
    this.colorSecundario = color;
    return this;
  }

  private void validarObligatorios() {
    Guard.notNull(tipo, "El tipo de prenda es obligatorio");
    Guard.notNull(material, "El material es obligatorio");
    Guard.notNull(trama, "La trama es obligatoria");
    Guard.notNull(formalidad, "La Formalidad es obligatoria");
    Guard.notNull(colorPrincipal, "El color principal es obligatorio");
  }

  public Prenda borrador() {
    return new Prenda(
        this.tipo,
        this.material,
        this.trama,
        this.formalidad,
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
        this.formalidad,
        this.colorPrincipal,
        this.colorSecundario
    );
  }
}
