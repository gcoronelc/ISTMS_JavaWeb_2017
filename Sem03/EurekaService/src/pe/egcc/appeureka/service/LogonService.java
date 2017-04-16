package pe.egcc.appeureka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.appeureka.db.AccesoDB;
import pe.egcc.appeureka.exception.EurekaException;
import pe.egcc.appeureka.model.EmpleadoModel;

public class LogonService {

  public EmpleadoModel validarUsuario(String usuario, String clave) {
    EmpleadoModel bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo,vch_emplpaterno,"
              + "vch_emplmaterno,vch_emplnombre,"
              + "vch_emplciudad,vch_empldireccion,"
              + "vch_emplusuario from empleado "
              + "where vch_emplusuario = ? "
              + "and vch_emplclave = ? "
              + "and chr_emplcodigo in "
              + "( select chr_emplcodigo from asignado "
              + "where dtt_asigfechabaja is null )";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new EurekaException("Datos son incorrectos");
      }
      bean = new EmpleadoModel();
      bean.setCodigo(rs.getString("chr_emplcodigo"));
      bean.setPaterno(rs.getString("vch_emplpaterno"));
      bean.setMaterno(rs.getString("vch_emplmaterno"));
      bean.setNombre(rs.getString("vch_emplnombre"));
      bean.setCiudad(rs.getString("vch_emplciudad"));
      bean.setDireccion(rs.getString("vch_empldireccion"));
      bean.setUsuario(rs.getString("vch_emplusuario"));
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException("Error BD: " + e.getMessage());
    } catch (EurekaException e) {
      throw new RuntimeException("Error App: " + e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error: " + e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

}
