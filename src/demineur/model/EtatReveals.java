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
    MINE("x"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8");

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
            case "1":
                return EtatReveals.ONE;
            case "2":
                return EtatReveals.TWO;
            case "3":
                return EtatReveals.THREE;
            case "4":
                return EtatReveals.FOUR;
            case "5":
                return EtatReveals.FIVE;
            case "6":
                return EtatReveals.SIX;
            case "7":
                return EtatReveals.SEVEN;
            case "8":
                return EtatReveals.EIGHT;
            default:
                return null;

        }
    }

}
