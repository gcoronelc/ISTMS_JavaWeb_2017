<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table style="width: 100%;">
  <tr>
    <td>
      <img src="img/logo3.gif" alt=""/>
    </td>
    <td>
      Usuario: ${sessionScope.usuario.nombre} 
      ${sessionScope.usuario.paterno} 
      ${sessionScope.usuario.materno} <br/>
      <a href="LogonSalir">Salir</a>
    </td>
  </tr>
</table>