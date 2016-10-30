/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import demineur.controller.MyValidationListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Creates the Custom menu in a CustomGameFrame
public class CustomGamePanel extends JPanel implements ChangeListener, ActionListener {

    private MyTextField textR, textC, textM;
    private MySlider sliderR, sliderC, sliderM;
    private static NewGameFrame parentFrame;
    private static JButton validate = new JButton("Validate");
    private static CustomGameFrame customFrame;
    //private Parameters parameters;

    //GETTERS & SETTERS --------------------------------------------------------
    public MyTextField getTextR() {
        return textR;
    }

    public MyTextField getTextC() {
        return textC;
    }

    public MyTextField getTextM() {
        return textM;
    }

    public MySlider getSliderR() {
        return sliderR;
    }

    public MySlider getSliderC() {
        return sliderC;
    }

    public MySlider getSliderM() {
        return sliderM;
    }
    
    //--------------------------------------------------------------------------
    
    
    
    //CONTRUCTORS---------------------------------------------------------------
    public CustomGamePanel(JFrame gameFrame,NewGameFrame parentFrame) {
        this.parentFrame = parentFrame;
        
        JPanel left = new JPanel();
        JPanel center = new JPanel();
        JPanel right = new JPanel();
        JPanel rightCenter = new JPanel();
        JPanel up = new JPanel();
        JPanel down = new JPanel();

        this.validate = new JButton("Validate");
        this.validate.addMouseListener(new MyValidationListener(gameFrame,this.parentFrame,this));

        JLabel row = new JLabel("Rows:");
        JLabel columns = new JLabel("Columns:");
        JLabel mines = new JLabel("Mines:");

        this.textR = new MyTextField(9);
        this.textC = new MyTextField(19);
        this.textM = new MyTextField(76);

        this.sliderR = new MySlider(24, 9, 2, 1, 9);
        this.sliderC = new MySlider(30, 9, 4, 2, 19);
        this.sliderM = new MySlider(139, 9, 26, 13, 76);

        this.setLayout(new BorderLayout(5, 5));
        up.setLayout(new BorderLayout(5, 5));
        down.setLayout(new BorderLayout(5, 5));
        down.add(validate, BorderLayout.CENTER);
        this.add(up, BorderLayout.NORTH);
        this.add(down, BorderLayout.SOUTH);

        left.setLayout(new BorderLayout(5, 5));

        left.add(row, BorderLayout.NORTH);
        left.add(columns, BorderLayout.CENTER);
        left.add(mines, BorderLayout.SOUTH);
        up.add(left, BorderLayout.WEST);

        left.setBorder(new EmptyBorder(10, 10, 10, 0));

        right.setLayout(new BorderLayout());
        rightCenter.setLayout(new BorderLayout());
        up.add(right, BorderLayout.EAST);
        right.add(rightCenter, BorderLayout.CENTER);
        right.add(textR, BorderLayout.NORTH);
        rightCenter.add(textC, BorderLayout.CENTER);
        right.add(textM, BorderLayout.SOUTH);
        right.setBorder(new EmptyBorder(10, 0, 10, 10));
        rightCenter.setBorder(new EmptyBorder(60, 0, 60, 0));

        center.setLayout(new BorderLayout(5, 5));
        up.add(center, BorderLayout.CENTER);
        center.add(sliderR, BorderLayout.NORTH);
        center.add(sliderC, BorderLayout.CENTER);
        center.add(sliderM, BorderLayout.SOUTH);
        center.setBorder(new EmptyBorder(10, 25, 10, 25));

        sliderR.addChangeListener(this);
        sliderC.addChangeListener(this);
        sliderM.addChangeListener(this);

        textR.addActionListener(this);
        textC.addActionListener(this);
        textM.addActionListener(this);
    }

