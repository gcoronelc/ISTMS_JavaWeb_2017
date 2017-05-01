<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR SALDO</title>
  </head>
  <body>
    <h1>CONSULTAR SALDO</h1>
    <form id="form1">
      <div>
        <label>Cuenta:</label><br/>
        <input type="text" name="cuenta"/>
        <input type="button" value="Consultar" 
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
        $.post("ConSaldo",data,function(model){
          var texto;
          if(model.code == -1){
            texto = "<p class='error'>" + model.rpta + "</p>";
          } else {
            texto = "<p class='info'>Saldo: " + model.rpta + "</p>";
          }
          $("#divRpta").html(texto);
          $("#divRpta").show("slow");
        });
      }
      
      
    </script>
  </body>
</html>
