/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.Tuple;
import static java.lang.reflect.Array.set;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */

public class InMemoryPersistenceTest {
    
   @Test
    public void saveNewAndLoadTest() throws BlueprintPersistenceException, BlueprintNotFoundException{
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        
        ibpp.saveBlueprint(bp0);
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        ibpp.saveBlueprint(bp);
        
        assertNotNull("Loading a previously stored blueprint returned null.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()));
        
        assertEquals("Loading a previously stored blueprint returned a different blueprint.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()), bp);
        
    }


    @Test
    public void saveExistingBpTest() {
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        try {
            ibpp.saveBlueprint(bp);
        } catch (BlueprintPersistenceException ex) {
            fail("Blueprint persistence failed inserting the first blueprint.");
        }
        
        Point[] pts2=new Point[]{new Point(10, 10),new Point(20, 20)};
        Blueprint bp2=new Blueprint("john", "thepaint",pts2);

        try{
            ibpp.saveBlueprint(bp2);
            fail("An exception was expected after saving a second blueprint with the same name and autor");
        }
        catch (BlueprintPersistenceException ex){
            
        }
    }
    @Test
    public void getBlueprintbyAuthor_nombreTest() throws BlueprintPersistenceException {

        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Point[] pts = new Point[]{new Point(0, 0), new Point(10, 10)};
        Blueprint bp = new Blueprint("john", "thepaint", pts);
        ibpp.saveBlueprint(bp);
        try {
            Blueprint t = ibpp.getBlueprint("john", "thepaint");
            assertEquals("nombres equivalentes.", t.getAuthor(), bp.getAuthor());
            assertEquals("Apellidos equivalentes.", t.getName(), bp.getName());
            //InMemoryBlueprintPersistence bp = new InMemoryBlueprintPersistence("john", "thepaint", pts);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(InMemoryPersistenceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   @Test
    public void getBlueprintbyAuthorTest() throws BlueprintPersistenceException {

        Blueprint blue = new Blueprint();
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Point[] pts = new Point[]{new Point(0, 0), new Point(10, 10)};
        Blueprint bp = new Blueprint("john", "thepaint", pts);
        ibpp.saveBlueprint(bp);
        Point[] pts1 = new Point[]{new Point(0, 0), new Point(10, 10)};
        Blueprint bp1 = new Blueprint("maria", "arte1", pts);
        ibpp.saveBlueprint(bp1);

        Set<Blueprint> retorno = ibpp.getBlueprintsByAuthor("maria");
        for (Blueprint b : retorno) {
            if (b.getAuthor().equals("maria")) {
                blue = b;
            }
        }
        assertTrue(blue.getName().equals("arte1"));
        assertTrue(blue.getAuthor().equals("maria"));

        //InMemoryBlueprintPersistence bp = new InMemoryBlueprintPersistence("john", "thepaint", pts);
    }
        @Test
    public void getBlueprintTest() throws BlueprintPersistenceException, BlueprintNotFoundException {
        
        int cont=0;
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();
        Point[] pts = new Point[]{new Point(0, 0), new Point(10, 10)};
        Blueprint bp = new Blueprint("John", "thepaint", pts);
        ibpp.saveBlueprint(bp);
        Point[] pt = new Point[]{new Point(30, 30), new Point(100, 100)};
        Blueprint b = new Blueprint("Marcos", "arte2", pts);
            ibpp.saveBlueprint(b);
       
            Set<Blueprint> retorno = ibpp.getAllBlueprints();
            for (Blueprint b1 : retorno) {
                if (b1.getAuthor().equals("John")) cont++;
                if (b1.getAuthor().equals("Marcos")) cont++;
            }
        assertTrue(cont==2);

    }
}
