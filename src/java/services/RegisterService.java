/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.JuanjoaUsuarios;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import servlets.LoginServlet;

/**
 *
 * @author juanj
 */
public class RegisterService {

    EntityManager em;

    public RegisterService(EntityManager em) {
        this.em = em;
    }

    public boolean validaUser(String nick, String email) {
        boolean resultado = false;

        Query existeUsuarioQuery = em.createQuery("SELECT ju FROM JuanjoaUsuarios ju WHERE ju.nick = :nick")
                .setParameter("nick", nick);

        JuanjoaUsuarios usuario = null;

        try {
            usuario = (JuanjoaUsuarios) existeUsuarioQuery.getSingleResult();
        } catch (NoResultException e) {
        }

        if (usuario != null && usuario.getPassword().equals(email)) {
            resultado = true;
        }

        return resultado;
    }

    public void crearUser(String nick, String email, String password) {
            em.getTransaction().begin();
            JuanjoaUsuarios user = new JuanjoaUsuarios();
            user.setEmail(email);
            user.setNick(nick);
            user.setPassword(password);
            em.persist(user);
            em.getTransaction().commit();
            em.close();
    }
    

    public String cifrado(String password) {
        String passwordSha1 = null;

        try {
            MessageDigest digest;
            digest = MessageDigest.getInstance("SHA-1");
            digest.update(password.getBytes("utf8"));
            byte[] digestBytes = digest.digest();
            passwordSha1 = javax.xml.bind.DatatypeConverter.printHexBinary(digestBytes);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return passwordSha1;
    }
}
