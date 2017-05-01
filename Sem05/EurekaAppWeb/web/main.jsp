<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EUREKA APP WEB</title>
    <link href="css/egcc.css" rel="stylesheet" type="text/css"/>
    <link href="menu/menu.css" rel="stylesheet" type="text/css"/>
    <script src="jquery/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="js/egcc.js" type="text/javascript"></script>
  </head>
  <body>
    <div class="_PAGE">
      <div class="_HEADER">
        <jsp:include page="header.jsp" />
      </div>
      <div class="_MENU">
        <jsp:include page="menu/menu.jsp"/>
      </div>
      <div class="_BODY" id="_BODY">
        <div style="text-align: center;">
          <img src="img/main.jpg" alt=""/>
        </div>
      </div>
      <div class="_FOOTER">
        <jsp:include page="footer.jsp" />
      </div>
    </div>
  </body>
</html>
