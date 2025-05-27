package quemepongo.v4.domain.climas.apis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import quemepongo.v4.domain.climas.CondicionClimatica;

public class RespuestaAccuWeather {
  public static List<CondicionClimatica> mapearACondicionesClimaticas(String ciudad, List<Map<String, Object>> datosClimaticos) {
    return datosClimaticos.stream()
        .map(estadoDelTiempo -> {
          Object temperaturaObj = estadoDelTiempo.get("Temperature");
          Map<String, Object> temperaturaMap = (temperaturaObj instanceof Map) ? (Map<String, Object>) temperaturaObj : null;
          String temperatura = temperaturaMap != null ? String.valueOf(temperaturaMap.get("Value")) : null;
          String unidadTemperatura = temperaturaMap != null ? (String) temperaturaMap.get("Unit") : null;
          String descripcion = (String) estadoDelTiempo.get("IconPhrase");

          return new CondicionClimatica(ciudad, descripcion, temperatura, unidadTemperatura);
        })
        .collect(Collectors.toList());
  }
}
