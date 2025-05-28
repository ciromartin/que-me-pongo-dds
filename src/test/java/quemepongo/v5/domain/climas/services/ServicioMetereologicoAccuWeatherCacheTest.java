package quemepongo.v5.domain.climas.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v5.domain.caches.Cache;
import quemepongo.v5.domain.climas.CondicionClimatica;
import quemepongo.v5.domain.climas.services.ServicioMetereologico;
import quemepongo.v5.domain.climas.services.ServicioMetereologicoAccuWeatherCache;

public class ServicioMetereologicoAccuWeatherCacheTest {
  private Cache cacheMock;
  private quemepongo.v5.domain.climas.services.ServicioMetereologico servicioMetereologicoMock;
  private quemepongo.v5.domain.climas.services.ServicioMetereologicoAccuWeatherCache servicioCache;
  private static final String CIUDAD = "Buenos Aires";

  @BeforeEach
  void setUp() {
    cacheMock = mock(Cache.class);
    servicioMetereologicoMock = mock(ServicioMetereologico.class);
    servicioCache = new ServicioMetereologicoAccuWeatherCache(
        Duration.ofMinutes(10), cacheMock, servicioMetereologicoMock);
  }

  @Test
  void obtenerCondicionesClimaticas_deberiaUsarElCache_siEstaPresente() {
    List<CondicionClimatica> condicionesMock = List.of(
        new CondicionClimatica(CIUDAD, "Clear", "25", "C")
    );
    when(cacheMock.contiene(CIUDAD)).thenReturn(true);
    when(cacheMock.obtener(CIUDAD)).thenReturn(condicionesMock);

    List<CondicionClimatica> condiciones = servicioCache.obtenerCondicionesClimaticas(CIUDAD);

    assertEquals(condicionesMock, condiciones);
    verify(cacheMock, times(1)).contiene(CIUDAD);
    verify(cacheMock, times(1)).obtener(CIUDAD);
    verifyNoInteractions(servicioMetereologicoMock);
  }

  @Test
  void obtenerCondicionesClimaticas_deberiaConsultarServicio_siNoEstaEnCache() {
    List<CondicionClimatica> condicionesMock = List.of(
        new CondicionClimatica(CIUDAD, "Clear", "25", "C")
    );
    when(cacheMock.contiene(CIUDAD)).thenReturn(false);
    when(servicioMetereologicoMock.obtenerCondicionesClimaticas(CIUDAD)).thenReturn(condicionesMock);

    List<CondicionClimatica> condiciones = servicioCache.obtenerCondicionesClimaticas(CIUDAD);

    assertEquals(condicionesMock, condiciones);
    verify(cacheMock, times(1)).contiene(CIUDAD);
    verify(servicioMetereologicoMock, times(1)).obtenerCondicionesClimaticas(CIUDAD);
    verify(cacheMock, times(1)).guardar(eq(CIUDAD), eq(condicionesMock), any(LocalDateTime.class));
  }
}
