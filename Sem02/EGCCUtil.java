package pe.devida.priorizacion.util;

/**
 * Clase de métodos genericos.
 *
 * @author Gustavo Coronel
 */
public final class EGCCUtil {
  
  public static final int PERIODO = 2017;

  private EGCCUtil() {
  }

  // Constantes del CRUD
  public static final String CRUD_NUEVO = "NUEVO";
  public static final String CRUD_EDITAR = "EDITAR";
  public static final String CRUD_ELIMINAR = "ELIMINAR";
  
  
  public static String aString(String value) {
    if (value == null) {
      value = "";
    }
    return value;
  }
  
  
}
