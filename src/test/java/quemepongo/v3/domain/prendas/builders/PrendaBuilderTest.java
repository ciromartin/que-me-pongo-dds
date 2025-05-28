package quemepongo.v3.domain.prendas.builders;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import quemepongo.v3.domain.prendas.builders.PrendaBuilder;
import quemepongo.v3.domain.prendas.*;

public class PrendaBuilderTest {
  @Test
  void build_cuandoTieneTodosLosCamposObligatorios_deberiaCrearPrenda() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Categoria categoria  = tipo.getCategoria();
    Material material = Material.ALGODON;
    Color colorPrincipal = Color.crearNegro();

    Prenda prenda = new PrendaBuilder(tipo)
        .conMaterial(material)
        .conColorPrincipal(colorPrincipal)
        .build();

    assertEquals(tipo, prenda.getTipo());
    assertEquals(material, prenda.getMaterial());
    assertEquals(categoria, prenda.getCategoria());
    assertEquals(colorPrincipal, prenda.getColorPrincipal());
  }

  @Test
  void borrador_cuandoFaltanDatosObligatorios_deberiaPermitirCrearBorradorPeroNoConstruir() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Trama defaultTrama = Trama.LISO;

    // Crear un borrador sin todos los datos obligatorios
    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conColorPrincipal(Color.crearBlanco());

    Prenda borrador = builder.borrador();

    // Validar que el borrador se crea correctamente
    assertEquals(tipo, borrador.getTipo());
    assertEquals(Color.crearBlanco(), borrador.getColorPrincipal());
    assertEquals(defaultTrama, borrador.getTrama());
    assertNull(borrador.getMaterial());

    // Validar que al intentar construir con build lanza excepción
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals("El material es obligatorio", exception.getMessage());
  }

  @Test
  void continuarConstruccion_desdeBorrador_deberiaPermitirModificarCampos() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Color colorPrincipal = Color.crearBlanco();
    Trama trama = Trama.LISO;
    Material material = Material.LANA;
    Color colorSecundario = Color.crearAzul();

    // Crear un borrador inicial
    Prenda prendaInicial = new PrendaBuilder(tipo)
        .conColorPrincipal(colorPrincipal)
        .conTrama(trama)
        .conMaterial(material)
        .borrador();

    // Continuar la construcción desde el borrador
    Prenda prendaModificada = new PrendaBuilder(prendaInicial)
        .conColorSecundario(colorSecundario)
        .build();

    assertEquals(tipo, prendaModificada.getTipo());
    assertEquals(colorPrincipal, prendaModificada.getColorPrincipal());
    assertEquals(colorSecundario, prendaModificada.getColorSecundario());
    assertEquals(trama, prendaModificada.getTrama());
    assertEquals(material, prendaModificada.getMaterial());
  }

  @Test
  void borrador_cuandoTieneColorSecundario_deberiaCrearPrendaConColorSecundario() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Color colorPrincipal = Color.crearBlanco();
    Color colorSecundario = Color.crearAzul();
    Trama trama = Trama.LISO;
    Material material = Material.CUERO;

    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conColorPrincipal(colorPrincipal)
        .conColorSecundario(colorSecundario)
        .conTrama(trama)
        .conMaterial(material);

    Prenda prenda = builder.borrador();

    assertEquals(tipo, prenda.getTipo());
    assertEquals(colorPrincipal, prenda.getColorPrincipal());
    assertEquals(colorSecundario, prenda.getColorSecundario());
    assertEquals(trama, prenda.getTrama());
    assertEquals(material, prenda.getMaterial());
  }

  @Test
  void conMaterial_cuandoEsNulo_deberiaLanzarExcepcion() {
    PrendaBuilder builder = new PrendaBuilder(TipoPrenda.CAMISA);
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> builder.conMaterial(null)
    );
    assertEquals("el material no puede ser nulo", exception.getMessage());
  }

  @Test
  void conTrama_cuandoEsNulo_deberiaLanzarExcepcion() {
    PrendaBuilder builder = new PrendaBuilder(TipoPrenda.CAMISA);
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> builder.conTrama(null)
    );
    assertEquals("la Trama no puede ser nulo", exception.getMessage());
  }

  @Test
  void conColorPrincipal_cuandoEsNulo_deberiaLanzarExcepcion() {
    PrendaBuilder builder = new PrendaBuilder(TipoPrenda.CAMISA);
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> builder.conColorPrincipal(null)
    );
    assertEquals("el color principal no puede ser nulo", exception.getMessage());
  }

  @Test
  void conFormalidad_cuandoEsNulo_deberiaLanzarExcepcion() {
    PrendaBuilder builder = new PrendaBuilder(TipoPrenda.CAMISA);
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> builder.conFormalidad(null)
    );
    assertEquals("la formalidad no puede ser nula", exception.getMessage());
  }

  @Test
  void build_cuandoFaltaTipo_deberiaLanzarExcepcion() {
    PrendaBuilder builder = new PrendaBuilder((TipoPrenda) null)
        .conColorPrincipal(Color.crearBlanco())
        .conTrama(Trama.LISO)
        .conMaterial(Material.ALGODON);

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals("El tipo de prenda es obligatorio", exception.getMessage());
  }

  @Test
  void build_cuandoFaltaColorPrincipal_deberiaLanzarExcepcion() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conTrama(Trama.LISO)
        .conMaterial(Material.ALGODON);

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals("El color principal es obligatorio", exception.getMessage());
  }

  @Test
  void build_cuandoFaltaMaterial_deberiaLanzarExcepcion() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conColorPrincipal(Color.crearRojo());

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
    assertEquals("El material es obligatorio", exception.getMessage());
  }

  @Test
  void build_cuandoNoSeEspecificaTrama_deberiaAsignarTramaLisoPorDefecto() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Color colorPrincipal = Color.crearBlanco();
    Material material = Material.ALGODON;
    Trama defaultTrama = Trama.LISO;

    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conColorPrincipal(colorPrincipal)
        .conMaterial(material);

    Prenda prenda = builder.build();

    assertEquals(defaultTrama, prenda.getTrama());
  }

  @Test
  void build_cuandoNoSeEspecificaFormalidad_deberiaAsignarFormalidadNeutroPorDefecto() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Color colorPrincipal = Color.crearBlanco();
    Material material = Material.ALGODON;
    Formalidad defaultFormalidad = Formalidad.NEUTRO;

    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conColorPrincipal(colorPrincipal)
        .conMaterial(material);

    Prenda prenda = builder.build();

    assertEquals(defaultFormalidad, prenda.getFormalidad());
  }

    @Test
  void build_cuandoSeEspecificaFormalidad_deberiaSetearFormalidad() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Color colorPrincipal = Color.crearBlanco();
    Material material = Material.ALGODON;
    Formalidad formalidad = Formalidad.FORMAL;

    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conColorPrincipal(colorPrincipal)
        .conMaterial(material)
        .conFormalidad(formalidad);

    Prenda prenda = builder.build();

    assertEquals(formalidad, prenda.getFormalidad());
  }

}