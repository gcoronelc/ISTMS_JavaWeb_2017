<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// Datos
int n1 = Integer.parseInt(request.getParameter("num1"));
int n2 = Integer.parseInt(request.getParameter("num2"));
// Proceso
int suma = n1 + n2;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SUMA</h1>
        <p>Número 1: <%=n1%></p>
        <p>Número 2: <%=n2%></p>
        <p>Suma: <%=suma%></p>
        <p><a href="index.html">Retornar</a></p>
    </body>
</html>
