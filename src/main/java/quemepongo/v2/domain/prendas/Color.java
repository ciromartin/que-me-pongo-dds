package quemepongo.v2.domain.prendas;

import java.util.Objects;

public class Color {
  private int rojo;
  private int verde;
  private int azul;

  public Color(int rojo, int verde, int azul) {
    if (rojo < 0 || verde < 0 || azul < 0)
      throw new IllegalArgumentException("Los valores de color deben ser positivos");
    if (rojo > 255 || verde > 255 || azul > 255)
      throw new IllegalArgumentException("Los valores de color deben estar entre 0 y 255");

    this.rojo = rojo;
    this.verde = verde;
    this.azul = azul;
  }

  public int getAzul() {
    return azul;
  }

  public int getRojo() {
    return rojo;
  }

  public int getVerde() {
    return verde;
  }

  public static Color crearBlanco() {
    return new Color(255, 255, 255);
  }

  public static Color crearNegro() {
    return new Color(0, 0, 0);
  }

  public static Color crearRojo() {
    return new Color(255, 0, 0);
  }

  public static Color crearVerde() {
    return new Color(0, 255, 0);
  }

  public static Color crearAzul() {
    return new Color(0, 0, 255);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Color color = (Color) o;
    return rojo == color.rojo && verde == color.verde && azul == color.azul;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rojo, verde, azul);
  }
}
