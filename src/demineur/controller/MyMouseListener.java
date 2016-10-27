package demineur.controller;

import demineur.controller.GameControls;
import demineur.view.GraphicalCellView;
import demineur.view.GraphicalGridView;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class MyMouseListener implements MouseListener {
// MouseListener interface implementation
    private GraphicalGridView frame;

    public MyMouseListener() {
    }
    
    public MyMouseListener(GraphicalGridView frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("Click detected at location: " + e.getPoint());
    }
// empty but mandatory

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //command("d");
        GraphicalCellView button;
       
        if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
            System.out.println("Click gauche");
            if (e.getSource() instanceof GraphicalCellView) {
                button = (GraphicalCellView)e.getSource();
                GameControls.leftClick(button.getMyModel(),this.frame);
            }
 
        } else if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
            System.out.println("Click droit");    
            button = (GraphicalCellView)e.getSource();
                GameControls.mark(button);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Relachement: " + e.getPoint());
    }

}// end class MyMouseListener
