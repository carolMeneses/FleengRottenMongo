/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistencia;

/**
 *
 * @author 3070465
 */
public class DatosSeleccionCasilla {
    private String nombreP;
    private String jugador;
    private int pX;

    public DatosSeleccionCasilla(String partida, String jugador, int pX, int pY) {
        this.nombreP = partida;
        this.jugador = jugador;
        this.pX = pX;
        this.pY = pY;
    }
    private int pY;

    public String getPartida() {
        return nombreP;
    }

    public void setPartida(String partida) {
        this.nombreP = partida;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public int getpY() {
        return pY;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }
    
    
}
