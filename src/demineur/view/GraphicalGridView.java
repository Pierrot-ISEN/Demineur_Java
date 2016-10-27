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

/**
 *
 * 23 lignes 29 colones
 */
public class GraphicalGridView extends JPanel implements Observer {

    private int width;
    private int height;
    private Grid model;
    private GraphicalCellView JCells[][];

    JFrame frame = new JFrame("Demineur");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Partie");
    JMenuItem item1 = new JMenuItem();
    JMenuItem item2 = new JMenuItem();

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

    public GraphicalGridView(Grid model) {
        this.model = model;
        this.width = model.getWidth();
        this.height = model.getHeight();
        this.JCells = new GraphicalCellView[this.width][this.height];

        menu.add(item1);
        menu.add(item2);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setLayout(
                new GridLayout(width, height, 0, 0)
        );
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.JCells[i][j] = new GraphicalCellView(model.getCell(i, j), this);
                frame.add(this.JCells[i][j]);
            }
        }

        this.addMouseListener(new MyMouseListener(this));
        this.model.addObserver(this);
        frame.setSize(width * 75, height * 75);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        menuBar.setVisible(true);
    }

    public void maj() {

    }

    @Override
    public void update(Observable o, Object arg) {
        maj();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
