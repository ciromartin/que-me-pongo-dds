package quemepongo.v4.domain.asesores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.v4.domain.atuendos.Atuendo;
import quemepongo.v4.domain.climas.CondicionClimatica;
import quemepongo.v4.domain.climas.services.ServicioMetereologico;
import quemepongo.v4.domain.exceptions.AtuendoNoValido;
import quemepongo.v4.domain.sugerencias.MotorSugerencia;
import quemepongo.v4.domain.usuarios.Usuario;

public class AsesorImagenTest {
  private Usuario usuarioMock;
  private ServicioMetereologico servicioMetereologicoMock;
  private MotorSugerencia motorSugerenciaMock;
  private AsesorImagen asesorImagen;

  @BeforeEach
  void setUp() {
    usuarioMock = mock(Usuario.class);
    servicioMetereologicoMock = mock(ServicioMetereologico.class);
    motorSugerenciaMock = mock(MotorSugerencia.class);
    asesorImagen = new AsesorImagen(usuarioMock, servicioMetereologicoMock, motorSugerenciaMock);
  }

  @Test
  void sugerirAtuendo_deberiaLanzarExcepcion_siNoHayCondicionesClimaticas() {

    when(servicioMetereologicoMock.obtenerCondicionesClimaticas("Buenos Aires"))
        .thenReturn(List.of());

    AtuendoNoValido exception = assertThrows(AtuendoNoValido.class, () ->
        asesorImagen.sugerirAtuendo("Buenos Aires"));

    assertEquals("No se encontraron condiciones climáticas para la ciudad especificada.", exception.getMessage());
  }

  @Test
  void sugerirAtuendo_deberiaLanzarExcepcion_siNoHayAtuendosDisponibles() {

    CondicionClimatica condicionMock = mock(CondicionClimatica.class);
    when(condicionMock.getTemperatura()).thenReturn(25);
    when(servicioMetereologicoMock.obtenerCondicionesClimaticas("Buenos Aires"))
        .thenReturn(List.of(condicionMock));
    when(motorSugerenciaMock.sugerirAtuendos(usuarioMock))
        .thenReturn(List.of());

    AtuendoNoValido exception = assertThrows(AtuendoNoValido.class, () ->
        asesorImagen.sugerirAtuendo("Buenos Aires"));

    assertEquals("No se puede sugerir un atuendo porque no hay atuendos disponibles.", exception.getMessage());
  }

  @Test
  void sugerirAtuendo_deberiaLanzarExcepcion_siNoHayAtuendosApropiados() {

    CondicionClimatica condicionMock = mock(CondicionClimatica.class);
    when(condicionMock.getTemperatura()).thenReturn(25);

    Atuendo atuendoNoApropiado = mock(Atuendo.class);
    when(atuendoNoApropiado.esApropiadoParaClima(25)).thenReturn(false);

    when(servicioMetereologicoMock.obtenerCondicionesClimaticas("Buenos Aires"))
        .thenReturn(List.of(condicionMock));
    when(motorSugerenciaMock.sugerirAtuendos(usuarioMock))
        .thenReturn(List.of(atuendoNoApropiado));

    AtuendoNoValido exception = assertThrows(AtuendoNoValido.class, () ->
        asesorImagen.sugerirAtuendo("Buenos Aires"));

    assertEquals("No hay atuendos apropiados para las condiciones climáticas actuales.", exception.getMessage());
  }

  @Test
  void sugerirAtuendo_deberiaDevolverElPrimerAtuendoApropiado() {

    CondicionClimatica condicionMock = mock(CondicionClimatica.class);
    when(condicionMock.getTemperatura()).thenReturn(25);

    Atuendo atuendoApropiado = mock(Atuendo.class);
    when(atuendoApropiado.esApropiadoParaClima(25)).thenReturn(true);

    when(servicioMetereologicoMock.obtenerCondicionesClimaticas("Buenos Aires"))
        .thenReturn(List.of(condicionMock));
    when(motorSugerenciaMock.sugerirAtuendos(usuarioMock))
        .thenReturn(List.of(atuendoApropiado));

    Atuendo resultado = asesorImagen.sugerirAtuendo("Buenos Aires");

    assertEquals(atuendoApropiado, resultado);
    verify(servicioMetereologicoMock, times(1)).obtenerCondicionesClimaticas("Buenos Aires");
    verify(motorSugerenciaMock, times(1)).sugerirAtuendos(usuarioMock);
  }
}
