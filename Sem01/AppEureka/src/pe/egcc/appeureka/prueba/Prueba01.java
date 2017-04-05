package pe.egcc.appeureka.prueba;

import java.sql.Connection;
import pe.egcc.appeureka.db.AccesoDB;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    try {
      Connection cn = AccesoDB.getConnection();
      System.out.println("Ok.");
      Thread.sleep(10000);
      cn.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

}
