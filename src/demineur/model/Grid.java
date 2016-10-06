/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.model;
public class Grid {
    private int length;
    private int width;
    private Cell cells[][];
    
    public int getLenght() {
        return length;
    }

    public void setLenght(int lenght) {
        this.length = lenght;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }  
    
    public Grid(int taille) { 
        
        int x;
        int y;
        
        this.length = taille;
        this.width = taille;
        this.cells = new Cell[this.length][this.width];
        
        for (x=0;x<taille;x++) {
            for (y=0;y<taille-1;y++) {               
                this.cells[x][y] = new Cell(x,y);
//                this.dalle[x][y].addObserver(this);
            }
        
    }
    
    public Grid(int length,int width) {
        this.length = length;
        this.width = width;
    }
    
}
