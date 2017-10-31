/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.services;

import edu.eci.arsw.model.Jugador;
import edu.eci.arsw.model.Partida;
import edu.eci.arsw.persistencia.applePersistence;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class appleServices {
   @Autowired
   applePersistence apple;
    
 
    public boolean agregarJugador(Partida pn,String nombre) {
     return apple.agregarJugador(pn, nombre);
    }

   
    public List<Jugador> getJugadores(Partida pn) {
           return apple.getJugadores(pn);
    }
  
    public Partida getPartidaJugador(Jugador j) {
        return apple.getPartidaJugador(j);
    }
    public Set<Partida> getPartidasByTipo(String tipoPartida) {
        return apple.getPartidasByTipo(tipoPartida);
    }
      public Set<Partida> getTodasLasPartidas() {
        return apple.getTodaslasPartidas();
    }
    public void eliminar(Partida p) {
         apple.eliminar(p);
    }

    public void crearNuevoPartida(Partida p) {
     apple.crearNuevoPartida(p);
    }
}
