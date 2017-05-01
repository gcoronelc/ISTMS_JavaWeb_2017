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
  
  
  public int procRetiro(String cuenta, double importe, 
          String clave, String codEmp){
    int nroOpera = 0;
    // ----------------------------------------------------------
    Connection cn = null;
    try {
      // Inicio de Tx
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      // Actualizar el saldo
      String sql = "select dec_cuensaldo from cuenta "
              + "where chr_cuencodigo = ? "
              + "and vch_cuenestado = 'ACTIVO' "
              + "and chr_cuenclave = ? "
              + "for update ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new SQLException("Datos incorrectos.");
      }
      double saldo = rs.getDouble("dec_cuensaldo");
      rs.close();
      pstm.close();
      Thread.currentThread().sleep(2000);
      if(saldo < importe){
        throw new SQLException("Saldo insuficiente.");
      }
      saldo = saldo - importe;
      sql = "update cuenta set dec_cuensaldo = ? "
              + "where chr_cuencodigo = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setString(2, cuenta);
      int filas = pstm.executeUpdate();
      pstm.close();
      if(filas != 1){
        throw new SQLException("No se puede actualizar la cuenta.");
      }
      // Obtener el nro. de operacion
      sql = "select int_cuencontmov from cuenta "
              + "where chr_cuencodigo = ? "
              + "and vch_cuenestado = 'ACTIVO' "
              + "and chr_cuenclave = ? "
              + "for update ";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setString(2, clave);
      rs = pstm.executeQuery();
      if(!rs.next()){
        throw new SQLException("Datos incorrectos.");
      }
      nroOpera = rs.getInt("int_cuencontmov") + 1;
      rs.close();
      pstm.close();
      sql = "update cuenta set int_cuencontmov = ? "
              + "where chr_cuencodigo = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, nroOpera);
      pstm.setString(2, cuenta);
      filas = pstm.executeUpdate();
      pstm.close();;
      if(filas != 1){
        throw new SQLException("No se puede actualizar el contador.");
      }
      // Registrar movimiento
      sql = "insert into movimiento(chr_cuencodigo,int_movinumero,"
              + "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
              + "dec_moviimporte) values(?,?,SYSDATE(),?,'004',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, nroOpera);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.close();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch(Exception e){
      try {
        cn.close();
      } catch (Exception e1) {
      }
      throw new RuntimeException("No se puede ejecutar el proceso.");      
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    // ----------------------------------------------------------
    return nroOpera;
  }

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
