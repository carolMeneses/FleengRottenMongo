/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;

import edu.eci.arsw.persistencia.Datos;
import edu.eci.arsw.persistencia.DatosJuegoNuevo;
import edu.eci.arsw.persistencia.DatosSeleccionCasilla;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * Campo de Juego, contiene varias partidas públicas
 */
@Service
public class campoJuego {
    private ArrayList<Partida> juegos= new ArrayList<Partida>();
    
    // Se agregan los datos que el usuario a ingresado por medio del HTML-controllador, clase JUego Nuevo
    public boolean CrearPartida(DatosJuegoNuevo jn){
    Partida j=jn.getiniciarJuegoNuevo();
    j.JuegoNuevo();
    j.agregarJugador(jn.getJugador(),j.getNombrePartida());
    boolean crear=juegos.add(j);
    return crear;
    }
    public boolean AgregarJugador(String nombreP,String j) {
        boolean estado = false;
        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getNombrePartida().equals(nombreP)) {
                juegos.get(i).agregarJugador(nombreP, juegos.get(i).getNombrePartida());

                estado = true;
            }

        }

        return estado;

    }
    public DatosJuegoNuevo entrarPartida(Datos datos) {
        DatosJuegoNuevo dt = new DatosJuegoNuevo();
        for (int i = 0; i < juegos.size(); i++) {
            Partida part = juegos.get(i);
            if (part.getNombrePartida().equals(datos.getNombreP())) {
                dt.setColumnas(part.getColumnas());
                dt.setFilas(part.getFilas());
                dt.setJugador(datos.getJugador());
                dt.setNombreP(datos.getNombreP());
                dt.setTipPartida(part.getTipoPartda());
            }
        }
        return dt;
    }
    public Partida getPartida(String nombreP){
       
    Partida p=null;
         for (int i = 0; i < juegos.size(); i++) {
            Partida part = juegos.get(i);
            if (part.getNombrePartida().equals(nombreP))
                p=part;
                    
         }
         return p;
    }
    public Casilla[][] consultarCasilla(DatosSeleccionCasilla datos){
    Casilla [][] c=null;
    for(int i= 0;i<juegos.size();i++){
        if(juegos.get(i).getNombrePartida().equals(datos.getPartida()))
            c=juegos.get(i).getTablero().getCasillajuego();
    }
    return c;
    }
   
}
