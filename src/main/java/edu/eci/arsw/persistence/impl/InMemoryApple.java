/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.impl;

import edu.eci.arsw.model.Jugador;
import edu.eci.arsw.model.Partida;
import edu.eci.arsw.persistencia.applePersistence;
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
public class InMemoryApple implements applePersistence {
 private final Map<String,Partida> partidas= new ConcurrentHashMap();

    public InMemoryApple() {
        Partida p=new Partida("Dificil","Juego1","Publica","Johana");
        partidas.put("juego1", p);
        Partida pn=new Partida("Facil","Juego2","Privada","Jessica");
        partidas.put("juego2", pn);
    }
    
    @Override
    public Set<Partida> getTodaslasPartidas() {
        Collection<Partida> part = partidas.values();
        Set<Partida> p = new HashSet<>();
        for (Partida pn : part) {

            p.add(pn);
        }
        return p;
    }
    
    
    @Override
    public Set<Partida> getPartidasByTipo(String tipoPartida) {
        Collection<Partida> part = partidas.values();
        Set<Partida> p=new HashSet<>();
        for(Partida pn:part){
            if(pn.getTipoPartda().equals(tipoPartida)){
                p.add(pn);
            }
        }
        return p;
    }
    
    @Override
    public List<Jugador> getJugadores(Partida pn) {
        //Estamos convirtiendo array list en lista
     List<Jugador> j= pn.getJugadores();
     return j;
    }
    
    @Override
    public Partida getPartidaJugador(String j) {
        Partida retornar=null;
        Collection<Partida> part = partidas.values();
        Set<Partida> p = new HashSet<>();
        for (Partida pn : part) {
            ArrayList<Jugador>  jugadores= pn.getJugadores();
            for (int i=0;i<jugadores.size();i++){
               if( jugadores.get(i).getNombre().equals(j)){
                   retornar=jugadores.get(i).getPartida();
               }
            }
            
        }
        return retornar;
    }
    
 @Override
    public boolean agregarJugador(Partida pn,String nombre) {
      boolean agrego=false;
      agrego=pn.agregarJugador(nombre);
       pn.getJugador(nombre).asignaPartida(pn);
       return agrego;
    }


        



    @Override
    public void eliminar(Partida p) {
         if (partidas.containsKey(p.getNombrePartida())) {
          partidas.remove(p.getNombrePartida());
        }
    }

    @Override
    public void crearNuevoPartida(Partida p) {
      partidas.put(p.getNombrePartida(),p);
    }

 

    
}
