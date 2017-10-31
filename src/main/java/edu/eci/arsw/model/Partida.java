/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

import java.util.ArrayList;

/**
 *
 * @author Jessica Fresneda
 * @author Carol Meneses
 */
public class Partida {

   
    private Tablero tablero;
    private ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
     private ArrayList<String> color=new ArrayList<String>();
     private String nivel;
     private int manzanasPodridas;
     private int filas;
     private int columnas;
     private int numJugadores;
     private String tipoPartida;


    // private String modalidad;
     private int maximoJugadores=15;
     private String nombrePartida;
     private static int manzRestantes;
     private static int manzanasBuenas;
     public final int puntaje=5;
     
     public Partida(String nivel, int filas, int columnas,String nombrePartida,String tipoPartida,String usuario) {
        this.nivel = nivel;
        this.filas = filas;
        this.columnas = columnas;
          this.tipoPartida = tipoPartida;
        this.nombrePartida=nombrePartida;
        setManzanasPodridas();
        manzRestantes=getManzanasPodridas();
         agregarJugador(usuario);
    }
       public Partida(String nivel,String nombrePartida,String tipoPartida, String usuario) {
        this.nivel = nivel;
        this.tipoPartida = tipoPartida;
        setFilasColumnas();
        setManzanasPodridas();
        manzRestantes=getManzanasPodridas();
          agregarJugador(usuario);
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
    public void setManzanasPodridas() {
        this.manzanasPodridas = filas * columnas / 4;
        manzanasBuenas=(filas * columnas)-manzanasPodridas ;
       
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
    public boolean agregarJugador(String nombre){
        boolean adiciono=false;
        
        if(jugadores.size()<numJugadores){
            Jugador jugador=new Jugador(3,nombre,color.get(jugadores.size()));
            jugadores.add(jugador);
            adiciono=true;
        }
        return true;
    }
    public Casilla seleccionar(int x, int y, String nombre) {
        Casilla c = null;
        String color = "";
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).equals(nombre)) {
                c.setEstado(true);
                color = jugadores.get(i).getColor();
                c = tablero.getCasillajuego(color, x, y);
                if (c.isManzanaPodrida()) {
                    jugadores.get(i).setNumVidas(jugadores.get(i).getNumVidas() - 1);
                    manzRestantes=manzRestantes-1;
                   
                }
                else{
                 manzanasBuenas=manzanasBuenas-1;
                 jugadores.get(i).setPuntaje(puntaje);
                }

            }
        }
        return c;

    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    // falta mover
    public Jugador getJugador(String jugador){
        Jugador j=null;
        for(int i=0;i<jugadores.size();i++){
        if(jugadores.get(i).getNombre().equals(jugador))
            j=jugadores.get(i);
        }
    return j;
    }
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
        public ArrayList<String> getColor() {
        return color;
    }

    public String getNivel() {
        return nivel;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public static int getManzRestantes() {
        return manzRestantes;
    }

    public static int getManzanasBuenas() {
        return manzanasBuenas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getTipoPartda() {
        return tipoPartida;
    }

    public void setTipoPartda(String tipoPartda) {
        this.tipoPartida = tipoPartda;
    }
    

}
//
