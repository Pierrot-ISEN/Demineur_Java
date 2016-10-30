/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JSlider;

/**
 *
 * @author root
 */
public class MySlider extends JSlider {  
    

    public MySlider(int max, int min, int majorTick, int minorTick,int value) {
        
        this.setMaximum(max);
        this.setMinimum(min);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        this.setMinorTickSpacing(minorTick);
        this.setMajorTickSpacing(majorTick);
        this.setValue(value);

    }



}
