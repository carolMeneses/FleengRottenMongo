/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

/**
 *
 * @author Carol Meneses
 * @author Jessica Fresneda
 */
public class Casilla {
    private boolean manzanaPodrida;
    private String Color;
    private int suma;
        private int x,y;
    private boolean estado;
    
    public Casilla(){
    }
    
    public Casilla(String Color,int x, int y){
        this.Color=Color;
        this.x=x;
        this.y=y;
    }
    
    public Casilla(boolean manzanaPodrida) {
        this.manzanaPodrida = manzanaPodrida;
        estado = false;
    }
    public void  setPosicion(int x, int y){
        setX(x);
        setY(y);
    }      
    public boolean isManzanaPodrida() {
        return manzanaPodrida;
    }

    public void setManzanaPodrida(boolean manzanaPodrida) {
        this.manzanaPodrida = manzanaPodrida;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
  
     
    
}
