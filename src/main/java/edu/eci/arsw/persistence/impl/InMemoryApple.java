/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.model.CampoJuego;
import edu.eci.arsw.model.Jugador;
import edu.eci.arsw.model.Partida;
import edu.eci.arsw.persistencia.interfaces.applePersistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public class InMemoryApple  implements applePersistence{
    
    private Map<String,CampoJuego> campoJuego;

    public InMemoryApple() {
        campoJuego= new ConcurrentHashMap();
        
    }
    
    public void iniciar(){
        CampoJuego publica= new CampoJuego();
        CampoJuego privada= new CampoJuego();
        Partida p=new Partida("Juego1","Dificil");
        Jugador jugador = new Jugador(3, "joha", "blue");
        jugador.setNuevaPartida(p);
        p.agregarJugador(jugador);
        Partida pn=new Partida("Juego2","Dificil");
        Jugador jugador1 = new Jugador(3, "jessica", "red");
        jugador1.setNuevaPartida(p);
        p.agregarJugador(jugador1);
        publica.agregarPartida(p);
        privada.agregarPartida(pn);
        campoJuego.put("publica", publica);
        campoJuego.put("privada", privada);
    }
    
   
    public Set<Partida> getPartidasByTipo(String tipoPartida) {
        Set<Partida> p=new HashSet<>();
        p.addAll(campoJuego.get(tipoPartida).getPartidas());
        return p;
    }
    
    
    public List<Jugador> getJugadores() {
        
       List<Jugador> users = new ArrayList<Jugador>();
       Set<Partida> pu=getPartidasByTipo("publica");
       for(Partida p: pu){
           users.addAll(p.getJugadores());
       }
       pu=getPartidasByTipo("privada");
       for(Partida p: pu){
           users.addAll(p.getJugadores());
       }
         return users;
    }
    
    
//  
  
    
  
    public void agregarJugador(Partida pn,Jugador jugador, String campoJuego) {
      pn.agregarJugador(jugador);
      this.campoJuego.get(campoJuego).agregarPartida(pn);
       
    }
      


    
    public void crearNuevoPartida(String campoJuego, Partida p) {
      this.campoJuego.get(campoJuego).agregarPartida(p);
    }

   
    public Partida getPartida(String nombreP, String campoJuego) {
       return this.campoJuego.get(campoJuego).getPartida(nombreP);
    }

  

 
}
