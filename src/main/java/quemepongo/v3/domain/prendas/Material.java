package quemepongo.v3.domain.prendas;

public enum Material {
  ALGODON("Algodon"),
  LANA("Lana"),
  SEDA("Seda"),
  POLIESTER("Poliester"),
  CUERO("Cuero"),
  JEAN("Jean");

  private final String nombre;

  Material(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }
}
