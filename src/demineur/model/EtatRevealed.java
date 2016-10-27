/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.model;

/**
 *
 * @author root
 */
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
