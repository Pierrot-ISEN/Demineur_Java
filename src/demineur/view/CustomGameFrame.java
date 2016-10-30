package demineur.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

//Creates A custom game frame. It can be loaded in an other frame (like new game)
public class CustomGameFrame extends JFrame {
    
    private JFrame gameFrame;
    
    public CustomGameFrame(JFrame frame) throws HeadlessException {
            
            this.gameFrame = frame;
            
            this.setSize(500, 220);
            this.setLayout(new BorderLayout(5,5));
            this.add(
                    new CustomGamePanel(this.gameFrame,this),
                    BorderLayout.CENTER
            );
            this.setResizable(false);
    }
    
    
    
}
