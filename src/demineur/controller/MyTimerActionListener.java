package demineur.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class MyTimerActionListener implements ActionListener {

    private JLabel timer;
    private int count;
    
    public MyTimerActionListener(JLabel timer) {
        this.timer = timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count += 1;
        timer.setText("Time: " + Integer.toString(count));
    }
    
}