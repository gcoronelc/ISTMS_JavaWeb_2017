package pe.egcc.appeureka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public final class AccesoDB {

  /**
   * No se crean instancias de esta clase.
   */
  private AccesoDB() {
  }

  public static Connection getConnection() throws SQLException{
    // Datos para establecer la conexión
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://localhost:3306/eurekabank";
    String user = "eureka";
    String password = "admin";
    // Proceso para establece la conexión
    Connection cn = null;
    try {
      // Paso 1: Cargar el driver
      Class.forName(driver).newInstance();
      // Establecer la conexión
      cn = DriverManager.getConnection(urlDB, user, password);
    } catch (ClassNotFoundException e) {
      throw new SQLException("No se ha encontrado el driver.");
    } catch (SQLException e) {
      throw e;
    }catch(Exception e){
      throw new SQLException("Error, no se puede conectar con la BD.");
    }
    // Retorna la conexión
    return cn;
  }
  
  
  
}
