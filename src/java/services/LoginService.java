/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.JuanjoaUsuarios;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author juanj
 */
public class LoginService {

    protected EntityManager em;

    public LoginService(EntityManager em) {
        this.em = em;
    }

    public boolean existeUsuario(String nick) {
        Query existeUsuarioQuery = em.createQuery("SELECT ju FROM JuanjoaUsuarios ju WHERE ju.nick = :nick")
                .setParameter("nick", nick);

        JuanjoaUsuarios usuario = (JuanjoaUsuarios) existeUsuarioQuery.getSingleResult();

        System.out.println(usuario.getEmail());

        return true;
    }
}
