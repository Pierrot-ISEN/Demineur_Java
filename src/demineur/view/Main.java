/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import demineur.model.Grid;
import demineur.controller.GameControls;
import demineur.view.GraphicalGridView;
import demineur.view.GraphicalCellView;
import java.util.Scanner;

/**
 *
 * @author pierrot
 */
public class Main {
    
    public static void main(String[] args) {
        
        int taille = 10;
        Grid g = new Grid(taille,10);
        GraphicalGridView window = new GraphicalGridView(g);
       
    }

}
