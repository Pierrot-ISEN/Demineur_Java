package demineur.model;

import java.util.Observable;

public class Grid extends Observable {

    private int width;
    private int height;
    private Cell cells[][];
    private boolean fristClick;
    private int nbClick;
    private int nbMaskMine;
    private int nbMarkedCells = 0;
    private static final int DEFAULT_COTE = 10;
    private static final int DEFAULT_MINE = 5;
    
    //GETTERS & SETTERS --------------------------------------------------------
    public int getWidth() {
        return width;
    }

    public void setlength(int width) {
        this.width = width;
        setChanged();
        notifyObservers();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        setChanged();
        notifyObservers();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int i, int j) {
        return this.cells[i][j];
    }

    public void cellChanged() {
        setChanged();
        notifyObservers();
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
        setChanged();
        notifyObservers();
    }

    public int getNbMaskMine() {
        return nbMaskMine;
    }

    public void setNbMaskMine(int nbMaskMine) {
        setChanged();
        notifyObservers();
        this.nbMaskMine = nbMaskMine;
    }

    public int getNbMarkedCells() {
        return nbMarkedCells;
    }

    public void setNbMarkedCells(int nbMarkedCells) {
        this.nbMarkedCells = nbMarkedCells;
        setChanged();
        notifyObservers();
    }

    public int getNbClick() {
        return nbClick;
    }

    public void incNbClick() {
        this.nbClick++;
    }

    public void setNbClick(int nbClick) {
        this.nbClick = nbClick;
    }

    public boolean isFristClick() {
        return fristClick;
    }

    public void setFristClick(boolean fristClick) {
        this.fristClick = fristClick;
    }
    
    //--------------------------------------------------------------------------
    
    //2 parameters Constructor (Square grid)
    public Grid(int taille, int nbMaskMine) {
        this(taille, taille, nbMaskMine);
    }
    
    //3 parameters constructor
    public Grid(int length, int height, int nbMaskMine) {

        int x;
        int y;
        this.fristClick = true;

        this.width = length;
        if (this.width < 0) {
            this.width = -this.width;
        } else if (this.width == 0) {
            this.width = DEFAULT_COTE;
        }

        this.height = height;
        if (this.height < 0) {
            this.height = -this.height;
        } else if (this.height == 0) {
            this.height = DEFAULT_COTE;
        }

        this.nbMaskMine = nbMaskMine;

        this.cells = new Cell[this.width][this.height];
        //create grid with cell
        for (x = 0; x < length; x++) {
            for (y = 0; y < height; y++) {
                this.cells[x][y] = new Cell(x, y);
                this.cells[x][y].setEtatMasked(EtatMasked.HASH);
                this.cells[x][y].setEtatRevealed(EtatRevealed.EMPTY);
            }
        }
    }

    //Called after first click, randomly sets mines
    public void setMines() {

        double rnd1 = Math.random() * this.width;
        double rnd2 = Math.random() * this.height;
        int nbMaskMine = this.nbMaskMine;

        for (int i = 0; i < nbMaskMine; i++) {
            while (nbMaskMine != 0) {
                if (this.cells[(int) rnd1][(int) rnd2].getEtatRevealed() != EtatRevealed.MINE) {
                    this.cells[(int) rnd1][(int) rnd2].setEtatRevealed(EtatRevealed.MINE);
                    nbMaskMine--;
                }
                rnd1 = Math.random() * this.width;
                rnd2 = Math.random() * this.height;
            }
        }
        this.mooreNeighborhood();
    }
    
    //sets the cells' neighboors
    public void mooreNeighborhood() {
        int nbNeighbour = 0;
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                if (this.cells[x][y].getEtatRevealed() == EtatRevealed.EMPTY) {
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            if (i > -1 && i < this.width && j > -1 && j < this.height) {
                                if (this.cells[i][j].getEtatRevealed() == EtatRevealed.MINE) {
                                    nbNeighbour++;
                                }
                            }
                        }
                    }

                }
                this.cells[x][y].setNbNeighbour(nbNeighbour);
                nbNeighbour = 0;
            }
        }
    }

    //To count the number of marked cells
    public int statusUpdate() {
        int nbMarkedCells = 0;
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                if (!this.cells[x][y].isShown()) {
                    if (this.cells[x][y].getEtatMasked() == EtatMasked.EXMARK) {
                        nbMarkedCells++;
                    }
                }
            }
        }
        this.nbMarkedCells = nbMarkedCells;
        return this.nbMaskMine - nbMarkedCells;
    }

    //Console mode
    @Override
    public String toString() {
        int x, y;
        String str = "";
        for (x = 0; x < this.width; x++) {
            for (y = 0; y < this.height; y++) {
                str += this.cells[x][y].toString() + " ";
            }
            str += "\n";
        }
        return str;
    }

}
