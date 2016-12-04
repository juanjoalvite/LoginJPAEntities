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
public class LoginService {

    protected EntityManager em;

    public LoginService(EntityManager em) {
        this.em = em;
    }

    public boolean validaLogin(String nick, String password) {
        boolean resultado = false;
        
        Query existeUsuarioQuery = em.createQuery("SELECT ju FROM JuanjoaUsuarios ju WHERE ju.nick = :nick")
                .setParameter("nick", nick);

        JuanjoaUsuarios usuario = null;
        
        try {
            usuario = (JuanjoaUsuarios) existeUsuarioQuery.getSingleResult();
        } catch (NoResultException e) {}
        
        if (usuario != null && usuario.getPassword().equals(password)) {
            resultado = true;
        }
        
        return resultado;
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

    public boolean existeUsuario(String nick) {
        Query existeUsuarioQuery = em.createQuery("SELECT ju FROM JuanjoaUsuarios ju WHERE ju.nick = :nick")
                .setParameter("nick", nick);

        JuanjoaUsuarios usuario = (JuanjoaUsuarios) existeUsuarioQuery.getSingleResult();

        System.out.println(usuario.getEmail());

        return true;
    }
}
