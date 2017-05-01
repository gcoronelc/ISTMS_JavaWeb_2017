package pe.egcc.eurekaapp.controller;

import pe.egcc.appeureka.model.EmpleadoModel;
import pe.egcc.appeureka.service.LogonService;
import pe.egcc.eurekaapp.util.Session;

public class LogonController {

  public void validarUsuario(String usuario, String clave) {
    LogonService logonService = new LogonService();
    EmpleadoModel bean = logonService.validarUsuario(usuario, clave);
    Session.put("usuario", bean);
  }
  
}
