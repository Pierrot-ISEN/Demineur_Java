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
public enum EtatReveals {
    EMPTY("."),
    MINE("x");

    private final String label;

    private EtatReveals(String label) {
        this.label = label;
    }
    
    @Override
    public String toString(){
        return this.label;
    }

    public  EtatReveals getEtatReveals(String label) {
        switch (label) {
            case ".":
                return EtatReveals.EMPTY;
            case "x":
                return EtatReveals.MINE;
            default:
                return null;

        }
    }

}
