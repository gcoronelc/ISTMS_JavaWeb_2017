package pe.egcc.eurekaapp.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GustavoCoronel
 */
public final class Session {
  
  private static final Map<String,Object> datos;

  static {
    datos = new HashMap<>();
  }
  
  private Session() {
  }
  
  /**
   * Guardar un objeto en session.
   * 
   * @param key Clave con que se guarda un objeto en session.
   * @param value Referencia al objeto que se guarda en session.
   */
  public static void put(String key, Object value){
    datos.put(key, value);
  }
  
  /**
   * Recuperar un objeto de session.
   * 
   * @param key Clave del objeto a recuperar.
   * @return Retorna el objeto recuperado de session.
   */
  public static Object get(String key){
    return datos.get(key);
  }
  
}
