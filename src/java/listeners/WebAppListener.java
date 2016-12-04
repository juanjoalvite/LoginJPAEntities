/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author juanj
 */
@WebListener
public class WebAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent ctx) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApp");
        ctx.getServletContext().setAttribute("emf", emf);
        
        //EntityManager em = emf.createEntityManager();
        //em.createNativeQuery("CREATE TABLE juanjoA_USUARIOS(ID serial, NICK char(30) UNIQUE, CONTRASEÑA char(30) ,CONSTRAINT PK_USUARIOS PRIMARY KEY (ID)); CREATE TABLE juanjoA_PARTIDAS(IDPARTIDA char(30), FECHAINICIO char(30), FECHAFIN char(30), PUNTUACION numeric, ID_P int,CONSTRAINT PK_PARTIDAS PRIMARY KEY (IDPARTIDA)); ALTER TABLE juanjoA_PARTIDAS ADD CONSTRAINT FK_ID_PARTIDA FOREIGN KEY(ID_P) REFERENCES juanjoA_USUARIOS (ID);");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent ctx) {
        EntityManagerFactory emf = (EntityManagerFactory) ctx.getServletContext().getAttribute("emf");
        emf.close();
    }
}
