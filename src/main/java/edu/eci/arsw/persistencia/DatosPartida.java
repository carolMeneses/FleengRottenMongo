/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistencia;

/**
 *
 * @author 2089340
 */
public class DatosPartida{

    private int manzanasPodridas;
    private int vidasJugador;
    private boolean jugadorVive;
    
    public DatosPartida(int manzanasPodridas, int vidasJugador, boolean estadoJugador) {
        this.manzanasPodridas = manzanasPodridas;
        this.vidasJugador = vidasJugador;
        this.jugadorVive = estadoJugador;
    }
    public DatosPartida(){
    } 
    public int getManzanasPodridas() {
        return manzanasPodridas;
    }

    public void setManzanasPodridas(int manzanasPodridas) {
        this.manzanasPodridas = manzanasPodridas;
    }

    public int getVidasJugador() {
        return vidasJugador;
    }

    public void setVidasJugador(int vidasJugador) {
        this.vidasJugador = vidasJugador;
    }

    public boolean isEstadoJugador() {
        return jugadorVive;
    }

    public void setEstadoJugador(boolean estadoJugador) {
        this.jugadorVive = estadoJugador;
    }
    
}
