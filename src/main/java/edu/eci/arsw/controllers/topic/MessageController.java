/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers.topic;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import edu.eci.arsw.model.*;
import edu.eci.arsw.persistencia.interfaces.applePersistence;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MessageController {
    @Autowired
    applePersistence s;
    @MessageMapping("/message")
    @SendTo("/topic/code")
    public Tablero serverMessage(ClientMessage message) throws Exception {
        System.out.println("Aca messages "  + message.getId());
        return s.movimiento(message.getX(), message.getY(), message.getCampoJuego(), message.getNombreP());
    }

}