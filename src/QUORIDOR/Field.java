package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JPanel implements ActionListener {

    private Player player;
    private GameField gameField;

    public Field(GameField gameField) {
        this.gameField = gameField;
        initialize();
    }

    public void initialize(){
        setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        setBackground(Color.DARK_GRAY);
        setLayout(null);
    }
    public void setVisibility(boolean bool){
        setVisible(bool);
    }

    public void addPlayer(Player player){
        this.player = player;
    }

    public void removePlayer(){
        this.player = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
