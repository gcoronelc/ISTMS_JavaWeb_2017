package pe.egcc.appeureka.exception;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class EurekaException extends RuntimeException{

  public EurekaException() {
    super("Error en el proceso con EurekaBank.");
  }

  public EurekaException(String message) {
    super(message);
  }

}
