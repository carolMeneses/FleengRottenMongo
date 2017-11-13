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
     private int filas=10;
     private int columnas=10;
     private int numJugadores;


    // private String modalidad;
     private int maximoJugadores=5;
     private String nombrePartida;
     private static int manzRestantes;
     private static int manzanasBuenas;
     public final int puntaje=5;
     
     public Partida(){
     
     }
//     public Partida(String nivel, int filas, int columnas,String nombrePartida,String tipoPartida,String usuario) {
//        this.nivel = nivel;
//        this.filas = filas;
//        this.columnas = columnas;
//          this.tipoPartida = tipoPartida;
//        this.nombrePartida=nombrePartida;
//
//  
//    }
       public Partida(String nombrePartida,String nivel) {
        this.nivel = nivel;
         if(nivel.equals("Facil")) {
           this.manzanasPodridas = filas * columnas / 10;
        }
        if(nivel.equals("Medio")) {
            this.manzanasPodridas = filas * columnas / 4;
        }
        if(nivel.equals("Dificil")) {
           this.manzanasPodridas = filas * columnas / 2;
        }
      
    // this.manzanasPodridas = filas * columnas / 4;
        manzanasBuenas=(filas * columnas)-manzanasPodridas ;
       this.nombrePartida=nombrePartida;
       this.numJugadores= manzanasPodridas-1;
        adicionarColor();
//            color.add("blue");
//            color.add("gray");
//            color.add("green");
//            color.add("purple");
//            color.add("pink");
    
 
    }

 

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
   
   
    public void JuegoNuevo() {
        tablero = new Tablero(filas, columnas, manzanasPodridas);
        tablero.tableroLleno();
        tablero.AgregarManzanasPodridas();
   
        
        //tablero.asignarNumeros();

    }
    public void agregarJugador(Jugador jugador){
        System.out.println("ENTRO A JUGADORES");
        
        if(jugadores.size()<maximoJugadores){
           jugador.setColor(color.get(jugadores.size()));
            System.out.println(color.get(0));
             jugador.setNumVidas(3);
          jugadores.add(jugador);
            
        }
        
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

    private void adicionarColor() {
         color.add("blue");
            color.add("gray");
            color.add("green");
            color.add("purple");
            color.add("pink");
           
    }

   
    

}
//
