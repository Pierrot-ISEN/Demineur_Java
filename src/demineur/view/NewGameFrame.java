package demineur.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewGameFrame extends JFrame {
    private static CustomGamePanel customPanel;
    private static NewGamePanel  newCustomPanel;
    
    public CustomGamePanel getCustomPanel() {
        return customPanel;
    }

    public NewGamePanel getNewCustomPanel() {
        return newCustomPanel;
    }
    
    public NewGameFrame(JFrame frame) throws HeadlessException {
        
        JLabel select = new JLabel("Select a level:");
        this.customPanel= new CustomGamePanel(frame,this);
        this.newCustomPanel= new NewGamePanel(this);

        this.setSize(600,376);
        this.setLayout(new BorderLayout(5, 5));
        this.add(
                select,
                BorderLayout.NORTH
        );
        this.add(newCustomPanel,BorderLayout.WEST);
        this.add(customPanel,BorderLayout.SOUTH);
    }

}
