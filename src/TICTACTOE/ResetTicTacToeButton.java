package TICTACTOE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetTicTacToeButton extends JPanel implements ActionListener {

    private JButton resetButton;

    private TicTacToe game;

    public ResetTicTacToeButton() {

        buttonInitialize();
        initializePanel();
        setVisible(true);

    }

    public void buttonInitialize(){
        resetButton = new JButton("RESET");

        resetButton.setBounds(10,10,180,130);
        resetButton.setFont(new Font("Arial", Font.BOLD,40));
        resetButton.setFocusable(false);
        resetButton.setBackground(new Color(114, 0, 255, 255));
        resetButton.setBorder(null);
        resetButton.setForeground(Color.WHITE);
        resetButton.addActionListener(this);
        resetButton.setVisible(true);

        add(resetButton);

    }

    public void initializePanel(){
        this.setSize(200,150);
        setLocation(200,0);
        this.setBackground(new Color(72, 67, 66));
        this.setLayout(null);

    }

    public void setTicTacToe(TicTacToe ttt){
        this.game = ttt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(resetButton == e.getSource()){
            game.newGame();
        }
    }
}
