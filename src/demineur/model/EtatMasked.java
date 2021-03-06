package demineur.model;

public enum EtatMasked {
    QMARK("?"),
    EXMARK("!"),
    HASH("");

    public final String label;

    private EtatMasked(String label) {
        this.label = label;
    }

    @Override
    public String toString(){
       return this.label;
    }
    
    
    public static EtatMasked getEtatMasked(String label) {
        switch (label) {
            case "?":
                return EtatMasked.QMARK;
            case "!":
                return EtatMasked.EXMARK;
            case "":
                return EtatMasked.HASH;
            default:
                return null;
        }

    }
    
    /*public static EtatMasked getMasked (String label){
        if(this.label==label.)
    }*/
    
}
