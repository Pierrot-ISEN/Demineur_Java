package demineur.controller;

import demineur.view.GraphicalGridView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class MyTimerActionListener implements ActionListener {

    private JLabel timer;
    private int value;
    private GraphicalGridView gridView;
    
    public MyTimerActionListener(JLabel timer,GraphicalGridView gridView) {
        this.timer = timer;
        this.gridView = gridView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        value += 1;
        timer.setText("Time: " + Integer.toString(value));
        gridView.setTimerValue(value);
    }
    
}