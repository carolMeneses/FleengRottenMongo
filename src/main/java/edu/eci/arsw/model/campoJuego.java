/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.model;
////import edu.eci.arsw.persistencia.Datos;
//import edu.eci.arsw.persistencia.DatosJuegoNuevo;
//import edu.eci.arsw.persistencia.DatosSeleccionCasilla;
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
    public boolean CrearPartida(String nombreP, String TipPartida,String jugador, String nivel){
    Partida j=new Partida(nombreP, nivel,TipPartida, jugador);
    j.JuegoNuevo();
    j.agregarJugador(jugador, nombreP);
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
    public void entrarPartida(Partida partid) {
        boolean existe= false;
       // Partida  dt = new Partida();
        for (int i = 0; i < juegos.size(); i++) {
            Partida part = juegos.get(i);
            if (part.getNombrePartida().equals(partid.getNombrePartida())) {
              existe=true;
               // dt.setFilas(part.getFilas());
               // dt.setJugador(partid.getJugador());
    //                dt.setNombreP(datos.getNombreP());
    //                dt.setTipPartida(part.getTipoPartda());
               
            }
        }
        
       if (!existe){
       juegos.add(partid);
       }
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
    public Casilla[][] consultarCasilla(int x , int y,Partida partida){
    Casilla [][] c=null;
    for(int i= 0;i<juegos.size();i++){
        if(juegos.get(i).getNombrePartida().equals(partida.getNombrePartida())){
            c=juegos.get(i).getTablero().getCasillajuego();
    }
    
    }
    return c;}
   
}
