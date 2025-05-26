package quemepongo.v3.domain.prendas;

public enum Material {
  ALGODON("Algodon"),
  LANA("Lana"),
  SEDA("Seda"),
  POLIESTER("Poliester"),
  TELA("Tela"),
  CUERO("Cuero"),
  JEAN("Jean"),
  PIQUE("Pique"),
  ACETATO("Acetato");

  private final String nombre;

  Material(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }
}
