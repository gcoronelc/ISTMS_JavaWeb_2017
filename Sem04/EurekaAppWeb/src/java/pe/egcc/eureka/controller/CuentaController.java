package pe.egcc.eureka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.appeureka.service.CuentaService;
import pe.egcc.eureka.util.JsonModel;

@WebServlet(name = "CuentaController", 
        urlPatterns = {"/ConSaldo","/Algo"})
public class CuentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    
    String path = request.getServletPath();
    
    switch(path){
      case "/ConSaldo":
        conSaldo(request,response);
        break;
    }

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
