/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

/**
 *
 * @author 2101359
 */
public class ClientMessage {

    private int x;
    private int y;
    private Jugador id;
    private String campoJuego;
    private String nombreP;

    public String getCampoJuego() {
        return campoJuego;
    }

    public void setCampoJuego(String campoJuego) {
        this.campoJuego = campoJuego;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the id
     */
    public Jugador getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Jugador id) {
        this.id = id;
    }
}
