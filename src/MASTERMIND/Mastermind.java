package MASTERMIND;

import FRAME_COMPONENTS.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mastermind extends JPanel implements ActionListener {

    private GamePhase gamePhase = GamePhase.SETTINGUP;
    private int numberOfQueses = 0;

    private Row settedPins;

    private Row[] quessedPins;

    private CheckButton checkButton;
    private JComboBox[] enterColors;

    private JPanel textP;
    private JLabel textLabel;

    private TextPanel textPanel;

    public Mastermind() {

        setMainPanel();
        initializeComboBox();
        initializeCheckButton();
        textPanelSetUp();
        setVisible(true);

    }

    public void setMainPanel(){
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
        checkButton = new CheckButton();
        checkButton.setTextButton("DONE");
        checkButton.setActionListener(this);
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

    public void setSettedPins(){
        if(gamePhase == GamePhase.SETTINGUP) {
            for (int i = 0; i < 4; i++) {
                if (enterColors[i].getSelectedItem().equals("")) {
                    settedPins.setPinByIndex(i, null);
                }else if (enterColors[i].getSelectedItem().equals("RED")) {
                    settedPins.setPinByIndex(i, Color.RED);
                } else if (enterColors[i].getSelectedItem().equals("YELLOW")) {
                    settedPins.setPinByIndex(i, Color.YELLOW);
                } else if (enterColors[i].getSelectedItem().equals("GREEN")) {
                    settedPins.setPinByIndex(i, Color.GREEN);
                } else if (enterColors[i].getSelectedItem().equals("BLACK")) {
                    settedPins.setPinByIndex(i, Color.BLACK);
                } else if (enterColors[i].getSelectedItem().equals("BLUE")) {
                    settedPins.setPinByIndex(i, Color.BLUE);
                } else if (enterColors[i].getSelectedItem().equals("WHITE")) {
                    settedPins.setPinByIndex(i, Color.WHITE);
                }
            }

            if (settedPins.numberOfColoredPins(settedPins) == 4) {
                if (!settedPins.checkSameColorInRow(settedPins)) {
                    gamePhase = GamePhase.QUESSING;
                    setQuessingPhase();
                }
            }
        }
    }
    public void setQuessingPhase(){
        enterColors[0].setBounds(80,10,100,40);
        enterColors[1].setBounds(240,10,100,40);
        enterColors[2].setBounds(400,10,100,40);
        enterColors[3].setBounds(560,10,100,40);

        setEnteredColorsSetSelectedIndex(0);
        textLabel.setText("↑ enter your ques ↑");
        checkButton.setTextButton("QUES");

        checkButton.setLocation(275,510);

        quessedPins = new Row[10];

    }
    public void setEnteredColorsSetSelectedIndex(int index){
        for(int i = 0; i < enterColors.length; i++){
            enterColors[i].setSelectedIndex(index);
        }
    }
    public void ques(){
        quessedPins[numberOfQueses] = new Row();
        quessedPins[numberOfQueses].initializePinDisplays();

        for (int i = 0; i < 4; i++) {
            if (enterColors[i].getSelectedItem().equals("")) {
                quessedPins[numberOfQueses].setPinByIndex(i, null);

            }else if (enterColors[i].getSelectedItem().equals("RED")) {
                quessedPins[numberOfQueses].setPinByIndex(i, Color.RED);
                quessedPins[numberOfQueses].setPinDisplaysColor(i,Color.RED);

            } else if (enterColors[i].getSelectedItem().equals("YELLOW")) {
                quessedPins[numberOfQueses].setPinByIndex(i, Color.YELLOW);
                quessedPins[numberOfQueses].setPinDisplaysColor(i,Color.YELLOW);

            } else if (enterColors[i].getSelectedItem().equals("GREEN")) {
                quessedPins[numberOfQueses].setPinByIndex(i, Color.GREEN);
                quessedPins[numberOfQueses].setPinDisplaysColor(i,Color.GREEN);

            } else if (enterColors[i].getSelectedItem().equals("BLACK")) {
                quessedPins[numberOfQueses].setPinByIndex(i, Color.BLACK);
                quessedPins[numberOfQueses].setPinDisplaysColor(i,Color.BLACK);

            } else if (enterColors[i].getSelectedItem().equals("BLUE")) {
                quessedPins[numberOfQueses].setPinByIndex(i, Color.BLUE);
                quessedPins[numberOfQueses].setPinDisplaysColor(i,Color.BLUE);

            } else if (enterColors[i].getSelectedItem().equals("WHITE")) {
                quessedPins[numberOfQueses].setPinByIndex(i, Color.WHITE);
                quessedPins[numberOfQueses].setPinDisplaysColor(i,Color.WHITE);

            }
        }
        quessedPins[numberOfQueses].setLocationPinDisplays(numberOfQueses);
        quessedPins[numberOfQueses].setVisibleRow(true);

        quessedPins[numberOfQueses].createVisibleRow(numberOfQueses);

        add(quessedPins[numberOfQueses].getRowPanel());

        setEnteredColorsSetSelectedIndex(0);
        numberOfQueses++;
        textP.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == checkButton){
            if(gamePhase == GamePhase.SETTINGUP){
                settedPins = new Row();
                setSettedPins();
            } else if(gamePhase == GamePhase.QUESSING){
                ques();
            }

        }
    }

}
