/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.filter.BluePrintFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class InMemoryBlueprintPersistence implements BlueprintsPersistence {

    private final Map<Tuple<String, String>, Blueprint> blueprints = new ConcurrentHashMap();
    //  @Autowired
    //private BluePrintFilter p;

    public InMemoryBlueprintPersistence() {
        //load stub data
        Point[] pts = new Point[]{new Point(140, 140), new Point(115, 115)};
        Blueprint bp = new Blueprint("Evangeline", "Tommy", pts);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        Point[] pt = new Point[]{new Point(14, 14), new Point(11, 11)};
        Blueprint b = new Blueprint("Evangeline", "Jessica", pt);
        blueprints.put(new Tuple<>(b.getAuthor(), b.getName()), b);
        Point[] t = new Point[]{new Point(12, 124), new Point(121, 121)};
        Blueprint bps = new Blueprint("Eva", "Jess", t);
        blueprints.put(new Tuple<>(bps.getAuthor(), bps.getName()), bps);

    }

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        //  p.suprimir(bp);
        // bp=p.suprimir(bp);

        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(), bp.getName()))) {
            throw new BlueprintPersistenceException("The given blueprint already exists: " + bp);
        } else {
            blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        }
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        return blueprints.get(new Tuple<>(author, bprintname));

    }
//      public Blueprint getBlueprintByAuthor(String author) throws BlueprintNotFoundException {
////          ArrayList<Blueprint> bp=new ArrayList<>();
////          Set<Map.Entry<Tuple<String, String>, Blueprint>> b= blueprints.entrySet();
////          if((author).equals(b.))
//       //return blueprints.get(new t)
//        return null;
//    }
// ARREGLAR 

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) {

        Collection<Blueprint> blue = blueprints.values();

        Set<Blueprint> retorno = new HashSet<>();
        for (Blueprint b : blue) {
            if (b.getAuthor().equals(author)) {
                retorno.add(b);
            }
        }
        return retorno;
    }

    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        //ArrayList<Blueprint> blue = (ArrayList<Blueprint>) blueprints.values();
        Collection<Blueprint> blue = blueprints.values();
        Set<Blueprint> retorno = new HashSet<>();

        retorno.addAll(blue);
        return retorno;
    }

//Metodo de prueba
//    @Override
//    public String getBlueprin(String author, String bprintname) throws BlueprintNotFoundException {
//        return "hola";
//    }
    @Override
    public void actualizar(Blueprint b) {
        if (blueprints.containsKey(new Tuple<>(b.getAuthor(), b.getName()))) {
            blueprints.replace(new Tuple<>(b.getAuthor(), b.getName()), b);
        }
    }

    @Override
    public void crearNuevoPlano(Blueprint b) {
        // Point p=new Point();
        // List<Point> points=null;
         
        System.out.print("entro"+b.getAuthor());
        blueprints.put(new Tuple<>(b.getAuthor(), b.getName()), b);
    }

//        Set<Tuple<String, String>> blue = blueprints.keySet();
//        String autor=b.getAuthor();
//        String nombre=b.getName();
//        for (Tuple<String, String> bprint : blue) {
//            
//            String out=bprint.getElem1();
//            String out1=bprint.getElem2();
//            if (out.equals(autor)&& out1.equals(nombre)) {
//                blueprints.remove(bprint, b);
//                try {
//                    saveBlueprint(b);
//                } catch (BlueprintPersistenceException ex) {
//                    Logger.getLogger(InMemoryBlueprintPersistence.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                System.out.println(bprint);
//                System.out.println(b);
//            }
//        }
    @Override
    public void eliminar(Blueprint b) {
        if (blueprints.containsKey(new Tuple<>(b.getAuthor(), b.getName()))) {
            blueprints.remove(new Tuple<>(b.getAuthor(), b.getName()));
        }
    }

}
