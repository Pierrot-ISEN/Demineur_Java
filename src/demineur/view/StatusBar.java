package demineur.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel implements Observer {

    private String Text = "Mines remaining: ";
    private JLabel label = new JLabel("Status");

    public StatusBar() {
        this.add(this.label);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
