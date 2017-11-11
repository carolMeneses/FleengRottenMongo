/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

/**
 *
 * @author
 * Jessica y Johana
 */
public class Jugador {
    
    private int numVidas;
    private String nombre;
    private String color;
    private boolean  estadoVivo=true;
   // cambiar x tipo partida
    private Partida nuevaPartida;

    public void setNuevaPartida(Partida nuevaPartida) {
        this.nuevaPartida = nuevaPartida;
    }


    private int puntaje=0;
    public Jugador(){
    
    }
    public Jugador(int numVidas, String nombre, String color) {
        this.numVidas = numVidas;
        this.nombre = nombre;
        this.color = color;
      
    }

     
    

    public int getNumVidas() {
        return numVidas;
    }

    public void setNumVidas(int numVidas) {
        this.numVidas = numVidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEstadoVivo() {
        return estadoVivo;
    }

    public void setEstadoVivo(boolean estadoVivo) {
        this.estadoVivo = estadoVivo;
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int punt) {
        this.puntaje = puntaje+punt;
    }
    
    public Partida getPartida() {
        return nuevaPartida;
    }
    
    
}
