package demineur.model;

public class Cell {
    private int x;
    private int y;
    private int neighborgsNumber;

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

    public int getNeighborgsNumber() {
        return neighborgsNumber;
    }

    public void setNeighborgsNumber(int neighborgsNumber) {
        this.neighborgsNumber = neighborgsNumber;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
