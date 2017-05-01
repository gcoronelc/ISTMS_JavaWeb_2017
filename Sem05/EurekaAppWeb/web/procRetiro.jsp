<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PROCESO RETIRO</title>
  </head>
  <body>
    <h1>PROCESO RETIRO</h1>
    <form id="form1">
      <div>
        <label>Cuenta:</label>
        <input type="text" name="cuenta"/>
      </div>
      <div>
        <label>Importe:</label>
        <input type="text" name="importe"/>
      </div>
      <div>
        <label>Clave:</label>
        <input type="password" name="clave"/>
      </div>
      
      <div>
        <input type="button" value="Procesar" 
               id="btnProcesar"/>
      </div>
      <div id="divRpta">
        Respuesta ...
      </div>
    </form>
    <script>
      
      $("#btnProcesar").click(fnProcesar);
      
      function fnProcesar(){
        $("#divRpta").hide();
        var data = $("#form1").serialize();
        $.post("ProcRetiro",data,function(model){
          var texto;
          if(model.code == -1){
            texto = "<p class='error'>" + model.rpta + "</p>";
          } else {
            texto = "<p class='info'>" + model.rpta + "</p>";
          }
          $("#divRpta").html(texto);
          $("#divRpta").show("slow");
        });
      }
      
      
    </script>
  </body>
</html>
