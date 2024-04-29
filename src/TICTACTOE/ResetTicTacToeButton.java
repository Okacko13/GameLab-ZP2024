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
        resetButton.setFocusable(false);
        resetButton.setBackground(Color.DARK_GRAY);
        resetButton.setBorder(null);
        resetButton.setForeground(Color.WHITE);
        resetButton.addActionListener(this);


    }

    public void initializePanel(){
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(resetButton == e.getSource()){
            game.newGame();
        }
    }
}
