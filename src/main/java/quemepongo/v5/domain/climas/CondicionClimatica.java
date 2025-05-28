package quemepongo.v5.domain.climas;

import quemepongo.v5.domain.guards.Guard;

public class CondicionClimatica {
  private final String ciudad;
  private final Integer temperatura;
  private final String descripcion;
  private final String unidadTemperatura;

  public CondicionClimatica(String ciudad, String descripcion, String temperatura, String unidadTemperatura) {
    this.ciudad = Guard.notNull(ciudad, "La ciudad no puede ser nula");
    this.descripcion = Guard.notNull(descripcion, "La descripción no puede ser nula");
    String temp = Guard.notNull(temperatura, "La temperatura no puede ser nula");
    this.temperatura = Guard.validInteger(temp, "La temperatura debe ser un número entero válido");
    this.unidadTemperatura = Guard.notNull(unidadTemperatura, "La unidad de temperatura no puede ser nula");

  }

  public String getCiudad() {
    return ciudad;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public Integer getTemperatura() {
    return temperatura;
  }

  public String getUnidadTemperatura() {
    return unidadTemperatura;
  }
}
