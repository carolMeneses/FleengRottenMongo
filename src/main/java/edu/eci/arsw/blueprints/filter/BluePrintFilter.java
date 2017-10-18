/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filter;

import edu.eci.arsw.blueprints.model.Blueprint;
import org.springframework.stereotype.Service;

/**
 *
 * @author 3070465
 */
@Service
public interface BluePrintFilter {
        public Blueprint suprimir(Blueprint b);

     
}

