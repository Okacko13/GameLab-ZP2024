import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JPanel implements ActionListener {

    private Random random;
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


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
