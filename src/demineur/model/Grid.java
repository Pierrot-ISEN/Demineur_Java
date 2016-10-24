/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.model;

import java.util.Random;

public class Grid {

    private int length;
    private int width;
    private Cell cells[][];
    private int nbMaskMine;
    private static final int DEFAULT_COTE = 10;
    private static final int DEFAULT_MINE = 5;

    public int getLength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
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

    public int getNbMaskMine() {
        return nbMaskMine;
    }

    public void setNbMaskMine(int nbMaskMine) {
        this.nbMaskMine = nbMaskMine;
    }

    public Grid(int taille, int nbMaskMine) {

        int x;
        int y;
/*        Random rnd = new Random();
        int nbRand1 = rnd.nextInt(this.length);
        int nbRand2 = rnd.nextInt(this.width);*/
        double rnd1 = Math.random()*this.length;
        double rnd2 = Math.random()*this.width;
        

        this.length = taille;
        if (this.length < 0) {
            this.length = -this.length;
        } else if (this.length == 0) {
            this.length = DEFAULT_COTE;
        }

        this.width = taille;
        if (this.width < 0) {
            this.width = -this.width;
        } else if (this.width == 0) {
            this.width = DEFAULT_COTE;
        }
        this.nbMaskMine = nbMaskMine;

        this.cells = new Cell[this.length][this.width];
        //create grid with cell
        for (x = 0; x < taille; x++) {
            for (y = 0; y < taille; y++) {
                this.cells[x][y] = new Cell(x, y);
                this.cells[x][y].setEtatMasked(EtatMasked.HASH);
            }
        }
        for (int i = 0; i < nbMaskMine; i++) {
            /*if(this.cells[nbRand1][nbRand2]!= this.cells[nbRand1][nbRand2].getEtatReveals("x")){
                this.cells[nbRand1][nbRand2].setEtatReveals(EtatReveals.MINE);
            } else {
            }*/
            while (nbMaskMine != 0) {
                this.cells[(int)rnd1][(int)rnd2].setEtatReveals(EtatReveals.MINE);
                rnd1 = Math.random()*this.length;
                rnd2 = Math.random()*this.width;
                nbMaskMine--;
            }

        }

    }

    @Override
    public String toString() {
        int x, y;
        String str = "";
        for (x = 0; x < this.length; x++) {
            for (y = 0; y < this.width; y++) {
                str += this.cells[x][y].toString() + " ";
            }
            str += "\n";
        }
        return str;
    }

}
