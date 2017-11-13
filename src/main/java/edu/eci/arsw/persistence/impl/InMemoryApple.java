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
    
    private Map<String,CampoJuego> campoJuego =new ConcurrentHashMap();

    public InMemoryApple() {
        
      CampoJuego publica= new CampoJuego();
     
       Partida p=new Partida("Juego1","Dificil");
      Jugador jugador = new Jugador(3, "joha", "blue");
      jugador.setNuevaPartida(p);
     //  p.agregarJugador(jugador);
        publica.agregarPartida(p);
        campoJuego.put("publica", publica);
        
       CampoJuego privada= new CampoJuego();
       Partida pn=new Partida("Juego2","Dificil");
        Jugador jugador1 = new Jugador(3, "jessica", "red");
        jugador1.setNuevaPartida(pn);
       //   pn.agregarJugador(jugador1);
        privada.agregarPartida(pn);
        campoJuego.put("privada", privada);
    }
    
   
    @Override
    public Set<Partida> getPartidasByTipo(String tipoPartida) {
        Set<Partida> p=new HashSet<>();
        p.addAll(campoJuego.get(tipoPartida).getPartidas());
        return p;
    }
    
    
    @Override
    public List<Jugador> getJugadores() {
        CampoJuego publica = campoJuego.get("publica");
        CampoJuego privada= campoJuego.get("privada");
        Set<Partida> pPublica = publica.getPartidas();
        Set<Partida> pPrivada = privada.getPartidas();
        
      
       List<Jugador> users = new ArrayList<>();
  
       for(Partida p:pPublica){
         
      
           users.addAll(p.getJugadores());
             System.out.println("ENTRO A JUGADORES PUBLICA");
       }
   
       for(Partida pn: pPrivada){
           users.addAll(pn.getJugadores());
            System.out.println("ENTRO A JUGADORES PRIVADA");
       }
         return users;
    }
    
    
//  
  
    
  
    @Override
    public void agregarJugador(Partida pn,Jugador jugador, String campoJuego) {
      pn.agregarJugador(jugador);
      this.campoJuego.get(campoJuego).agregarPartida(pn);
       
    }
      


    
    @Override
    public void crearNuevoPartida(String campoJuego, Partida p) {
      this.campoJuego.get(campoJuego).agregarPartida(p);
    }

   
    @Override
    public Partida getPartida(String nombreP, String campoJuego) {
       return this.campoJuego.get(campoJuego).getPartida(nombreP);
    }

  

 
}
