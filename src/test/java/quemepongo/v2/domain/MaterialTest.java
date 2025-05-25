package quemepongo.v2.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import quemepongo.v2.domain.prendas.Material;

public class MaterialTest {
  @Test
  void getNombre_cuandoEsAlgodon_deberiaDevolverAlgodon() {
    assertEquals("Algodon", Material.ALGODON.getNombre());
  }

  @Test
  void getNombre_cuandoEsLana_deberiaDevolverLana() {
    assertEquals("Lana", Material.LANA.getNombre());
  }

  @Test
  void getNombre_cuandoEsSeda_deberiaDevolverSeda() {
    assertEquals("Seda", Material.SEDA.getNombre());
  }

  @Test
  void getNombre_cuandoEsPoliester_deberiaDevolverPoliester() {
    assertEquals("Poliester", Material.POLIESTER.getNombre());
  }

  @Test
  void getNombre_cuandoEsCuero_deberiaDevolverCuero() {
    assertEquals("Cuero", Material.CUERO.getNombre());
  }

  @Test
  void getNombre_cuandoEsJean_deberiaDevolverJean() {
    assertEquals("Jean", Material.JEAN.getNombre());
  }
}
