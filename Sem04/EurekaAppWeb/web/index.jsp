<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>INGRESO AL SISTEMA</h1>
    <form method="post" action="LogonIngreso">
      <div>
        <label>Usuario:</label>
        <input type="text" name="usuario" placeholder="Ingrese su usuario"/>
      </div>
      <div>
        <label>Clave:</label>
        <input type="password" name="clave" placeholder="Ingrese su clave"/>
      </div>
      <div>
        <input type="submit" value="Ingresar"/>
      </div>
      <c:if test="${error != null}" >
        <div style="color:red;">
        ${error}
      </div>
      </c:if>
    </form>
  </body>
</html>
