package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private Player player;
    private GameField gameField;
    private HiddenMoveButton moveButton;
    private int coordinationX;
    private int coordinationY;

    public Field(GameField gameField,int coordinationX, int coordinationY) {
        this.gameField = gameField;
        this.coordinationX = coordinationX;
        this.coordinationY = coordinationY;
        initialize(coordinationX,coordinationY);
    }

    public void initialize(int i,int j){
        setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        setBackground(Color.DARK_GRAY);
        setForeground(Color.DARK_GRAY);
        setBounds(calculateLocation(i,true),calculateLocation(j,false),66,66);
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

    public static int calculateLocation(int number,boolean coordinationX){
        double coordination;
        if(coordinationX){
            coordination = 66.66666 * number;
        }else{
            coordination = 62.44444 * number;
        }


        int result = (int) Math.round(coordination);

        return result;

    }

}
