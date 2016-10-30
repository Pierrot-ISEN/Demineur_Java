package demineur.view;

import javax.swing.JTextField;

public class MyTextField extends JTextField{
    
    public MyTextField(int value) {
        this.setColumns(6);
        this.setText(Integer.toString(value));
        
    }

    
    
    
}
