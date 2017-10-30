/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers;

import edu.eci.arsw.model.campoJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apple")
public class appleController {

    @Autowired
    campoJuego jueg;
     @RequestMapping(path = "/agregarJugador/{nombreP}/{usuario}", method = RequestMethod.POST)
        public ResponseEntity<?> getCurrentWord(@PathVariable String nombreP,@PathVariable String usuario){
         boolean estado;
         estado=jueg.AgregarJugador(nombreP,usuario);
        return new ResponseEntity<>(estado,HttpStatus.ACCEPTED);
    }
    

}
