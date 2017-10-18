/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filter;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.List;

/**
 *
 * @author 3070465
 */
public class FilterSubmuestreo implements BluePrintFilter {

    @Override
    public Blueprint suprimir(Blueprint b) {
        Point[] p;
        List<Point> points=null;
        p = new Point[b.getPoints().size()];
        for (int i = 0; i < b.getPoints().size(); i++) {
            if (i % 2 == 0) {
                points.add(b.getPoints().get(i));
            }
        }
        for (int j = 0; j < points.size(); j++) {
            p[j] = points.get(j);
        }

        Blueprint retornar = new Blueprint(b.getAuthor(), b.getName(), p);
        return retornar;
    }
}