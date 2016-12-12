<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head> 
    <body>
        <%
            if (request.getAttribute("errorMessage") != null) {
                out.println("<p class='error-message'>" + request.getAttribute("errorMessage") + "</p>");
            }
        %>
        <form method="POST" action="register">
            Usuario: <input type="text" name="user"/>
            <br/>
            Contraseña: <input type="password" name="pass"/>
            Repetir Contraseña: <input type="password" name="pass2"/>
            E-mail: <input type="email" name="email"/>
            <input type="submit" value="Crear Usuario"/>
            <a href = "/login"><input type="button" value="Volver al login"/></a> 
        </form>
    </body>
</html>
