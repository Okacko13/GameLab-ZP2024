package FRAME_COMPONENTS;

import TICTACTOE.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        setUpPanel();
    }

    public void setUpPanel(){
        setBounds(0,150,750,600);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setVisible(false);
    }

    public void setVisibility(boolean bool){
        setVisible(bool);
    }

    public void startTicTacToe(TicTacToe ticTacToe){

        add(ticTacToe);

    }

}
