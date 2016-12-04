/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author juanj
 */
public class GameService {
     protected EntityManager em;

    public GameService(EntityManager em) {
        this.em = em;
    }
    
    public void enviarPartida(Date inicio, Date fin, Integer id) {
        // TODO: insert en base de datos
    }
}
