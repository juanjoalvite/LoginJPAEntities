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
            <form method="POST" action="login">
                <p>Usuario: <input class="user" type="text" name="user"/></p>
                <p>Contraseña: <input class="pass" type="password" name="pass"/></p>
                <input class="submit" type="submit" value="Iniciar Sesión"/>
                <a href = "/register"><input class="boton" type="button" value="Crear Usuario"/></a> 
            </form>
        </div>
    </body>
</html>
