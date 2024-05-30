package QUORIDOR;

import javax.swing.*;
import java.awt.*;

/**
 * The class that subsequently forms the playing field
 */
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

    /**
     * initializes the panel for graphical output of field
     * @param i Sets the distance on the x-axis
     * @param j Sets the distance on the y-axis
     */
    public void initialize(int i,int j){
        setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        setBackground(Color.DARK_GRAY);
        setForeground(Color.DARK_GRAY);
        setBounds(calculateLocation(i,true),calculateLocation(j,false),66,66);
        setLayout(null);
    }

    /**
     * basic setter
     * @param bool
     */
    public void setVisibility(boolean bool){
        setVisible(bool);
    }

    /**
     * Adds a player to the field
     * @param player The player whose method adds
     */
    public void addPlayer(Player player){
        this.player = player;
        add(player);
    }

    /**
     * Adds a hidden button to move
     * @param moveButton Button whose method adds
     */
    public void addMoveButton(HiddenMoveButton moveButton){
        this.moveButton = moveButton;
        add(moveButton);
    }

    /**
     * Removes a player from the field
     */
    public void removePlayer(){
        this.player = null;
    }

    /**
     * Basic getter
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @param number
     * @param coordinationX
     * @return
     */
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
