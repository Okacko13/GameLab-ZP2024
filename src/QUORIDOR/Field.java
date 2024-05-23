package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private Player player;
    private GameField gameField;
    private HiddenMoveButton moveButton;

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
        add(player);
    }
    public void addMoveButton(HiddenMoveButton moveButton){
        this.moveButton = moveButton;
        add(moveButton);
    }

    public void removePlayer(){
        this.player = null;
    }

    public Player getPlayer() {
        return player;
    }
}
