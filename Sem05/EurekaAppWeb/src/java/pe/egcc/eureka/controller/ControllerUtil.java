package pe.egcc.eureka.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.eureka.util.JsonModel;

public final class ControllerUtil {

  private ControllerUtil() {
  }
  
  private static Gson gson;
  
  static {
    gson = new Gson();
  }

  public static void sendResponse(
          HttpServletResponse response, JsonModel model) throws IOException{
    //response.setContentType("text/plain;charset=UTF-8");
    response.setContentType("application/json;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String jsonText = gson.toJson(model);
    out.write(jsonText);
    out.flush();
  }
    
}
