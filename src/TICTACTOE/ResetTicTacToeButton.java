package TICTACTOE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetTicTacToeButton extends JPanel implements ActionListener {

    private JButton resetButton;

    private TicTacToe game;

    public ResetTicTacToeButton(TicTacToe game) {
        this.game = game;
        buttonInitialize();
        initializePanel();
        add(resetButton);
        setVisible(true);
    }

    public void buttonInitialize(){
        resetButton = new JButton("RESET GAME");
        resetButton.setFont(new Font("Arial", Font.BOLD,35));
        resetButton.setBounds(10,10,185,85);
        resetButton.setBackground(Color.DARK_GRAY);
        resetButton.setForeground(Color.WHITE);


    }

    public void initializePanel(){
        this.setBackground(Color.BLACK);
        this.setBounds(0,0,200,100);
        this.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(resetButton == e.getSource()){
            game.newGame();
        }
    }
}
