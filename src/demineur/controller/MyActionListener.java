/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.controller;

import demineur.model.Grid;
import demineur.view.GameMenu;
import demineur.view.GraphicalGridView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author root
 */
public class MyActionListener implements ActionListener {

    private GameMenu gameMenu;
    private GraphicalGridView frame;

    public MyActionListener(GameMenu gameMenu, GraphicalGridView frame) {
        this.gameMenu = gameMenu;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Quit".equals(e.getActionCommand())) {
            this.frame.getFrame().dispose();
        } else if ("Beginner".equals(e.getActionCommand())) {
            Grid g = new Grid(9,9,10);
            GraphicalGridView window = new GraphicalGridView(g);
            this.frame.getFrame().dispose();
        } else if ("Intermediate".equals(e.getActionCommand())) {
            Grid g = new Grid(16,16,40);
            GraphicalGridView window = new GraphicalGridView(g);
            this.frame.getFrame().dispose();
        } else if ("Expert".equals(e.getActionCommand())) {
            Grid g = new Grid(16,30,99);
            GraphicalGridView window = new GraphicalGridView(g);
            this.frame.getFrame().dispose();
        } else if ("Custom".equals(e.getActionCommand())) {
            if (this.gameMenu.getNewcustom().isVisible()) {
                this.gameMenu.getNewcustom().setVisible(false);
            }
            System.out.println("Selected: " + e.getActionCommand());
            this.gameMenu.getCustom().setVisible(true);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
