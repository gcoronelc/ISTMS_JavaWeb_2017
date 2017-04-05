package pe.egcc.appeureka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.appeureka.db.AccesoDB;
import pe.egcc.appeureka.exception.EurekaException;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class CuentaService {

  public double conSaldo(String cuenta){
    Connection cn = null;
    double saldo = 0.0;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select dec_cuensaldo from cuenta where chr_cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        saldo = rs.getDouble("dec_cuensaldo");
      } else {
        throw new EurekaException("Cuenta no existe.");
      }
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException("Error BD: " + e.getMessage());
    } catch (EurekaException e) {
      throw new RuntimeException("Error App: " + e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error: " + e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return saldo;
  }
  
  
}
