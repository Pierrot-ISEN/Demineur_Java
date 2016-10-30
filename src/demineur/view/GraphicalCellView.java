/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import javax.swing.JButton;
import demineur.model.Cell;
import demineur.controller.MyMouseListener;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

public class GraphicalCellView extends JButton implements Observer {

    private Cell myModel;
    private int posx;
    private int posy;
    
    public Cell getMyModel() {
        return this.myModel;
    }

    public void setModel(Cell model) {
        this.myModel = model;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public GraphicalCellView(Cell cell, GraphicalGridView grid) {
        this.setText("");
        this.setFont(new Font("Arial", Font.PLAIN, 10));
        this.myModel = cell;
        myModel.addObserver(this);
        this.addMouseListener(new MyMouseListener(grid));
    }

    public void cellChanged() {
        this.setEnabled(!this.getMyModel().isShown());
        this.setText(this.myModel.toString());
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            cellChanged();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
