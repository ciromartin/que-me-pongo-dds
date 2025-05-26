package quemepongo.v4.domain.guards;

public class Guard {
  public static <T> T notNull(T atributo, String mensaje) {
    if (atributo == null) {
      throw new IllegalArgumentException(mensaje);
    }
    return atributo;
  }
}
