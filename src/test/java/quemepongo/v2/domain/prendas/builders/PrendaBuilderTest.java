package quemepongo.v2.domain.prendas.builders;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import quemepongo.v2.domain.prendas.*;

public class PrendaBuilderTest {
  @Test
  void build_cuandoTieneTodosLosCamposObligatorios_deberiaCrearPrenda() {
    TipoPrenda tipo = TipoPrenda.CAMISA;
    Categoria categoria  = Categoria.SUPERIOR;
    Color colorPrincipal = Color.crearNegro();
    Trama trama = Trama.LISO;
    Material material = Material.ALGODON;

    PrendaBuilder builder = new PrendaBuilder(tipo)
        .conColorPrincipal(colorPrincipal)
        .conTrama(trama)
        .conMaterial(material);

    Prenda prenda = builder.build();

    assertEquals(tipo, prenda.getTipo());
    assertEquals(categoria, prenda.getCategoria());
    assertEquals(colorPrincipal, prenda.getColorPrincipal());
    assertEquals(trama, prenda.getTrama());
    assertEquals(material, prenda.getMaterial());
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

}