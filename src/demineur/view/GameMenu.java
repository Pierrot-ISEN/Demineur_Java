/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import demineur.controller.MouseListenerNew;
import demineur.controller.MyActionListener;
import demineur.model.Grid;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author root
 */
public class GameMenu extends JMenuBar {

    private GraphicalGridView frame;
    private CustomGameFrame custom;
    private NewGameFrame newcustom;
    private Grid grid;

    public CustomGameFrame getCustom() {
        return custom;
    }

    public void setCustom(CustomGameFrame custom) {
        this.custom = custom;
    }

    public NewGameFrame getNewcustom() {
        return newcustom;
    }

    public void setNewcustom(NewGameFrame newcustom) {
        this.newcustom = newcustom;
    }

    public GraphicalGridView getFrame() {
        return frame;
    }

    public GameMenu(GraphicalGridView frame) {
        this.frame = frame;
        
        this.custom=new CustomGameFrame();
        this.newcustom= new NewGameFrame();
        JMenu menuGame = new JMenu("Game");
        JMenu menuNew = new JMenu("New");
        this.add(menuGame);
        

        menuNew.addMouseListener(new MouseListenerNew(this, this.frame));
        menuGame.add(menuNew);
        
        JMenuItem menuItemQuit = new JMenuItem("Quit");
        menuItemQuit.addActionListener(new MyActionListener(this, this.frame));
        menuGame.add(menuItemQuit);
        
        JMenuItem menuItemBeginner = new JMenuItem("Beginner");
        menuItemBeginner.addActionListener(new MyActionListener(this, this.frame));
        menuNew.add(menuItemBeginner);
        
        JMenuItem menuItemInter = new JMenuItem("Intermediate");
        menuItemInter.addActionListener(new MyActionListener(this, this.frame));
        menuNew.add(menuItemInter);
        
        JMenuItem menuItemExpert = new JMenuItem("Expert");
        menuItemExpert.addActionListener(new MyActionListener(this, this.frame));
        menuNew.add(menuItemExpert);
        
        JMenuItem menuItemCustom = new JMenuItem("Custom");
        menuItemCustom.addActionListener(new MyActionListener(this, this.frame));
        menuNew.add(menuItemCustom);
        

    }

}
