package pe.egcc.appeureka.prueba;

import pe.egcc.appeureka.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class Prueba02 {
   
  public static void main(String[] args) {
    try {
      // Dato
      String cuenta = "00100001";
      // Proceso
      CuentaService cuentaService = new CuentaService();
      double saldo = cuentaService.conSaldo(cuenta);
      // Reporte
      System.out.println("Cuenta: " + cuenta);
      System.out.println("Saldo: " + saldo);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

}
