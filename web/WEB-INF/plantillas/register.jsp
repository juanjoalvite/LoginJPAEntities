<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../../css/estilos.css" rel="stylesheet" type="text/css"/>
    </head> 
    <body>

        <div class="form">
            <%
                if (request.getAttribute("errorMessage") != null) {
                    out.println("<p class='error-message'>" + request.getAttribute("errorMessage") + "</p>");
                }
            %>
            <form method="POST" action="register">
                <p>Usuario:<input class="user" type="text" name="user"/></p> 
                <p>Contraseña: <input  class="pass" type="password" name="pass"/></p>
                <p>Repetir Contraseña: <input class="pass2" type="password" name="pass2"/></p>
                <p>E-mail: <input class="email" type="email" name="email"/></p>
                <input class="submit" type="submit" value="Aceptar"/>
                <a href = "/login"><input class="boton" type="button" value="Volver al login"/></a> 
            </form>
        </div>
    </body>
</html>
