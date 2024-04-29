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
        //hotizontal
        for (int r = 0; r < 3; r++) {
            if (buttons[r][0].getText().equals("")) continue;

            if (buttons[r][0].getText().equals(buttons[r][1].getText()) && buttons[r][1].getText().equals(buttons[r][2].getText())) {
                win(r,0,r,1,r,2);
                return buttons[r][0].getText() + " wins";
            }
        }
        //vertical
        for (int c = 0; c < 3; c++) {
            if (buttons[0][c].getText().equals("")) continue;

            if (buttons[0][c].getText().equals(buttons[1][c].getText()) && buttons[1][c].getText().equals(buttons[2][c].getText())) {
                win(0,c,1,c,2,c);
                return buttons[0][c].getText() + " wins";
            }
        }
        //diagonal
        if (    buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().equals("")) {
            win(0,0,1,1,2,2);
            return buttons[0][0].getText() + " wins";
        }
        //diagonal
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().equals("")) {
            win(0,2,1,1,2,0);
            return buttons[0][2].getText() + " wins";
        }

        if (turns == 9) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    setTie(buttons[r][c]);
                }
            }

        }
        return null;
    }

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


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons.length; j++) {

                if(buttons[i][j] == e.getSource()){

                    if(buttons[i][j].getText().equals("")){

                        buttons[i][j].setText(String.valueOf(onTurn));
                        turns++;

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
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(Color.GRAY);
            }

        }
        turns = 0;

    }

    public void setTie(JButton button){
        button.setForeground(Color.WHITE);
        button.setBackground(Color.gray);
        button.setEnabled(false);
    }


}
