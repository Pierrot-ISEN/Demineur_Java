package demineur.controller;

import demineur.view.GameMenu;
import demineur.view.GraphicalGridView;
import demineur.view.NewGameFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenu;

public class MouseListenerNew implements MouseListener {

    private GameMenu gameMenu;
    private GraphicalGridView frame;
    

    public MouseListenerNew(GameMenu gameMenu, GraphicalGridView frame) {
        this.gameMenu = gameMenu;
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            JMenu menuNew = (JMenu) e.getSource();
            
            if ("New".equals(menuNew.getActionCommand())) {
                if(this.gameMenu.getCustom().isVisible()){
                    this.gameMenu.getCustom().setVisible(false);
                }
                this.gameMenu.getNewcustom().setVisible(true);
            }
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
