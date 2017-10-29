/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controlador;

import edu.eci.arsw.aplicacion.Casilla;
import edu.eci.arsw.aplicacion.Partida;
import edu.eci.arsw.aplicacion.campoJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author 3070465
 */
@Controller
public class appleSTOMP {

@Autowired
campoJuego juego;
@Autowired
SimpMessagingTemplate msgt;

    @MessageMapping("/crearJuego")
    public void NuevoJuego(DatosJuegoNuevo datos)throws Exception {
        datos.setEstado(juego.CrearPartida(datos));
//       msgt.convertAndSend("/topic/partidaNueva"+datos.getNombreP()+datos.getJugador(),datos);
        msgt.convertAndSend("/topic/partidaNueva"+datos.getJugador(),datos);
    }
     @MessageMapping("/entrarPartida")
    public void entrarPartida(Datos datos)throws Exception {
        DatosJuegoNuevo djn=juego.entrarPartida(datos);
        djn.setJugador(datos.getJugador());
        msgt.convertAndSend("/topic/partidaNueva"+datos.getNombreP()+datos.getJugador(),djn);
        Partida p= juego.getPartida(datos.getNombreP());
        DatosPartida dp=new DatosPartida(p.getManzanasPodridas(),p.getJugador(datos.getJugador()).getNumVidas(), true);
         msgt.convertAndSend("/topic/estadoPartida"+datos.getNombreP()+datos.getJugador(),djn);
    }
    @MessageMapping("/poblarCasilla")
    public void poblarCasillas(DatosSeleccionCasilla datos){
    Casilla[][] casillasJuego =juego.consultarCasilla(datos);
    Casilla c=null;
    int filas=juego.getPartida(datos.getPartida()).getFilas();
    int columnas=juego.getPartida(datos.getPartida()).getColumnas();
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
            c=casillasJuego[i][j];
            if(c.isEstado()) 
                msgt.convertAndSend("topic/casillaSelect"+datos.getPartida()+datos.getJugador(),c);
                    
            }
        }
    }

            
}

