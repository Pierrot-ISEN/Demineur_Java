/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author root
 */
public class NewGamePanel extends JPanel implements ActionListener {

    private static final JRadioButton beginner = new JRadioButton("Beginner: 10 mines in a 9 x 9 field");
    private static final JRadioButton intermediate = new JRadioButton("Intermediate: 40 mines in a 16 x 16 field");
    private static final JRadioButton expert = new JRadioButton("Expert: 99 mines in a 16 x 30 field");
    private static final JRadioButton custom = new JRadioButton("Custom:");
    private NewGameFrame parentFrame;

    public JRadioButton getBeginner() {
        return beginner;
    }

    public JRadioButton getIntermediate() {
        return intermediate;
    }

    public JRadioButton getExpert() {
        return expert;
    }

    public JRadioButton getCustom() {
        return custom;
    }

    private ButtonGroup bg = new ButtonGroup();

    public NewGamePanel(NewGameFrame parentFrame) {

        this.parentFrame = parentFrame;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1));
        this.add(panel1, BorderLayout.NORTH);

        beginner.addActionListener(this);
        intermediate.addActionListener(this);
        expert.addActionListener(this);
        custom.addActionListener(this);

        bg.add(beginner);
        bg.add(intermediate);
        bg.add(expert);
        bg.add(custom);
        
        custom.setSelected(true);

        panel1.add(beginner);//, BorderLayout.EAST);
        panel1.add(intermediate);//, BorderLayout.EAST);
        panel1.add(expert);//, BorderLayout.SOUTH);
        panel1.add(custom);//,BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Beginner: 10 mines in a 9 x 9 field".equals(e.getActionCommand())) {
            System.out.println("Selected: " + e.getActionCommand());
            this.parentFrame.getCustomPanel().getTextC().setText("9");
            this.parentFrame.getCustomPanel().getTextC().setEditable(false);
            this.parentFrame.getCustomPanel().getTextR().setText("9");
            this.parentFrame.getCustomPanel().getTextR().setEditable(false);
            this.parentFrame.getCustomPanel().getTextM().setText("10");
            this.parentFrame.getCustomPanel().getTextM().setEditable(false);
            this.parentFrame.getCustomPanel().getSliderC().setValue(9);
            this.parentFrame.getCustomPanel().getSliderC().setEnabled(false);
            this.parentFrame.getCustomPanel().getSliderR().setValue(9);
            this.parentFrame.getCustomPanel().getSliderR().setEnabled(false);
            this.parentFrame.getCustomPanel().getSliderM().setValue(10);
            this.parentFrame.getCustomPanel().getSliderM().setEnabled(false);
            this.parentFrame.getNewCustomPanel().getBeginner().setSelected(true);
        } else if ("Intermediate: 40 mines in a 16 x 16 field".equals(e.getActionCommand())) {
            System.out.println("Selected: " + e.getActionCommand());
            this.parentFrame.getCustomPanel().getTextC().setText("16");
            this.parentFrame.getCustomPanel().getTextC().setEditable(false);
            this.parentFrame.getCustomPanel().getTextR().setText("16");
            this.parentFrame.getCustomPanel().getTextR().setEditable(false);
            this.parentFrame.getCustomPanel().getTextM().setText("40");
            this.parentFrame.getCustomPanel().getTextM().setEditable(false);
            this.parentFrame.getCustomPanel().getSliderC().setValue(16);
            this.parentFrame.getCustomPanel().getSliderC().setEnabled(false);
            this.parentFrame.getCustomPanel().getSliderR().setValue(16);
            this.parentFrame.getCustomPanel().getSliderR().setEnabled(false);
            this.parentFrame.getCustomPanel().getSliderM().setValue(40);
            this.parentFrame.getCustomPanel().getSliderM().setEnabled(false);
            this.parentFrame.getNewCustomPanel().getIntermediate().setSelected(true);
        } else if ("Expert: 99 mines in a 16 x 30 field".equals(e.getActionCommand())) {
            System.out.println("Selected: " + e.getActionCommand());
            this.parentFrame.getCustomPanel().getTextR().setText("16");
            this.parentFrame.getCustomPanel().getTextR().setEditable(false);
            this.parentFrame.getCustomPanel().getTextC().setText("30");
            this.parentFrame.getCustomPanel().getTextC().setEditable(false);
            this.parentFrame.getCustomPanel().getTextM().setText("99");
            this.parentFrame.getCustomPanel().getTextM().setEditable(false);
            this.parentFrame.getCustomPanel().getSliderR().setValue(16);
            this.parentFrame.getCustomPanel().getSliderR().setEnabled(false);
            this.parentFrame.getCustomPanel().getSliderC().setValue(30);
            this.parentFrame.getCustomPanel().getSliderC().setEnabled(false);
            this.parentFrame.getCustomPanel().getSliderM().setValue(99);
            this.parentFrame.getCustomPanel().getSliderM().setEnabled(false);
            this.parentFrame.getNewCustomPanel().getExpert().setSelected(true);
        } else if ("Custom:".equals(e.getActionCommand())) {
            System.out.println("Selected: " + e.getActionCommand());
            this.parentFrame.getCustomPanel().getTextR().setText("9");
            this.parentFrame.getCustomPanel().getTextR().setEditable(true);
            this.parentFrame.getCustomPanel().getTextC().setText("19");
            this.parentFrame.getCustomPanel().getTextC().setEditable(true);
            this.parentFrame.getCustomPanel().getTextM().setText("76");
            this.parentFrame.getCustomPanel().getTextM().setEditable(true);
            this.parentFrame.getCustomPanel().getSliderR().setValue(9);
            this.parentFrame.getCustomPanel().getSliderR().setEnabled(true);
            this.parentFrame.getCustomPanel().getSliderC().setValue(19);
            this.parentFrame.getCustomPanel().getSliderC().setEnabled(true);
            this.parentFrame.getCustomPanel().getSliderM().setValue(76);
            this.parentFrame.getCustomPanel().getSliderM().setEnabled(true);
        }
    }

}
