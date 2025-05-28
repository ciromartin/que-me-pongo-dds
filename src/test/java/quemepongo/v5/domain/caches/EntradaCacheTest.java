package quemepongo.v5.domain.caches;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import quemepongo.v5.domain.caches.EntradaCache;

public class EntradaCacheTest {

  @Test
  void expiro_deberiaDevolverFalse_siLaFechaDeExpiracionEsFutura() {
    EntradaCache<String> entrada = new EntradaCache<>("valor", LocalDateTime.now().plusMinutes(10));
    assertFalse(entrada.expiro());
  }

  @Test
  void expiro_deberiaDevolverTrue_siLaFechaDeExpiracionEsPasada() {
    EntradaCache<String> entrada = new EntradaCache<>("valor", LocalDateTime.now().minusMinutes(10));
    assertTrue(entrada.expiro());
  }

  @Test
  void getValor_deberiaDevolverElValorAlmacenado() {
    EntradaCache<String> entrada = new EntradaCache<>("valor", LocalDateTime.now().plusMinutes(10));
    assertEquals("valor", entrada.getValor());
  }
}
