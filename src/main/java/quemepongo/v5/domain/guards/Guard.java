package quemepongo.v5.domain.guards;

public class Guard {
  public static <T> T notNull(T atributo, String mensaje) {
    if (atributo == null) {
      throw new IllegalArgumentException(mensaje);
    }
    return atributo;
  }

  public static Integer validInteger(String valor, String mensaje) {
    try {
      return Integer.parseInt(valor);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(mensaje);
    }
  }
}
