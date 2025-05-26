package quemepongo.v2.domain.guards;

public class Guard {
  public static <T> T notNull(T atributo, String mensaje) {
    if (atributo == null) {
      throw new IllegalArgumentException(mensaje);
    }
    return atributo;
  }
}
