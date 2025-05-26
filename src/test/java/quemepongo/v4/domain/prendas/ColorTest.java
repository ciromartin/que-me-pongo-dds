package quemepongo.v4.domain.prendas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ColorTest {
  @Test
  void constructor_cuandoValoresValidos_deberiaCrearColor() {
    Color color = new Color(100, 150, 200);
    assertEquals(100, color.getRojo());
    assertEquals(150, color.getVerde());
    assertEquals(200, color.getAzul());
  }

  @Test
  void constructor_cuandoValoresNegativos_deberiaLanzarExcepcion() {
    assertThrows(IllegalArgumentException.class, () -> new Color(-1, 100, 100));
  }

  @Test
  void constructor_cuandoValoresMayoresA255_deberiaLanzarExcepcion() {
    assertThrows(IllegalArgumentException.class, () -> new Color(256, 100, 100));
  }

  @Test
  void crearBlanco_deberiaCrearColorBlanco() {
    Color blanco = Color.crearBlanco();
    assertEquals(255, blanco.getRojo());
    assertEquals(255, blanco.getVerde());
    assertEquals(255, blanco.getAzul());
  }

  @Test
  void crearNegro_deberiaCrearColorNegro() {
    Color negro = Color.crearNegro();
    assertEquals(0, negro.getRojo());
    assertEquals(0, negro.getVerde());
    assertEquals(0, negro.getAzul());
  }

  @Test
  void crearRojo_deberiaCrearColorRojo() {
    Color rojo = Color.crearRojo();
    assertEquals(255, rojo.getRojo());
    assertEquals(0, rojo.getVerde());
    assertEquals(0, rojo.getAzul());
  }

  @Test
  void crearVerde_deberiaCrearColorVerde() {
    Color verde = Color.crearVerde();
    assertEquals(0, verde.getRojo());
    assertEquals(255, verde.getVerde());
    assertEquals(0, verde.getAzul());
  }

  @Test
  void crearAzul_deberiaCrearColorAzul() {
    Color azul = Color.crearAzul();
    assertEquals(0, azul.getRojo());
    assertEquals(0, azul.getVerde());
    assertEquals(255, azul.getAzul());
  }
}
