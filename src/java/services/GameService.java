/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.JuanjoaPartidas;
import entities.JuanjoaUsuarios;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author juanj
 */
public class GameService {

    protected EntityManager em;

    public GameService(EntityManager em) {
        this.em = em;
    }

    public void enviarPartida(Date inicio, Date fin, int usuario, Double score) {
        em.getTransaction().begin();

        JuanjoaPartidas game = new JuanjoaPartidas();
        game.setFechainicio(inicio);
        game.setFechafin(fin);
        game.setIdU(buscarID(usuario));
        game.setPuntuacion(score);
        em.persist(game);
        em.getTransaction().commit();
        em.close();
    }

    public JuanjoaUsuarios buscarID(int id) {
        JuanjoaUsuarios usuario = null;

        Query existeUsuarioQuery = em.createQuery("SELECT ju FROM JuanjoaUsuarios ju WHERE ju.id = :id")
                .setParameter("id", id);

        try {
            usuario = (JuanjoaUsuarios) existeUsuarioQuery.getSingleResult();
        } catch (NoResultException e) {
        }

        return usuario;
    }
    
    public void topViciados(){
        
        
    }
}
