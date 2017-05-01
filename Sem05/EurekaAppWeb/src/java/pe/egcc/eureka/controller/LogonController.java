package pe.egcc.eureka.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.egcc.appeureka.model.EmpleadoModel;
import pe.egcc.appeureka.service.LogonService;

@WebServlet(name = "LogonController",
        urlPatterns = {"/LogonIngreso", "/LogonSalir"})
public class LogonController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path) {
      case "/LogonIngreso":
        ingreso(request, response);
        break;
      case "/LogonSalir":
        salir(request, response);
        break;
    }

  }

  private void salir(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    // Elimina datos de session
    request.getSession().invalidate();
    // forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }

  private void ingreso(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String destino = "";
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      LogonService service = new LogonService();
      EmpleadoModel bean = service.validarUsuario(usuario, clave);
      destino = "main.jsp";
      // Guardar usuario es session
      HttpSession session = request.getSession();
      session.setAttribute("usuario", bean);
    } catch (Exception e) {
      destino = "index.jsp";
      request.setAttribute("error", e.getMessage());
    }
    // forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

}
