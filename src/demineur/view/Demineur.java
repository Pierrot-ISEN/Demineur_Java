/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import demineur.model.Grid;
import demineur.controller.GameControls;
import java.util.Scanner;

/**
 *
 * @author pierrot
 */
public class Demineur {

    public static void main(String[] args) {
        Grid g = new Grid(3,7,3);
        Scanner scan = new Scanner(System.in);
        String commande = scan.toString();
        while (true) {
            System.out.print(g);
            commande = scan.nextLine();
            GameControls.command(commande,g);
        }
        

    }
    
}
