package pe.egcc.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.MateService;

@WebServlet(name = "AppController", 
        urlPatterns = {"/SumarController","/RestarController"})
public class AppController extends HttpServlet {

    private MateService mateService;

    @Override
    public void init() throws ServletException {
        mateService = new MateService();
    }
    
    @Override
    protected void service(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
    
        String path = request.getServletPath();
        switch(path){
            case "/SumarController":
                sumar(request,response);
                break;
            case "/RestarController":
                restar(request,response);
                break;
        }
        
    }

    private void sumar(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        // Datos
        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));
        // Proceso
        int suma = mateService.sumar(n1, n2);
        // Forward
        request.setAttribute("n1", n1);
        request.setAttribute("n2", n2);
        request.setAttribute("suma", suma);
        UtilController.forward(request, response, "sumar.jsp");
    }

    private void restar(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    
    
    

}
