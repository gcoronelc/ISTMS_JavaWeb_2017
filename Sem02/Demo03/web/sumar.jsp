<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SUMAR</title>
    </head>
    <body>
        <h1>SUMAR</h1>
        
        <form method="post" action="SumarController">
            <div>
                <label>Número 1:</label>
                <input type="text" name="num1"/>
            </div>
            <div>
                <label>Número 2:</label>
                <input type="text" name="num2"/>
            </div>
            <div>
                <input type="submit" value="Procesar"/>
            </div>
        </form>
        
        <% if( request.getAttribute("suma") != null ) { %>
        
            <h1>SUMA</h1>
            <p>Número 1: <%= request.getAttribute("n1") %></p>
            <p>Número 2: <%= request.getAttribute("n2") %></p>
            <p>Suma: <%= request.getAttribute("suma") %></p>
        
        <% } %>
        
    </body>
</html>
