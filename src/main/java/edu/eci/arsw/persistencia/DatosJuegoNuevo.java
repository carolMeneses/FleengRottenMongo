/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistencia;

import edu.eci.arsw.model.Partida;

/**
 *
 * @author Jessica Fresneda Hernandez
 *         Creación de juego 
 */

public class DatosJuegoNuevo {

    private String nombreP;
    private String TipPartida;
    private boolean estado;
    private String idPartida;
    //private String modalidad;
    private int filas;
    private int columnas;
    private String jugador;
    private String nivel;
   
     // private int numJugadores;
    //private double tiemp;;
    

    public DatosJuegoNuevo(String nombreP, String TipPartida, String idPartida, int filas, int columnas, String jugador, String nivel) {
        this.nombreP = nombreP;
        this.TipPartida = TipPartida;
        this.idPartida = idPartida;
        this.filas = filas;
        this.columnas = columnas;
        this.jugador = jugador;
        this.nivel = nivel;
    }

    public DatosJuegoNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getTipPartida() {
        return TipPartida;
    }

    public void setTipPartida(String TipPartida) {
        this.TipPartida = TipPartida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getNivel() {
        return nivel;
    }

 
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Partida getiniciarJuegoNuevo(){
        Partida jueg = new Partida(nivel, filas,  columnas, nombreP);
        
        return jueg;
        
    }
    
    
    
}
