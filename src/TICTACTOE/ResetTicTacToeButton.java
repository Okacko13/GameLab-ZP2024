package TICTACTOE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that creates the ability to reset the Tic Tac Toe game
 */
public class ResetTicTacToeButton extends JPanel implements ActionListener {

    private JButton resetButton;

    private TicTacToe game;

    public ResetTicTacToeButton() {

        buttonInitialize();
        initializePanel();
        setVisible(true);

    }

    /**
     * Sets the reset button for the game
     */
    public void buttonInitialize(){
        resetButton = new JButton("RESET");

        resetButton.setBounds(10,10,180,130);
        resetButton.setFont(new Font("Arial", Font.BOLD,40));
        resetButton.setFocusable(false);
        resetButton.setBackground(new Color(34, 215, 113, 148));
        resetButton.setBorder(null);
        resetButton.setForeground(Color.WHITE);
        resetButton.addActionListener(this);
        resetButton.setVisible(true);

        add(resetButton);

    }

    /**
     * Initializes the panel where the restart button is located
     */
    public void initializePanel(){
        this.setSize(200,150);
        this.setLocation(200,0);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);

    }

    /**
     * Basic setter
     * @param ttt
     */
    public void setTicTacToe(TicTacToe ttt){
        this.game = ttt;
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(resetButton == e.getSource()){
            game.newGame();
        }
    }
}
