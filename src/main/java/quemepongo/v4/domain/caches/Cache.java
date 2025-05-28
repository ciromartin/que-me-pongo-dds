package quemepongo.v4.domain.caches;

import java.time.LocalDateTime;

public interface Cache<K, V> {
  void guardar(K clave, V valor, LocalDateTime expiracion);

  V obtener(K clave);

  boolean contiene(K clave);
}
