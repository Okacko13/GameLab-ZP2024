package MASTERMIND;

import FRAME_COMPONENTS.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mastermind extends JPanel implements ActionListener {

    private GamePhase gamePhase = GamePhase.SETTINGUP;

    private Row settedPins;

    private Row[] quessedPins;

    private JButton checkButton;
    private JComboBox[] enterColors;

    private JPanel textP;
    private JLabel textLabel;

    private TextPanel textPanel;

    public Mastermind() {

        setPanel();
        initializeComboBox();
        initializeCheckButton();
        textPanelSetUp();
        setVisible(true);

    }

    public void setPanel(){
        setSize(750,600);
        setLocation(0,0);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
    }

    public void initializeComboBox(){
        enterColors = new JComboBox[4];
        String[] colors = {"","YELLOW", "GREEN", "BLUE", "BLACK", "WHITE", "RED"};
        for(int i = 0; i < enterColors.length; i++){
            enterColors[i] = new JComboBox(colors);
            enterColors[i].addActionListener(this);
            enterColors[i].setFont(new Font("Times new roman", Font.BOLD,17));
            enterColors[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            enterColors[i].setBackground(Color.LIGHT_GRAY);
            add(enterColors[i]);
        }

        enterColors[0].setBounds(80,275,100,40);
        enterColors[1].setBounds(240,275,100,40);
        enterColors[2].setBounds(400,275,100,40);
        enterColors[3].setBounds(560,275,100,40);

    }

    public void initializeCheckButton(){

        checkButton = new JButton("DONE");
        checkButton.setFont(new Font("Times new roman", Font.PLAIN, 20));
        checkButton.setFocusable(false);
        checkButton.setBounds(275,400,200,50);
        checkButton.setBackground(Color.LIGHT_GRAY);
        checkButton.setForeground(Color.BLACK);
        checkButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        checkButton.setVisible(true);
        add(checkButton);

    }

    public void textPanelSetUp(){
        textP = new JPanel();
        textP.setSize(750,200);
        textP.setLocation(0,25);
        textP.setLayout(new BorderLayout());
        textP.setBackground(Color.DARK_GRAY);

        textLabel = new JLabel();
        textLabel.setText("Enter guessed colors");
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(new Font("Times new roman",Font.PLAIN,80));
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFocusable(false);
        textLabel.setOpaque(true);

        textP.add(textLabel);
        textP.setVisible(true);
        add(textP);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
