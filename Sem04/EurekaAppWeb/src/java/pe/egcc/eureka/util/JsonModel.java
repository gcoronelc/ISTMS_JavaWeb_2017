package pe.egcc.eureka.util;

public class JsonModel {

  private int code; // 1 (ok) o -1 (Error)
  private String rpta; // Respuesta

  public JsonModel() {
  }

  public JsonModel(int code, String rpta) {
    this.code = code;
    this.rpta = rpta;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getRpta() {
    return rpta;
  }

  public void setRpta(String rpta) {
    this.rpta = rpta;
  }

  
}
