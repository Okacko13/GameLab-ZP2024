package MASTERMIND;

import FRAME_COMPONENTS.TextPanel;

import javax.swing.*;

public class Mastermind extends JPanel {

    private JComboBox[] enterColors;
    private TextPanel textPanel;

    public Mastermind() {
        setPanel();
        initializeComboBox();
        setVisible(true);
    }

    public void setPanel(){
        setSize(750,600);
        setLocation(0,0);
        setLayout(null);


    }

    public void initializeComboBox(){
        enterColors = new JComboBox[4];
        String[] colors = {"ENTER","YELLOW", "GREEN", "BLUE", "BLACK", "WHITE", "RED"};
        for(int i = 0; i < enterColors.length; i++){
            enterColors[i] = new JComboBox(colors);
            add(enterColors[i]);
        }

        enterColors[0].setBounds(85,350,100,40);
        enterColors[1].setBounds(245,350,100,40);
        enterColors[2].setBounds(405,350,100,40);
        enterColors[3].setBounds(565,350,100,40);

    }







}
