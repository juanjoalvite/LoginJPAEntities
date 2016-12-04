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

        <form method="POST" action="login">
            Usuario: <input type="text" name="user"/>
            <br/>
            Contraseña: <input type="password" name="pass"/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
