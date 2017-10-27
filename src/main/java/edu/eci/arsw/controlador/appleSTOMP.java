/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controlador;

import edu.eci.arsw.aplicacion.campoJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 *
 * @author 3070465
 */
public class appleSTOMP {

@Autowired
campoJuego juego;
@Autowired
SimpMessagingTemplate msgt;

}
