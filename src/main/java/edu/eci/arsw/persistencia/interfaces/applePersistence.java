/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistencia.interfaces;

import edu.eci.arsw.model.Jugador;
import edu.eci.arsw.model.Partida;
import edu.eci.arsw.model.Tablero;
import java.util.List;
import java.util.Set;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public interface applePersistence extends MongoRepository<User, Integer>{

    /**
     *
     * @param pn de la nueva partida
     * @param nombre
     * @return 
     *
     */
    public void agregarJugador(Partida pn, Jugador nombre, String campoJuego);


    /**
     * @param tipoPartida
     * @return los jugadores que hay en una partida
     */
    public Set<Partida> getPartidasByTipo(String tipoPartida);

   

    public void crearNuevoPartida(String campoJuego, Partida p);
    
     public List<Jugador> getJugadores();
     public Partida getPartida(String nombreP, String campoJuego);
     public Partida getPartidaByJugador(String jugador);
     public Tablero movimiento(int x, int y, String campoJuego, String nombreP);
}
