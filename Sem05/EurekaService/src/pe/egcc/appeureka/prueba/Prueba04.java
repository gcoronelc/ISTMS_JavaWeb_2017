package pe.egcc.appeureka.prueba;

import pe.egcc.appeureka.service.CuentaService;

public class Prueba04 {

  public static void main(String[] args) {
    try {
      // Datos
      String cuenta = "00100001";
      double importe = 100.0;
      String clave = "123456";
      String codEmp = "0003";
      // Proceso
      CuentaService service = new CuentaService();
      int no = service.procRetiro(cuenta, importe, clave, codEmp);
      // Reporte
      System.out.println("Operación: " + no);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
