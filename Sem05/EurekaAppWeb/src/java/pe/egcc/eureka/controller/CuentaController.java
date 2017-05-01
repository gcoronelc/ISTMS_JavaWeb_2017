package pe.egcc.eureka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.egcc.appeureka.model.EmpleadoModel;
import pe.egcc.appeureka.service.CuentaService;
import pe.egcc.eureka.util.JsonModel;

@WebServlet(name = "CuentaController",
        urlPatterns = {"/ConSaldo", "/ProcRetiro"})
public class CuentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {

    String path = request.getServletPath();

    switch (path) {
      case "/ConSaldo":
        conSaldo(request, response);
        break;
      case "/ProcRetiro":
        procRetiro(request, response);
        break;
    }

  }

  private void procRetiro(HttpServletRequest request, HttpServletResponse response) throws IOException {
    JsonModel model = new JsonModel();
    try {
      // Datos del formulario
      String cuenta = request.getParameter("cuenta");
      String clave = request.getParameter("clave");
      double importe = Double.parseDouble(request.getParameter("importe"));
      // Codigo del empleado se obtiene de la sesion
      HttpSession session = request.getSession();
      EmpleadoModel emp = (EmpleadoModel) session.getAttribute("usuario");      
      // Proceso
      CuentaService service = new CuentaService();
      int no = service.procRetiro(cuenta, importe, clave, emp.getCodigo());
      // Respuest
      model.setCode(1);
      model.setRpta("Número de operación: " + no);
    } catch (Exception e) {
      e.printStackTrace();
      model.setCode(-1);
      model.setRpta(e.getMessage());
    }
    // Lanzar la respuesta
    ControllerUtil.sendResponse(response, model);
  }

  private void conSaldo(HttpServletRequest request,
          HttpServletResponse response) throws IOException {
    JsonModel model = new JsonModel();
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      // Proceso
      CuentaService service = new CuentaService();
      double saldo = service.conSaldo(cuenta);
      // Respuest
      model.setCode(1);
      model.setRpta(String.valueOf(saldo));
    } catch (Exception e) {
      model.setCode(-1);
      model.setRpta(e.getMessage());
    }
    // Lanzar la respuesta
    ControllerUtil.sendResponse(response, model);
  }

}
