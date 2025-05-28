package quemepongo.v5.domain.caches;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v5.domain.caches.ServicioCache;

public class ServicioCacheTest {
  private ServicioCache<String, String> cache;

  @BeforeEach
  void setUp() {
    cache = new ServicioCache<>();
  }

  @Test
  void guardar_y_obtener_deberiaDevolverElValorAlmacenado_siNoHaExpirado() {
    cache.guardar("clave", "valor", LocalDateTime.now().plusMinutes(10));
    assertEquals("valor", cache.obtener("clave"));
  }

  @Test
  void obtener_deberiaDevolverNull_siElValorHaExpirado() {
    cache.guardar("clave", "valor", LocalDateTime.now().minusMinutes(10));
    assertNull(cache.obtener("clave"));
  }

  @Test
  void contiene_deberiaDevolverTrue_siElValorNoHaExpirado() {
    cache.guardar("clave", "valor", LocalDateTime.now().plusMinutes(10));
    assertTrue(cache.contiene("clave"));
  }

  @Test
  void contiene_deberiaDevolverFalse_siElValorHaExpirado() {
    cache.guardar("clave", "valor", LocalDateTime.now().minusMinutes(10));
    assertFalse(cache.contiene("clave"));
  }

  @Test
  void obtener_deberiaEliminarElValor_siHaExpirado() {
    cache.guardar("clave", "valor", LocalDateTime.now().minusMinutes(10));
    cache.obtener("clave");
    assertFalse(cache.contiene("clave"));
  }
}
