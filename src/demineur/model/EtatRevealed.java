package demineur.model;

public enum EtatRevealed {
    EMPTY("."),
    MINE("x");

    private final String label;

    private EtatRevealed(String label) {
        this.label = label;
    }
    
    @Override
    public String toString(){
        return this.label;
    }

    public  EtatRevealed getEtatRevealed(String label) {
        switch (label) {
            case ".":
                return EtatRevealed.EMPTY;
            case "x":
                return EtatRevealed.MINE;
            default:
                return null;

        }
    }

}
