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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apples")
public class appleController {

    @Autowired
    appleServices ap;

    @Autowired
    SimpMessagingTemplate msmt;

    //Metodos GET
    @RequestMapping(value = "/jugadores", method = RequestMethod.GET)

    public ResponseEntity<?> getJugadores() {
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(ap.getJugadores(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>("Usuarios no encontrados", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/campoJuego/{campoJuego}/partidas", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetAlltodasPartidas(@PathVariable("campoJuego") String campoJuego) {

        //obtener datos que se enviarán a través del API
        return new ResponseEntity<>(ap.getPartidasByTipo(campoJuego), HttpStatus.ACCEPTED);

    }

    //Metodos POST
    @RequestMapping(method = RequestMethod.POST, value = "/campoJuego/{campoJuego}/partida/{nombre}/nivel/{nivel}")
    public ResponseEntity<?> manejadorPostAgregarPartida(@PathVariable("campoJuego") String campoJuego, @PathVariable("nombre") String nombre,
            @PathVariable("nivel") String nivel) {
        ap.crearNuevoPartida(campoJuego, new Partida(nombre, nivel));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
