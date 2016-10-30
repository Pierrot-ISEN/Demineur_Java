/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.controller;

import demineur.model.Grid;
import demineur.view.CustomGameFrame;
import demineur.view.CustomGamePanel;
import demineur.view.GraphicalGridView;
import demineur.view.NewGameFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author root
 */
public class MyValidationListener implements MouseListener {

    private JFrame gameFrame;
    private CustomGameFrame customFrame;
    private NewGameFrame newGameFrame;
    private CustomGamePanel customPanel;

    public MyValidationListener(JFrame frame, CustomGameFrame customFrame, CustomGamePanel customPanel) {
        this.gameFrame = frame;
        this.customFrame = customFrame;
        this.customPanel = customPanel;
    }

    public MyValidationListener(JFrame frame, NewGameFrame newGameFrame, CustomGamePanel customPanel) {
        this.gameFrame = frame;
        this.newGameFrame = newGameFrame;
        this.customPanel = customPanel;
    }

    /*public MyValidationListener(JFrame frame, JFrame menu, JFrame newcustom) {
        this.frame = frame;
        this.customenu = menu;
        this.newcustom = newcustom;
}*/
    @Override
    public void mousePressed(MouseEvent e) {
        if (this.newGameFrame == null) {
            this.gameFrame.dispose();
            Grid g = new Grid(this.customPanel.getSliderR().getValue(), this.customPanel.getSliderC().getValue(), this.customPanel.getSliderM().getValue());
            GraphicalGridView window = new GraphicalGridView(g);
            this.customFrame.dispose();
        } else {
            this.gameFrame.dispose();
            Grid g = new Grid(this.customPanel.getSliderR().getValue(), this.customPanel.getSliderC().getValue(), this.customPanel.getSliderM().getValue());
            GraphicalGridView window = new GraphicalGridView(g);
            this.newGameFrame.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
