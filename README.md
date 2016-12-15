# Aplicació web JPA

Práctica con servlets en JAVA, para organizar información sobre usuarios y partidas de un juego online.

###El proyecto tiene los siguientes componentes:

* game.jsp: Página html del juego.
* login.jsp: Página html del login.
* register.jsp: Página html del registro.
* JuanjoaPartidas.java: Entidad para manejar la tabla de Partidas.
* JuanjoaUsuarios.java: Entidad para manejar la tabla de Usuarios.
* WebAppListener.java: Clase para cargar el contexto.
* GameService.java: Clase para manejar las peticiones del GameServlet.
* LoginService.java: Clase para manejar las peticiones del LoginServlet.
* RegisterService.java: Clase para manejar las peticiones del RegisterServlet.
* GameServlet.java: Clase para manejar las peticiones del game.jsp
* LoginFilter.java: Clase para filtrar si el jugador está loggeado o no.
* LoginServlet.java: Clase para manejar las peticiones del login.jsp
* RegisterServlet.java: Clase para manejar las peticiones del register.jsp

###Funcionamiento:

La página principal es el game.jsp que a partir de un filtro se sabrá si el usuario está loggeado o no. 
Si no lo está se autodirigirá a la pantalla de login donde se podrá iniciar sesión, los datos de inicio de sesión se guardan en una tabla con la contraseña cifrada. 
Si el usuario no está registrado se podrá registrar con un nombre, contraseña y correo electrónico (el nombre y correo son únicos).
