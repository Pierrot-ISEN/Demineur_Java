package demineur.view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import demineur.model.Grid;
import demineur.controller.MyMouseListener;
import demineur.controller.MyTimerActionListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class GraphicalGridView extends JPanel {

    private int width;
    private int height;
    private Grid model;
    private GraphicalCellView JCells[][];
    private Timer myTimer;
    private int timerValue;
    StatusBar statusBar;
    JFrame frame = new JFrame("Demineur");
    
    //GETTERS & SETTERS --------------------------------------------------------
    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Grid getModel() {
        return model;
    }

    public void setModel(Grid model) {
        this.model = model;
    }

    public GraphicalCellView getJCell(int i, int j) {
        return this.JCells[i][j];
    }

    public GraphicalCellView[][] getJCells() {
        return JCells;
    }

    public void setJCells(GraphicalCellView[][] JCells) {
        this.JCells = JCells;
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Timer getMyTimer() {
        return myTimer;
    }

    public void setMyTimer(Timer myTimer) {
        this.myTimer = myTimer;
    }

    public int getTimerValue() {
        return timerValue;
    }

    public void setTimerValue(int timerValue) {
        this.timerValue = timerValue;
    }
    
    //GETTERS & SETTERS --------------------------------------------------------

    public GraphicalGridView(Grid model) {
        this.model = model;
        this.width = model.getWidth();
        this.height = model.getHeight();
        this.JCells = new GraphicalCellView[this.width][this.height];
        
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        
        center.setLayout(new GridLayout(width, height));
        south.setLayout(new BorderLayout(5,5));
        
        JLabel timer = new JLabel("Time: 0");
        myTimer = new Timer(1000, new MyTimerActionListener(timer,this));
        myTimer.start();
        
        //Add a menu selector
        frame.setJMenuBar(new GameMenu(this));
        
        //Fill the frame's center with cell views
        frame.setLayout(new BorderLayout());
        frame.add(center,BorderLayout.CENTER);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.JCells[i][j] = new GraphicalCellView(model.getCell(i, j), this);
                center.add(this.JCells[i][j]);
            }
        }
        
        //add a Status Bar
        this.statusBar = new StatusBar(this.model);
        south.setBorder(new EmptyBorder(0,50,0,50));
        south.add(this.statusBar,BorderLayout.WEST);
        south.add(timer,BorderLayout.EAST);
        frame.add(south,BorderLayout.SOUTH);

        this.addMouseListener(new MyMouseListener(this));
        
        frame.setSize(this.width * 80, this.width * 55);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

}
