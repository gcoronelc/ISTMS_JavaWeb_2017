<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <p>Hola ${sessionScope.usuario.nombre}</p>
    <a href="LogonSalir">Chau</a>
  </body>
</html>
