package quemepongo.v4.domain.exceptions;

public class AtuendoNoValido extends RuntimeException {
    public AtuendoNoValido(String mensaje) {
        super(mensaje);
    }

    public AtuendoNoValido(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
