/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2089340
 */
public class Tablero {

    private final int filas;
    private final int columnas;
    private final Casilla[][] casillajuego;
    private final int manzanasPodridas;
    //private final String estadoTablero;

    public Tablero(int filas, int columnas, int manzanasPodridas) {
        this.filas = filas;
        this.columnas = columnas;
        casillajuego = new Casilla[filas][columnas];
        this.manzanasPodridas = manzanasPodridas;
    }

    /*
     LLENA EL TABLERO 
     */
    public void tableroLleno() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillajuego[i][j] = new Casilla(false);
                casillajuego[i][j].setPosicion(i, j);
            }
        }
    }
    
    public void impresion(){
        for(int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                if(casillajuego[j][i].isManzanaPodrida()){
                    System.out.print("X ");
                } else{
                    System.out.print(casillajuego[j][i].getIndicador() + " ");
                }
            }
            System.out.println();
        }
        System.out.println( );
    }

    public void AgregarManzanasPodridas() {
        int i = 0;
        while (i < manzanasPodridas) {
            Random ran = new Random();
            int fil;
            int col;
            fil = ThreadLocalRandom.current().nextInt(0, filas);
            col = ThreadLocalRandom.current().nextInt(0, columnas);
            if (!casillajuego[fil][col].isManzanaPodrida()) {
                casillajuego[fil][col].setManzanaPodrida(true);
                i++;
            }
        }
    }

    public Casilla getCasillajuego(String color, int x, int y) {
        Casilla c = null;
        
        if(!casillajuego[x][y].isEstado()){
//            casillajuego[x][y].getColor();
            casillajuego[x][y].setEstado(true);
        }
        c = casillajuego[x][y];
        return c;
    }

    public int getManzanasPodridas() {
        return manzanasPodridas;
    }

    public void logicaJuego() {
        int contador;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                contador = 0;
                if (!casillajuego[i][j].isManzanaPodrida()) {

                    if (comprueba(i - 1, j)) {
                        if (casillajuego[i - 1][j].isManzanaPodrida()) {
                            contador++;
                        }
                    }

                    if (comprueba(i + 1, j)) {
                        if (casillajuego[i + 1][j].isManzanaPodrida()) {
                            contador++;
                        }
                    }

                    if (comprueba(i, j - 1)) {
                        if (casillajuego[i][j - 1].isManzanaPodrida()) {
                            contador++;
                        }
                    }

                    if (comprueba(i, j + 1)) {
                        if (casillajuego[i][j + 1].isManzanaPodrida()) {
                            contador++;
                        }
                    }

                    if (comprueba(i - 1, j - 1)) {
                        if (casillajuego[i - 1][j - 1].isManzanaPodrida()) {
                            contador++;
                        }
                    }

                    if (comprueba(i + 1, j + 1)) {
                        if (casillajuego[i + 1][j + 1].isManzanaPodrida()) {
                            contador++;
                        }
                    }

                    if (comprueba(i - 1, j + 1)) {
                        if (casillajuego[i - 1][j + 1].isManzanaPodrida()) {
                            contador++;
                        }
                    }
                    if (comprueba(i + 1, j - 1)) {
                        if (casillajuego[i + 1][j - 1].isManzanaPodrida()) {
                            contador++;
                        }
                    }
                    if (contador != 0) {
                        casillajuego[i][j].setIndicador(contador);
                    }

                }
            }
        }

//        impresion();
    }

    public boolean comprueba(int i, int j) {
        return ((i >= 0 && j >= 0) && (i < filas && j < columnas));
    }

    public Casilla[][] getCasillajuego() {
        return casillajuego;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
    public Casilla consultarCasilla(int x, int y) {
        Casilla c = casillajuego[x][y];
        return c;
    }
    public boolean ConsultarManzanaPodrida(int x, int y){
       return casillajuego[x][y].isManzanaPodrida();
    }
    public void exploto(int x,int y){
    casillajuego[x][y].setManzanaPodrida(false);
    }

}
