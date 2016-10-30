/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import demineur.model.Grid;
import demineur.controller.GameControls;
import demineur.view.GraphicalCellView;
import demineur.controller.MyMouseListener;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

/**
 *
 * 23 lignes 29 colones
 */
public class GraphicalGridView extends JPanel implements Observer {

    private int width;
    private int height;
    private Grid model;
    private GraphicalCellView JCells[][];
    StatusBar statusBar;
    JFrame frame = new JFrame("Demineur");
    //Menu menu = new Menu();
    
    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Grid getModel() {
        return model;
    }

    public void setModel(Grid model) {
        this.model = model;
    }

    public GraphicalCellView getJCell(int i, int j) {
        return this.JCells[i][j];
    }

    public GraphicalCellView[][] getJCells() {
        return JCells;
    }

    public void setJCells(GraphicalCellView[][] JCells) {
        this.JCells = JCells;
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }

    public JFrame getFrame() {
        return frame;
    }
    
    

    public GraphicalGridView(Grid model) {
        this.model = model;
        this.width = model.getWidth();
        this.height = model.getHeight();
        this.JCells = new GraphicalCellView[this.width][this.height];

        frame.setJMenuBar(new GameMenu(this));
        
        JPanel centre = new JPanel();
        centre.setLayout(new GridLayout(width, height));
        
        frame.setLayout(
            new BorderLayout(5,5)
        );
        /*frame.setLayout(
                new GridLayout(width, height, 0, 0),
                BorderLayout.CENTER
        );*/
        
        /*frame.setLayout(
            new GridLayout(width-15, height-15, 0, 0)
        ); */
        frame.add(
                centre,
                BorderLayout.CENTER
        );
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.JCells[i][j] = new GraphicalCellView(model.getCell(i, j), this);
                centre.add(this.JCells[i][j]);
            }
        }
        this.statusBar = new StatusBar(this.model);
        frame.add(
                this.statusBar,
                BorderLayout.SOUTH
        );

        this.addMouseListener(new MyMouseListener(this));
        this.model.addObserver(this);
        frame.setSize(width * 65, height * 65);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //this.menu.setVisible(true);
    }

    public void maj() {
        System.out.print("YOLOOOOOO Beach");
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
