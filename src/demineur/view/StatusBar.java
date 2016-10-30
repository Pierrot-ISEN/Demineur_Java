package demineur.view;

import demineur.model.Grid;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel implements Observer {
    
    private Grid grid;
    private JLabel label;

    public void setLabel(int i) {
        String s = "Mines remaining: ";
        this.label.setText(s + i);
    }
    
    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    
    public StatusBar(Grid grid) {
        this.setGrid(grid);
        this.label = new JLabel("Mines remaining: " + this.grid.getNbMaskMine());
        this.grid.addObserver(this);
        this.add(this.label);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.setLabel(this.grid.statusUpdate());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
