/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers;

import edu.eci.arsw.services.appleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/apple")
public class appleController {

    @Autowired
    appleServices ap;
        
    @Autowired
    SimpMessagingTemplate msmt;
    
   
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetAlltodasPartidas() {
        
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getTodasLasPartidas(), HttpStatus.ACCEPTED);
        
    }
    
    
    @RequestMapping(value="/{Partidas}",method = RequestMethod.GET)
  
    public ResponseEntity<?> getPartidasPorTipo(@PathVariable("Partidas") String tipoPartidas) {

            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getPartidasByTipo(tipoPartidas), HttpStatus.ACCEPTED);      
    }
 @RequestMapping(value="/{jugadores}",method = RequestMethod.GET)
  
    public ResponseEntity<?> getjugadores(@PathVariable("jugadores") String jugador) {

            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getPartidaJugador(jugador), HttpStatus.ACCEPTED);      
    }
}
