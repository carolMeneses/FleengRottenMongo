/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistencia;

import edu.eci.arsw.model.Casilla;
import edu.eci.arsw.model.Jugador;
import edu.eci.arsw.model.Partida;
import edu.eci.arsw.model.campoJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author
 */
@Controller
public class appleSTOMP {

@Autowired
campoJuego juego;
@Autowired
SimpMessagingTemplate msgt;


    @MessageMapping("/crearJuego")
    public void NuevoJuego(String nombreP, String TipPartida,String jugador, String nivel)throws Exception {
        juego.CrearPartida(nombreP, TipPartida, jugador, nivel);
////       msgt.convertAndSend("/topic/partidaNueva"+datos.getNombreP()+datos.getJugador(),datos);
//        msgt.convertAndSend("/topic/partidaNueva",datos);
    }
     @MessageMapping("/establecePartida")
    public void entrarPartida(String nombreP)throws Exception {
//        DatosJuegoNuevo djn=juego.entrarPartida(datos);
//        djn.setJugador(datos.getJugador());
//        msgt.convertAndSend("/topic/partidaNueva"+datos.getNombreP()+datos.getJugador(),djn);
//        Partida p= juego.getPartida(datos.getNombreP());
//        DatosPartida dp=new DatosPartida(p.getManzanasPodridas(),p.getJugador(datos.getJugador()).getNumVidas(), true);
//         msgt.convertAndSend("/topic/estadoPartida"+datos.getNombreP()+datos.getJugador(),djn);
    }
//    @MessageMapping("/poblarCasilla")
//    public void poblarCasillas(DatosSeleccionCasilla datos){
//        Partida p= juego.getPartida(datos.getPartida());
//        Jugador j=p.getJugador(datos.getJugador());
//        Casilla c= new Casilla(j.getColor(),datos.getpX(),datos.getpY());
//        msgt.convertAndSend("topic/casillaVisitada",c);
//    }
//    Casilla[][] casillasJuego =juego.consultarCasilla(datos);
//    Casilla c=null;
//    int filas=juego.getPartida(datos.getPartida()).getFilas();
//    int columnas=juego.getPartida(datos.getPartida()).getColumnas();
//        for(int i=0;i<filas;i++){
//            for(int j=0;j<columnas;j++){
//            c=casillasJuego[i][j];
//            if(c.isEstado()) 
//                msgt.convertAndSend("topic/casillaVisitada"+datos.getPartida()+datos.getJugador(),c);
//                    
//            }
//        }
//    }

            
}

