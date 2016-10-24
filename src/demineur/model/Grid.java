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

    public Grid(int length, int width, int nbMaskMine) {

        int x;
        int y;
        /*        Random rnd = new Random();
        int nbRand1 = rnd.nextInt(this.length);
        int nbRand2 = rnd.nextInt(this.width);*/
        double rnd1 = Math.random() * this.length;
        double rnd2 = Math.random() * this.width;

        this.length = length;
        if (this.length < 0) {
            this.length = -this.length;
        } else if (this.length == 0) {
            this.length = DEFAULT_COTE;
        }

        this.width = width;
        if (this.width < 0) {
            this.width = -this.width;
        } else if (this.width == 0) {
            this.width = DEFAULT_COTE;
        }

        this.nbMaskMine = nbMaskMine;

        this.cells = new Cell[this.length][this.width];
        //create grid with cell
        for (x = 0; x < length; x++) {
            for (y = 0; y < width; y++) {
                this.cells[x][y] = new Cell(x, y);
                this.cells[x][y].setEtatMasked(EtatMasked.HASH);
                this.cells[x][y].setEtatReveals(EtatReveals.EMPTY);
            }
        }
        for (int i = 0; i < nbMaskMine; i++) {
            while (nbMaskMine != 0) {
                if (this.cells[(int) rnd1][(int) rnd2].getEtatReveals() != EtatReveals.MINE) {
                    this.cells[(int) rnd1][(int) rnd2].setEtatReveals(EtatReveals.MINE);
                    nbMaskMine--;
                }
                rnd1 = Math.random() * this.length;
                rnd2 = Math.random() * this.width;
            }

        }

    }

    public Grid(int taille, int nbMaskMine) {
        this(taille, taille, nbMaskMine);
    }

    /* int mooreNeighborhood(int nbNeighbour) {
        for (int x = 0; x < this.length; x++) {
            for (int y = 0; y < this.width; y++) {
                if (this.cells[x][y].getEtatReveals() == EtatReveals.MINE) {
                    this.cells[x-1][y-1;
                }
            }
        }
        return nbNeighbour;
    } */
    
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
