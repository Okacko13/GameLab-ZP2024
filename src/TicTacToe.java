import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TicTacToe extends JPanel implements ActionListener {

    private Random random = new Random();
    private final char player1 = 'X';
    private final char player2 = 'O';
    private char onTurn;

    private JButton[] buttons;

    public TicTacToe() {

        buttons = new JButton[9];

    }


    public void firstTurn(){

        switch (random.nextInt(2)){
            case 0:
                onTurn = player1;
            case 1:
                onTurn = player2;
        }

    }

    public String check(){

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

            String line = String.valueOf(array);

            if (line.equals("XXX")) {

                win(indexes[0],indexes[1],indexes[2]);
                return "X wins";

            } else if (line.equals("OOO")) {

                win(indexes[0],indexes[1],indexes[2]);
                return "Y wins";

            }
        }

        return null;
    }

    public void win(int numOne,int numTwo,int numThree){

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < buttons.length; i++){

            if(buttons[i]== e.getSource()){

                if(buttons[i].getText().equals("")){

                    buttons[i].setText(String.valueOf(onTurn));

                    if(onTurn == player1){
                        buttons[i].setForeground(Color.BLUE);
                        onTurn = player2;
                        check();
                    } else {
                        buttons[i].setForeground(Color.RED);
                        onTurn = player1;
                        check();
                    }

                }

            }

        }

    }

    public void xOnTurn(){

    }

    public void yOnTurn(){

    }

}
