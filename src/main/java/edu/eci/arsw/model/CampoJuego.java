/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;
////import edu.eci.arsw.persistencia.Datos;
//import edu.eci.arsw.persistencia.DatosJuegoNuevo;
//import edu.eci.arsw.persistencia.DatosSeleccionCasilla;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * Campo de Juego, contiene varias partidas públicas
 */
@Service
public class CampoJuego {

    private  Map<String,Partida> partidas= new ConcurrentHashMap();;

    public CampoJuego() {
        
    }
    
    

    // Se agregan los datos que el usuario a ingresado por medio del HTML-controllador, clase JUego Nuevo
    public void agregarPartida(Partida partida) {
        partidas.put(partida.getNombrePartida(),partida);
    
    }

    
    public Partida getPartida(String nombreP) {
        return partidas.get(nombreP);
    }

    public Set<Partida> getPartidas() {
        Set<Partida> set= new HashSet();
        for(Partida p: partidas.values()){
            set.add(p);
        }
        return set;
    }
    
    

    

}
