/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.aplicacion;

import edu.eci.arsw.controlador.DatosJuegoNuevo;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2089340
 */
@Service
public class campoJuego {
    private ArrayList<Juego> juegos= new ArrayList<Juego>();
    
    // Se agregan los datos que el usuario a ingresado por medio del HTML-controllador, clase JUego Nuevo
    public boolean CrearPartida(DatosJuegoNuevo jn){
    Juego j=jn.getiniciarJuegoNuevo();
    j.JuegoNuevo();
    j.agregarJugador(jn.getJugador());
    boolean crear=juegos.add(j);
    return crear;
    }
    public boolean AgregarJugador(String partida,String j) {
        boolean estado = false;
        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getNombrePartida().equals("partida")) {
                juegos.get(i).agregarJugador(partida);

                estado = true;
            }

        }

        return estado;

    }
}
