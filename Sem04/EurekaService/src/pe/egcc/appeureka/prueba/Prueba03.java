package pe.egcc.appeureka.prueba;

import pe.egcc.appeureka.model.EmpleadoModel;
import pe.egcc.appeureka.service.LogonService;

public class Prueba03 {

  public static void main(String[] args) {
    try {
      // Datos
      String usuario = "creyes";
      String clave = "linda";
      // Proceso
      LogonService logonService = new LogonService();
      EmpleadoModel bean = logonService.validarUsuario(usuario, clave);
      // Reporte
      System.out.println("Codigo: " + bean.getCodigo());
      System.out.println("Nombre: " + bean.getNombre());
      System.out.println("Paterno: " + bean.getPaterno());
      System.out.println("Materno: " + bean.getMaterno());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
