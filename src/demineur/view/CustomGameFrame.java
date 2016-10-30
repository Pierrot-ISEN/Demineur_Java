/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import demineur.model.Grid;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author root
 */
public class CustomGameFrame extends JFrame {
    
    private JFrame frame;
    
    public CustomGameFrame(JFrame frame) throws HeadlessException {
        
            this.frame = frame;
            
            this.setSize(500, 220);
            this.setLayout(new BorderLayout(5,5));
            this.add(
                    new CustomGamePanel(this.frame),
                    BorderLayout.CENTER
            );
            this.setResizable(false);
    }
    
    
    
}
