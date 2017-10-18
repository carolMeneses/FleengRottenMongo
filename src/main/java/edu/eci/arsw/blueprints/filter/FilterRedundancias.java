/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filter;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author 3070465
 */
@Service
public class FilterRedundancias implements BluePrintFilter {

    @Override
    public Blueprint suprimir(Blueprint b) {
        // Blueprint retornar = b;
        Point[] p;

        List<Point> points = b.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
//            for (int j = i + 1; j < points.size(); j++) {
            if (i != points.size() - 1 && points.get(i) == points.get(i + 1)) {
                points.remove(i);
            }

        }

        p = new Point[points.size()];
        for (int i = 0; i < points.size(); i++) {
            p[i] = points.get(i);
        }

        Blueprint retornar = new Blueprint(b.getAuthor(), b.getName(), p);
        return retornar;
    }
}
