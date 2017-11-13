/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.services;

import edu.eci.arsw.model.Jugador;
import edu.eci.arsw.model.Partida;
import edu.eci.arsw.model.Tablero;
import edu.eci.arsw.persistence.impl.InMemoryApple;
import edu.eci.arsw.persistencia.interfaces.applePersistence;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public class appleServices implements applePersistence{

    @Autowired
    InMemoryApple apple;

    
    
    @Override
    public void agregarJugador(Partida pn, Jugador nombre, String campoJuego) {
         apple.agregarJugador(pn, nombre, campoJuego);
    }

    
    @Override
    public List<Jugador> getJugadores() {
        return apple.getJugadores();
    }


    @Override
    public Set<Partida> getPartidasByTipo(String tipoPartida) {
        return apple.getPartidasByTipo(tipoPartida);
    }


    
    @Override
    public void crearNuevoPartida(String campoJuego, Partida p) {
        apple.crearNuevoPartida(campoJuego,p);
    }


    @Override
    public Partida getPartida(String nombreP, String campoJuego) {
        return apple.getPartida(nombreP, campoJuego);
    }

    @Override
     public Partida getPartidaByJugador(String nombreP) {
        return apple.getPartidaByJugador(nombreP);
    }

    @Override
    public Tablero movimiento(int x, int y, String campoJuego, String nombreP) {
        
        return apple.movimiento(x, y, campoJuego, nombreP);
    }
    

  

   
}
