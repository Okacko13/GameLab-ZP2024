package MASTERMIND;

import FRAME_COMPONENTS.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mastermind extends JPanel implements ActionListener {

    private GamePhase gamePhase = GamePhase.SETTINGUP;
    private int numberOfGueses = 0;
    private Row settedPins;
    private Row[] guessedPins;
    private CheckButton checkButton;
    private JComboBox[] enterColors;
    private boolean win = false;
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

        }
        newGameCheckBox();
    }
    public void newGameCheckBox(){

        for(int i = 0; i < enterColors.length; i++){
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
        textP.setSize(750,100);
        textP.setLocation(0,100);
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
        textLabel.setText("↑ enter your guess ↑");
        checkButton.setTextButton("GUES");
        checkButton.setLocation(275,510);

        guessedPins = new Row[10];

        textPanel.setTextOnPanel("Second player guesses");

    }
    public void setEnteredColorsSetSelectedIndex(int index){
        for(int i = 0; i < enterColors.length; i++){
            enterColors[i].setSelectedIndex(index);
        }
    }
    public void ques(){
        if(numberOfGueses < 10){
            guessedPins[numberOfGueses] = new Row();
            guessedPins[numberOfGueses].initializePinDisplays();

            for (int i = 0; i < 4; i++) {
                if (enterColors[i].getSelectedItem().equals("")) {
                    guessedPins[numberOfGueses].setPinByIndex(i, null);

                }else if (enterColors[i].getSelectedItem().equals("RED")) {
                    guessedPins[numberOfGueses].setPinByIndex(i, Color.RED);
                    guessedPins[numberOfGueses].setPinDisplaysColor(i,Color.RED);

                } else if (enterColors[i].getSelectedItem().equals("YELLOW")) {
                    guessedPins[numberOfGueses].setPinByIndex(i, Color.YELLOW);
                    guessedPins[numberOfGueses].setPinDisplaysColor(i,Color.YELLOW);

                } else if (enterColors[i].getSelectedItem().equals("GREEN")) {
                    guessedPins[numberOfGueses].setPinByIndex(i, Color.GREEN);
                    guessedPins[numberOfGueses].setPinDisplaysColor(i,Color.GREEN);

                } else if (enterColors[i].getSelectedItem().equals("BLACK")) {
                    guessedPins[numberOfGueses].setPinByIndex(i, Color.BLACK);
                    guessedPins[numberOfGueses].setPinDisplaysColor(i,Color.BLACK);

                } else if (enterColors[i].getSelectedItem().equals("BLUE")) {
                    guessedPins[numberOfGueses].setPinByIndex(i, Color.BLUE);
                    guessedPins[numberOfGueses].setPinDisplaysColor(i,Color.BLUE);

                } else if (enterColors[i].getSelectedItem().equals("WHITE")) {
                    guessedPins[numberOfGueses].setPinByIndex(i, Color.WHITE);
                    guessedPins[numberOfGueses].setPinDisplaysColor(i,Color.WHITE);

                }
            }

            guessedPins[numberOfGueses].setLocationPinDisplays(numberOfGueses);
            guessedPins[numberOfGueses].setVisiblePinDisplay(true);
            guessedPins[numberOfGueses].createVisibleRow(numberOfGueses);

            add(guessedPins[numberOfGueses].getRowPanel());

            setEnteredColorsSetSelectedIndex(0);
            numberOfGueses++;

            if(numberOfGueses == 1){
                textP.setVisible(false);
            }

            setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!win){
            if(e.getSource() == checkButton){
                if(gamePhase == GamePhase.SETTINGUP){
                    settedPins = new Row();
                    setSettedPins();
                } else if(gamePhase == GamePhase.QUESSING){
                    ques();
                    guessedPins[numberOfGueses-1].check(settedPins);
                    if(guessedPins[numberOfGueses-1].hasRowSimilarPins(settedPins)){
                        win = true;
                        textPanel.setTextOnPanel("Guess is correct");
                    }
                    setVisible(true);
                }
            }
        }
    }

    public void setTextPanel(TextPanel textPanel){
        this.textPanel = textPanel;
        textPanel.setSizeOfText(23);
        textPanel.setTextOnPanel("Player 1 sets up the puzzle");
    }

}
