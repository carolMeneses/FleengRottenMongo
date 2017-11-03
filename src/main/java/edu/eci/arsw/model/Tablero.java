/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

import java.util.Random;

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
      
     */
    public void tableroLleno() {
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; i < filas; j++) {
                casillajuego[i][j] = new Casilla(false);
                casillajuego[i][j].setPosicion(i, j);

            }
        }
    }
    
    public void impresion(){
        for(int i=0;i<columnas;i++){
            for (int j=0;j<filas;j++){
                System.out.println(casillajuego[i][j].isEstado()+" ");
            }
        }
    }

    public void AgregarManzanasPodridas() {
        int i = 0;
        while (i < manzanasPodridas) {
            Random ran = new Random();
            int fil;
            int col;
            fil = (int) (ran.nextInt() * filas + 1);
            col = (int) (ran.nextInt() * columnas + 1);
            if (!casillajuego[fil][col].isManzanaPodrida()) {
                casillajuego[fil][col].setManzanaPodrida(true);
                i++;
            }
            

        }
    }

    public Casilla getCasillajuego(String color,int x,int y) {
        Casilla c=null;
        
        if(!casillajuego[x][y].isEstado()){
        casillajuego[x][y].getColor();
        casillajuego[x][y].setEstado(true);
    }
       c= casillajuego[x][y];
         return c;
    }

    public int getManzanasPodridas() {
        return manzanasPodridas;
    }

    public void logicaJuego() {
        int contador;
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                contador = 0;
                if (casillajuego[i][j].isEstado()) {

                    if (comprueba(i - 1, j)) {
                        if (casillajuego[i - 1][j].isEstado()) {
                            contador++;
                        }
                    }

                    if (comprueba(i + 1, j)) {
                        if (casillajuego[i + 1][j].isEstado()) {
                            contador++;
                        }
                    }

                    if (comprueba(i, j - 1)) {
                        if (casillajuego[i][j - 1].isEstado()) {
                            contador++;
                        }
                    }

                    if (comprueba(i, j + 1)) {
                        if (casillajuego[i][j + 1].isEstado()) {
                            contador++;
                        }
                    }

                    if (comprueba(i - 1, j - 1)) {
                        if (casillajuego[i - 1][j - 1].isEstado()) {
                            contador++;
                        }
                    }

                    if (comprueba(i + 1, j + 1)) {
                        if (casillajuego[i + 1][j + 1].isEstado()) {
                            contador++;
                        }
                    }

                    if (comprueba(i - 1, j + 1)) {
                        if (casillajuego[i - 1][j + 1].isEstado()) {
                            contador++;
                        }
                    }
                    if (comprueba(i + 1, j - 1)) {
                        if (casillajuego[i + 1][j - 1].isEstado()) {
                            contador++;
                        }

                    if (contador != 0) {
                            casillajuego[i][j].isEstado();
                        }

                    }

                }
            }
        }
        impresion();
    }

    public boolean comprueba(Integer i, Integer j) {
        return (i >= 0 && j >= 0 && j < filas && j < columnas);
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
    

}