    public CustomGamePanel(JFrame gameFrame,CustomGameFrame customFrame) {
        this.customFrame = customFrame;
        JPanel left = new JPanel();
        JPanel center = new JPanel();
        JPanel right = new JPanel();
        JPanel rightCenter = new JPanel();
        JPanel up = new JPanel();
        JPanel down = new JPanel();

        this.validate = new JButton("Validate");
        this.validate.addMouseListener(new MyValidationListener(gameFrame,this.customFrame,this));

        JLabel row = new JLabel("Rows:");
        JLabel columns = new JLabel("Columns:");
        JLabel mines = new JLabel("Mines:");

        this.textR = new MyTextField(9);
        this.textC = new MyTextField(19);
        this.textM = new MyTextField(76);

        this.sliderR = new MySlider(24, 9, 2, 1, 9);
        this.sliderC = new MySlider(30, 9, 4, 2, 19);
        this.sliderM = new MySlider(139, 9, 26, 13, 76);

        this.setLayout(new BorderLayout(5, 5));
        up.setLayout(new BorderLayout(5, 5));
        down.setLayout(new BorderLayout(5, 5));
        down.add(validate, BorderLayout.CENTER);
        this.add(up, BorderLayout.NORTH);
        this.add(down, BorderLayout.SOUTH);

        left.setLayout(new BorderLayout(5, 5));

        left.add(row, BorderLayout.NORTH);
        left.add(columns, BorderLayout.CENTER);
        left.add(mines, BorderLayout.SOUTH);
        up.add(left, BorderLayout.WEST);

        left.setBorder(new EmptyBorder(10, 10, 10, 0));

        right.setLayout(new BorderLayout());
        rightCenter.setLayout(new BorderLayout());
        up.add(right, BorderLayout.EAST);
        right.add(rightCenter, BorderLayout.CENTER);
        right.add(textR, BorderLayout.NORTH);
        rightCenter.add(textC, BorderLayout.CENTER);
        right.add(textM, BorderLayout.SOUTH);
        right.setBorder(new EmptyBorder(10, 0, 10, 10));
        rightCenter.setBorder(new EmptyBorder(60, 0, 60, 0));

        center.setLayout(new BorderLayout(5, 5));
        up.add(center, BorderLayout.CENTER);
        center.add(sliderR, BorderLayout.NORTH);
        center.add(sliderC, BorderLayout.CENTER);
        center.add(sliderM, BorderLayout.SOUTH);
        center.setBorder(new EmptyBorder(10, 25, 10, 25));

        sliderR.addChangeListener(this);
        sliderC.addChangeListener(this);
        sliderM.addChangeListener(this);

        textR.addActionListener(this);
        textC.addActionListener(this);
        textM.addActionListener(this);

    }
    //--------------------------------------------------------------------------
    
    //On Sliders change...
    @Override
    public void stateChanged(ChangeEvent e) {
        //JSlider slider = (JSlider) e.getSource();
        //this.textFiled.setText(Integer.toString(slider.getValue()));
        this.textR.setText(Integer.toString(this.sliderR.getValue()));
        this.textC.setText(Integer.toString(this.sliderC.getValue()));
        this.textM.setText(Integer.toString(this.sliderM.getValue()));
        this.sliderM.setMaximum((int) (0.85 * this.sliderC.getValue() * this.sliderR.getValue()));
        if (this.sliderM.getMaximum() > 240) {
            this.sliderM.setMajorTickSpacing(200);
            this.sliderM.setMinorTickSpacing(100);
        } else {
            this.sliderM.setMajorTickSpacing(26);
            this.sliderM.setMinorTickSpacing(13);
        }
        this.parentFrame.getNewCustomPanel().getCustom().setSelected(true);
    }

    //On JText change...
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.parentFrame == null) {
            try {
                this.sliderR.setValue(Integer.parseInt(this.textR.getText()));
                this.sliderC.setValue(Integer.parseInt(this.textC.getText()));
                this.sliderM.setValue(Integer.parseInt(this.textM.getText()));
            } catch (Exception ex) {
                //System.out.println("Must enter a number");
                this.textR.setText(Integer.toString(this.sliderR.getValue()));
                this.textC.setText(Integer.toString(this.sliderC.getValue()));
                this.textM.setText(Integer.toString(this.sliderM.getValue()));
            }
        } else {
            try {
                this.sliderR.setValue(Integer.parseInt(this.textR.getText()));
                this.sliderC.setValue(Integer.parseInt(this.textC.getText()));
                this.sliderM.setValue(Integer.parseInt(this.textM.getText()));
                this.parentFrame.getNewCustomPanel().getCustom().setSelected(true);
            } catch (Exception ex) {
                //System.out.println("Must enter a number");
                this.textR.setText(Integer.toString(this.sliderR.getValue()));
                this.textC.setText(Integer.toString(this.sliderC.getValue()));
                this.textM.setText(Integer.toString(this.sliderM.getValue()));
            }
        }
    }
}
