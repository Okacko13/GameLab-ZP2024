package TICTACTOE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JPanel implements ActionListener {

    private Random random = new Random();
    private final char player1 = 'X';
    private final char player2 = 'O';
    private char onTurn = player2;
    private JButton[][] buttons;
    private int turns;

    public TicTacToe() {

        setBounds(0,0,750,750);
        setLayout(new GridLayout(3,3));

        initializeButtons();
        firstTurn();

        setVisible(true);

    }

    public void initializeButtons(){

        buttons = new JButton[3][3];

        for(int i = 0; i< buttons.length;i++){
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
                buttons[i][j].setVisible(true);
                buttons[i][j].setBackground(Color.GRAY);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setFocusable(false);
                buttons[i][j].setFont(new Font("Arial",Font.BOLD,100));
                add(buttons[i][j]);
            }

        }

    }



    public void firstTurn(){
        int generated = random.nextInt(2);

        if(generated== 1){
            onTurn = player1;
        }

    }

    public String check(){
        /*
        for (int a = 0; a < 8; a++) {
            String[] array = new String[3];
            int[] indexes = new int[3];

            switch (a) {
                case 0:
                    array[0]= buttons[0].getText();
                    array[1]= buttons[1].getText();
                    array[2]= buttons[2].getText();
                    indexes = new int[]{0,1,2};
                    break;
                case 1:
                    array[0]= buttons[3].getText();
                    array[1]= buttons[4].getText();
                    array[2]= buttons[5].getText();
                    indexes = new int[]{3,4,5};
                    break;
                case 2:
                    array[0]= buttons[6].getText();
                    array[1]= buttons[7].getText();
                    array[2]= buttons[8].getText();
                    indexes = new int[]{6,7,8};
                    break;
                case 3:
                    array[0]= buttons[0].getText();
                    array[1]= buttons[3].getText();
                    array[2]= buttons[6].getText();
                    indexes = new int[]{0,3,6};
                    break;
                case 4:
                    array[0]= buttons[1].getText();
                    array[1]= buttons[4].getText();
                    array[2]= buttons[7].getText();
                    indexes = new int[]{1,4,7};
                    break;
                case 5:
                    array[0]= buttons[2].getText();
                    array[1]= buttons[5].getText();
                    array[2]= buttons[8].getText();
                    indexes = new int[]{2,5,8};
                    break;
                case 6:
                    array[0]= buttons[0].getText();
                    array[1]= buttons[4].getText();
                    array[2]= buttons[8].getText();
                    indexes = new int[]{0,4,8};
                    break;
                case 7:
                    array[0]= buttons[2].getText();
                    array[1]= buttons[4].getText();
                    array[2]= buttons[6].getText();
                    indexes = new int[]{2,4,6};
                    break;
                default:

            }

            if (array[0].equals("X") && array[1].equals("X") && array[2].equals("X")) {

                win(indexes[0],indexes[1],indexes[2]);
                return "X wins";

            } else if (array[0].equals("O") && array[1].equals("O") && array[2].equals("O")) {

                win(indexes[0],indexes[1],indexes[2]);
                return "Y wins";

            }
        }

        return null;
         */
        for (int r = 0; r < 3; r++) {
            if (buttons[r][0].getText().equals("")) continue;

            if (buttons[r][0].getText().equals(buttons[r][1].getText()) && buttons[r][1].getText().equals(buttons[r][2].getText())) {

            }
        }

        for (int c = 0; c < 3; c++) {
            if (buttons[0][c].getText().equals("")) continue;

            if (buttons[0][c].getText().equals(buttons[1][c].getText()) && buttons[1][c].getText().equals(buttons[2][c].getText())) {

            }
        }

        if (    buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().equals("")) {

        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().equals("")) {

        }

        if (turns == 9) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    setTie(buttons[r][c]);
                }
            }

        }

    }

    public void win(int numOne,int numTwo,int numThree){
        buttons[numOne].setBackground(Color.GREEN);
        buttons[numTwo].setBackground(Color.GREEN);
        buttons[numThree].setBackground(Color.GREEN);

        for(int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setEnabled(false);
            }

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons.length; j++) {

                if(buttons[i][j] == e.getSource()){

                    if(buttons[i][j].getText().equals("")){

                        buttons[i][j].setText(String.valueOf(onTurn));

                        if(onTurn == player1){

                            buttons[i][j].setForeground(Color.BLUE);
                            onTurn = player2;
                            check();
                            break;

                        } else {

                            buttons[i][j].setForeground(Color.RED);
                            onTurn = player1;
                            check();
                            break;
                        }
                    }
                }
            }
        }
    }

    public void newGame(){

        for(int  i = 0; i < buttons.length ; i++){
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setFocusable(true);
                buttons[i][j].setBackground(Color.GRAY);
            }

        }

    }


}
