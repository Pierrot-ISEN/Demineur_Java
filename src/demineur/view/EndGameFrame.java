package demineur.view;

import demineur.controller.MyEndGameListener;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EndGameFrame extends JFrame {
    
    public EndGameFrame(String message,int Score) throws HeadlessException {
            JPanel mainPanel = new JPanel();
            JPanel topPanel = new JPanel();
            JButton replay = new JButton("Replay");
            JButton quit = new JButton("Quit");
            
            
            mainPanel.setBorder(new EmptyBorder(10,20,10,10));
            this.add(mainPanel);
            mainPanel.add(topPanel);
            
            JLabel label = new JLabel(message);
            JLabel score = new JLabel("Score :" + Integer.toString(Score));
            JLabel voidLabel = new JLabel("                       ");
            
            topPanel.add(label,BorderLayout.WEST);
            topPanel.add(voidLabel,BorderLayout.CENTER);
            topPanel.add(score,BorderLayout.EAST);
                    
            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(topPanel,BorderLayout.NORTH);
            mainPanel.add(replay,BorderLayout.CENTER);
            mainPanel.add(quit,BorderLayout.SOUTH);
            replay.addMouseListener(new MyEndGameListener(this));
            quit.addMouseListener(new MyEndGameListener(this));
            
            this.setSize(500,150);
            this.setBounds(500,300,300,150);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
    }
   
}
