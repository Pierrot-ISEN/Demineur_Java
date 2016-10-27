package demineur.model;

import java.util.Observable;

public class Cell extends Observable  {

    private int x;
    private int y;
    private int nbNeighbour;
    private EtatMasked etatMasked;
    private EtatRevealed etatRevealed;
    private boolean shown;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNbNeighbour() {
        return nbNeighbour;
    }

    public void setNbNeighbour(int nbNeighbour) {
        this.nbNeighbour = nbNeighbour;
    }

    public EtatMasked getEtatMasked() {
        return etatMasked;
    }

    public void setEtatMasked(EtatMasked etatMasked) {
        this.etatMasked = etatMasked;
        setChanged();
        notifyObservers();
    }

    public void setEtatRevealed(EtatRevealed etatRevealed) {
        this.etatRevealed = etatRevealed;
    }

    public EtatRevealed getEtatRevealed() {
        return etatRevealed;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
        this.setChanged();
        this.notifyObservers();
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        //this.etatMasked=EtatMasked.HASH;
        //this.etatRevealed=EtatRevealed.MINE;
    }

    @Override
    public String toString() {
        //this.shown = true;
        if (this.shown == true) {
            if (this.nbNeighbour == 0) {
                return this.etatRevealed.toString();
            }else{
                return Integer.toString(this.nbNeighbour);
            }
        } else {
            return this.etatMasked.toString();
        }
    }

}
