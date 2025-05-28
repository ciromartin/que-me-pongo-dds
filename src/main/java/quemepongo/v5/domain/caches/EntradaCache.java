package quemepongo.v5.domain.caches;

import java.time.LocalDateTime;

public class EntradaCache<V> {
  private final V valor;
  private final LocalDateTime expiracion;

  public EntradaCache(V valor, LocalDateTime expiracion) {
    this.valor = valor;
    this.expiracion = expiracion;
  }

  public V getValor() {
    return valor;
  }

  public boolean expiro() {
    return LocalDateTime.now().isAfter(expiracion);
  }
}
