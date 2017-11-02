/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistencia;

import edu.eci.arsw.model.Jugador;
import edu.eci.arsw.model.Partida;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public interface applePersistence {

    /**
     *
     * @param pn de la nueva partida
     * @param nombre
     * @return 
     *
     */
    public boolean agregarJugador(Partida pn, String nombre);

    /**
     * @param pn
     * @return los jugadores que hay en una partida
     */
    public List<Jugador> getJugadores(Partida pn);

    /**
     *
     * @param j
     * @return la partida a la que pertenece un jugador
     */
    public Partida getPartidaJugador(String j);

    /**
     * @param tipoPartida
     * @return los jugadores que hay en una partida
     */
    public Set<Partida> getPartidasByTipo(String tipoPartida);

    public void eliminar(Partida p);

    public void crearNuevoPartida(Partida p);
    
    public Set<Partida> getTodaslasPartidas();
    public int getFilas_columnas(String nombreP);

}
