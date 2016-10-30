/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class MyTextField extends JTextField{
    
    public MyTextField(int value) {
        this.setColumns(6);
        this.setText(Integer.toString(value));
        
    }

    
    
    
}
