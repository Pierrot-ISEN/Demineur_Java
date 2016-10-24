package demineur.controller;
import demineur.model.EtatMasked;
import demineur.model.EtatReveals;
import demineur.model.Grid;

public class GameControls { 
    
    public static void command(String entry,Grid grid) {
        
        String tab[] = entry.split(" ");
        
        String action = tab[0];
        
        if (action.equals("q")) {
            System.out.println("---User quit game---");
            System.out.println("");
            System.exit(1);
        }
        
        int x = Integer.parseInt(tab[1]);
        int y = Integer.parseInt(tab[2]);
        
        if (action.equals("d")) {
            if (grid.getCells()[x][y].getEtatReveals() == EtatReveals.MINE) {
                System.out.println("---BOOOOOOOOOM---");
                System.out.println(grid);
                grid.getCells()[x][y].shown = true;
                System.exit(1);
            }
            grid.getCells()[x][y].shown = true;
        }
        
        if (entry.length()>6) {
        String mark = tab[3];
            if (!grid.getCells()[x][y].shown) {     
                switch (mark){
                    case "!":
                        grid.getCells()[x][y].setEtatMasked(EtatMasked.EXMARK);
                        break;
                    case "?":
                        grid.getCells()[x][y].setEtatMasked(EtatMasked.QMARK);
                        break;
                    case "#":
                        grid.getCells()[x][y].setEtatMasked(EtatMasked.HASH);
                        break;
                }
            }  
        }
        
    }
    
}
