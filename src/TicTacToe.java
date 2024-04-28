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
    private char onTurn = player2;

    private JButton[] buttons;

    public TicTacToe() {

        setBounds(0,0,750,750);
        setLayout(new GridLayout(3,3));

        initializeButtons();
        firstTurn();

        setVisible(true);

    }

    public void initializeButtons(){

        buttons = new JButton[9];

        for(int i = 0; i< buttons.length;i++){

            buttons[i] = new JButton();
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            buttons[i].setVisible(true);
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("Arial",Font.BOLD,100));
            add(buttons[i]);
        }

    }



    public void firstTurn(){
        int generated = random.nextInt(2);

        if(generated== 1){
            onTurn = player1;
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

            if (array[0].equals("X") && array[1].equals("X") && array[2].equals("X")) {

                win(indexes[0],indexes[1],indexes[2]);
                return "X wins";

            } else if (array[0].equals("O") && array[1].equals("O") && array[2].equals("O")) {

                win(indexes[0],indexes[1],indexes[2]);
                return "Y wins";

            }
        }

        return null;
    }

    public void win(int numOne,int numTwo,int numThree){
        buttons[numOne].setBackground(Color.GREEN);
        buttons[numTwo].setBackground(Color.GREEN);
        buttons[numThree].setBackground(Color.GREEN);

        for(int i = 0; i < buttons.length; i++){
            buttons[i].setEnabled(false);
        }
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
                        break;
                    } else {
                        buttons[i].setForeground(Color.RED);
                        onTurn = player1;
                        check();
                        break;
                    }

                }

            }

        }

    }

    public void newGame(){

        for(int  i = 0; i < buttons.length ; i++){

            buttons[i].setText("");
            buttons[i].setFocusable(true);
            buttons[i].setBackground(Color.GRAY);
        }

    }


}
