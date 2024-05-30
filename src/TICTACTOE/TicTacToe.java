package TICTACTOE;
import FRAME_COMPONENTS.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * the whole game of Tic Tac Toe takes place in it
 */
public class TicTacToe extends JPanel implements ActionListener {
    private Random random = new Random();
    private final char player1 = 'X';
    private final char player2 = 'O';
    private char onTurn;
    private JButton[][] buttons;
    private int turns;
    private TextPanel textPanel;

    public TicTacToe() {

        setBounds(-5,0,750,565);
        setLayout(new GridLayout(3,3));

        initializeButtons();

        setVisible(true);

    }

    /**
     * initializes the buttons required for the game
     */
    public void initializeButtons(){
        buttons = new JButton[3][3];

        for(int i = 0; i< buttons.length;i++){
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
                buttons[i][j].setVisible(true);
                buttons[i][j].setBackground(Color.DARK_GRAY);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFocusable(false);
                buttons[i][j].setFont(new Font("Arial",Font.BOLD,100));
                add(buttons[i][j]);
            }
        }
    }

    /**
     * generates which player will start the game
     */
    public void firstTurn(){
        int generated = random.nextInt(2);

        if(generated == 1){
            onTurn = player1;
            textPanel.setTextOnPanel(player1 + " has first turn");
        } else {
            onTurn = player2;
            textPanel.setTextOnPanel(player2 + " has first turn");
        }

    }

    /**
     * checks if there are any winning combinations in the playing field
     * @return text that will subsequently be applied to the panel text
     */
    public String check(){
        if(turns > 4){
            //hotizontal
            for (int i = 0; i < 3; i++) {
                if (buttons[i][0].getText().equals("")) continue;

                if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText())) {
                    win(i,0,i,1,i,2);
                    return buttons[i][0].getText() + " is winner";
                }
            }
            //vertical
            for (int i = 0; i < 3; i++) {
                if (buttons[0][i].getText().equals("")) continue;

                if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText())) {
                    win(0,i,1,i,2,i);
                    return buttons[0][i].getText() + " is winner";
                }
            }
            //diagonal
            if (    buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().equals("")) {
                win(0,0,1,1,2,2);
                return buttons[0][0].getText() + " is winner";
            }
            if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().equals("")) {
                win(0,2,1,1,2,0);
                return buttons[0][2].getText() + " is winner";
            }

            if (turns == 9) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        setTie(buttons[r][c]);
                    }
                }
                return "TIE";
            }
        }
        return null;
    }

    /**
     *takes the game to a state where one of the players has made a winning three of a kind
     * @param rowOne coordination Y of first winning button
     * @param colOne coordination X of first winning button
     * @param rowTwo coordination Y of second winning button
     * @param colTwo coordination X of second winning button
     * @param rowThree coordination Y of third winning button
     * @param colThree coordination X of third winning button
     */
    public void win(int rowOne,int colOne,int rowTwo,int colTwo,int rowThree,int colThree){

        buttons[rowOne][colOne].setBackground(Color.GREEN);
        buttons[rowTwo][colTwo].setBackground(Color.GREEN);
        buttons[rowThree][colThree].setBackground(Color.GREEN);

        for(int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setEnabled(false);
            }

        }
    }

    /**
     *registers the pressing of the button and places the symbols
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean turnDone = false;

        for(int i = 0; i < buttons.length; i++){
            turnDone = false;
            for (int j = 0; j < buttons.length; j++) {

                if(buttons[i][j] == e.getSource()){

                    if(buttons[i][j].getText().equals("")){

                        buttons[i][j].setText(String.valueOf(onTurn));
                        turns++;
                        String line = check();
                        textPanel.setTextOnPanel(line);
                        if(turns<9){
                            if(onTurn == player1){
                                buttons[i][j].setForeground(new Color(255, 181, 194, 255));
                                onTurn = player2;
                                if(line == null) textPanel.setTextOnPanel(player2 + "´s turn");
                                turnDone = true;
                                break;

                            } else {
                                buttons[i][j].setForeground(new Color(42, 245, 255, 255));
                                onTurn = player1;
                                if(line == null) textPanel.setTextOnPanel(player1 + "´s turn");
                                turnDone = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(turnDone){
                break;
            }
        }
    }

    /**
     *creates an environment for a new game
     */
    public void newGame(){

        for(int  i = 0; i < buttons.length ; i++){
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(Color.DARK_GRAY);
            }
        }
        firstTurn();
        turns = 0;
    }

    /**
     * method sets the button to the draw state
     * @param button the button is put into a mode in which it cannot be played
     */
    public void setTie(JButton button){
        button.setEnabled(false);
    }

    /**
     *basic textPanel setter
     * @param textPanel
     */
    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
        textPanel.setSizeOfText(40);
    }


}
