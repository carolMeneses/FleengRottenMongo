/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.aplicacion;

import java.util.ArrayList;

/**
 *
 * @author 2089340
 */
public class Juego {

   
    private Tablero tablero;
    private ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
     private ArrayList<String> color=new ArrayList<String>();
     private String nivel;
     private int manzanasPodridas;
     private int filas;
     private int columnas;
     private int numJugadores;
     private String modalidad;
     private int maximoJugadores=15;
     private String nombrePartida;
     
     public Juego(String nivel, int filas, int columnas, String modalidad,String nombrePartida) {
        this.nivel = nivel;
        this.filas = filas;
        this.columnas = columnas;
        this.modalidad = modalidad;
        this.nombrePartida=nombrePartida;
        setmanzanasPodridas();
    }
       public Juego(String nivel, String modalidad,String nombrePartida) {
        this.nivel = nivel;
        this.modalidad = modalidad;
        setFilasColumnas();
        setmanzanasPodridas();
        this.nombrePartida=nombrePartida;
    }

    public void setFilasColumnas() {
        if(nivel.equals("facil")) {
            filas=8;
            columnas=8;
        }
        if(nivel.equals("medio")) {
            filas=16;
            columnas=16;
        }
        if(nivel.equals("dificil")) {
            filas=32;
            columnas=32;
        }
    }
    public void crearColores(){
    color.add("blue");
    color.add("gray");
    color.add("green");
    color.add("purple");
    color.add("pink");
    color.add("white");
    color.add("black");
    color.add("red");
    color.add("yellow");
    color.add("brown");
    color.add("violet");
    color.add("orange");
    color.add("fuchsia");
    color.add("navy blue");
    color.add("ligth green");  
   
    }
    public void setmanzanasPodridas() {
        this.manzanasPodridas = filas * columnas / 4;
    }
    public void numJugadores() {
        this.numJugadores= manzanasPodridas-1;
    }

    public void JuegoNuevo() {
        tablero = new Tablero(filas, columnas, manzanasPodridas);
        tablero.tableroLleno();
        tablero.AgregarManzanasPodridas();
        crearColores();
        //tablero.asignarNumeros();

    }
    public boolean agregarJugador(Jugador jug){
        boolean adiciono=false;
        
        if(jugadores.size()<numJugadores){
            
            jugadores.add(jug);
            adiciono=true;
        }
        return true;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    // falta mover

    public Tablero getTablero() {
        return tablero;
    }

    public int getManzanasPodridas() {
        return manzanasPodridas;
    }

    public int getMaximoJugadores() {
        return maximoJugadores;
    }

    public String getNombrePartida() {
        return nombrePartida;
    }

}
