package demineur.view;

import demineur.model.Grid;

public class Main {
    
    public static void main(String[] args) {
        
        //GAME init
        int taille = 10;
        Grid g = new Grid(taille,10);
        GraphicalGridView window = new GraphicalGridView(g);
       
    }

}
