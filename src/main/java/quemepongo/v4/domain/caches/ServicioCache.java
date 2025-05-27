package quemepongo.v4.domain.caches;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioCache<K, V> implements Cache<K, V> {
  private final Map<K, EntradaCache<V>> cache = new HashMap<>();

  @Override
  public void guardar(K clave, V valor, LocalDateTime expiracion) {
    cache.put(clave, new EntradaCache<>(valor, expiracion));
  }

  @Override
  public V obtener(K clave) {
    EntradaCache<V> entrada = cache.get(clave);
    if (entrada == null || entrada.expiro()) {
      cache.remove(clave);
      return null;
    }
    return entrada.getValor();
  }

  @Override
  public boolean contiene(K clave) {
    EntradaCache<V> entrada = cache.get(clave);
    return entrada != null && !entrada.expiro();
  }
}
