/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.aplicacion;

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
        for (int i = 0; i < filas; i++) {
            for (int j = 0; i < columnas; j++) {
                casillajuego[i][j] = new Casilla(false);
                casillajuego[i][j].setPosicion(i, j);

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

    public Casilla[][] getCasillajuego() {
        return casillajuego;
    }

    public int getManzanasPodridas() {
        return manzanasPodridas;
    }
    
    

}
