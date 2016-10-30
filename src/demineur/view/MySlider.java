package demineur.view;

import javax.swing.JSlider;

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
