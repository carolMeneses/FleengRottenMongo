/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers;

import edu.eci.arsw.model.Partida;
import edu.eci.arsw.services.appleServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
  
    public ResponseEntity<?> getPartidasPorTipo(@PathVariable("Partidas") String tipoPartida) {
               try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getPartidasByTipo(tipoPartida), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
           
            return new ResponseEntity<>("Partida no encontrada", HttpStatus.NOT_FOUND);
        }
    }
    
 @RequestMapping(value="/usuarios",method = RequestMethod.GET)
  
    public ResponseEntity<?> getUsuarios() {
               try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getUsuarios(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
           
            return new ResponseEntity<>("Usuarios no encontrados", HttpStatus.NOT_FOUND);
        }
    }
 @RequestMapping(value="/partida/nombre/{nombreP}",method = RequestMethod.GET)
  
    public ResponseEntity<?> getPartida(@PathVariable("nombreP") String nombreP) {

            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getPartida(nombreP), HttpStatus.ACCEPTED);      
    }
   @RequestMapping(method = RequestMethod.GET,value="/colfil/{nombreP}")
  
    public ResponseEntity<?> getFilas_columnas(@PathVariable("nombreP") String nombreP) {
        
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getFilas_columnas(nombreP), HttpStatus.ACCEPTED);
       
    }
        @RequestMapping(method = RequestMethod.POST,value="/{jugador}")
    public ResponseEntity<?> manejadorPostAgregarPartida(@RequestBody Partida pn) {
      // System.out.print("ENTRO A POST");
    
          ap.crearNuevoPartida(pn);
         //   System.out.print("creo");
            return new ResponseEntity<>(HttpStatus.CREATED);
       

    }
      @RequestMapping(path = "/partida/{nombreP}", method = RequestMethod.PUT)
    public ResponseEntity<?> PuttRecursoSet(@RequestBody Partida p) {
    
            ap.actualizar(p);
        
           
            return new ResponseEntity<>(HttpStatus.CREATED);
      

    }
     @RequestMapping(path = "/{Partida}/{nombreP}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deliteRecursoSet(@RequestBody Partida p) {
      
            ap.eliminar(p);
        
           
            return new ResponseEntity<>(HttpStatus.CREATED);
        

    }
}
