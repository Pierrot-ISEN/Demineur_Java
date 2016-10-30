package demineur.controller;

import demineur.model.Grid;
import demineur.view.GraphicalGridView;
import demineur.view.EndGameFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class MyEndGameListener implements MouseListener {

    private EndGameFrame frame;
    
    public MyEndGameListener(EndGameFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton button = (JButton)e.getSource();
        if (button.getText() == "Replay") {
            this.frame.dispose();
            Grid g = new Grid(10,10,10);
            GraphicalGridView window = new GraphicalGridView(g);
        } else {
            this.frame.dispose();
        }
            
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
