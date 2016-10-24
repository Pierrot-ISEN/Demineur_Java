package demineur.model;

public class Cell {

    private int x;
    private int y;
    private int nbNeighbour;
    private EtatMasked etatMasked;
    private EtatReveals etatReveals;
    public boolean shown;

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
    }

    public void setEtatReveals(EtatReveals etatReveals) {
        this.etatReveals = etatReveals;
    }

    public EtatReveals getEtatReveals() {
        return etatReveals;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        //this.etatMasked=EtatMasked.HASH;
        //this.etatReveals=EtatReveals.MINE;

    }

    @Override
    public String toString() {
        //this.shown = true;
        if (this.shown == true) {
            if (this.nbNeighbour == 0) {
                return this.etatReveals.toString();
            }else{
                return Integer.toString(this.nbNeighbour);
            }
        } else {
            return this.etatMasked.toString();
        }
    }

}
