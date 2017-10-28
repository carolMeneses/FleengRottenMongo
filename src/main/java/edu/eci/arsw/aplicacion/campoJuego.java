/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.aplicacion;

import edu.eci.arsw.controlador.Datos;
import edu.eci.arsw.controlador.DatosJuegoNuevo;
import edu.eci.arsw.controlador.DatosSeleccionCasilla;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2089340
 */
@Service
public class campoJuego {
    private ArrayList<Partida> juegos= new ArrayList<Partida>();
    
    // Se agregan los datos que el usuario a ingresado por medio del HTML-controllador, clase JUego Nuevo
    public boolean CrearPartida(DatosJuegoNuevo jn){
    Partida j=jn.getiniciarJuegoNuevo();
    j.JuegoNuevo();
    j.agregarJugador(jn.getJugador());
    boolean crear=juegos.add(j);
    return crear;
    }
    public boolean AgregarJugador(String nombreP,String j) {
        boolean estado = false;
        for (int i = 0; i < juegos.size(); i++) {
            if (juegos.get(i).getNombrePartida().equals(nombreP)) {
                juegos.get(i).agregarJugador(j);

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
