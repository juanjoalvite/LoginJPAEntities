/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.JuanjoaPartidas;
import entities.JuanjoaUsuarios;
import java.util.Date;
import java.util.List;
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

    public List<JuanjoaPartidas> topViciados() {

        List<JuanjoaPartidas> usuariosMax = null;

        Query scoreUser = em.createQuery("select p from JuanjoaPartidas p join fetch p.idU order by p.puntuacion DESC").setMaxResults(3);

        try {
            usuariosMax = (List<JuanjoaPartidas>) scoreUser.getResultList();
        } catch (NoResultException e) {
        }

        return usuariosMax;
    }

    public List<JuanjoaPartidas> ultimosConectados() {
        List<JuanjoaPartidas> lastConect = null;

        Query scoreUser = em.createQuery("select p from JuanjoaPartidas p join fetch p.idU order by p.fechafin DESC").setMaxResults(3);

        try {
            lastConect = (List<JuanjoaPartidas>) scoreUser.getResultList();
        } catch (NoResultException e) {
        }

        return lastConect;

    }
}
