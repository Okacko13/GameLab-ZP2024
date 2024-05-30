package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the player behind the computer in the game
 */
public class Player extends JPanel {

    private final Color color;
    private int numberOfWalls = 8;
    private int coordinationX;
    private int coordinationY;
    private final ArrayList<int[]> finalDestinations;

    public Player(Color color, int coordinationX,int coordinationY,ArrayList<int[]> finalDestinations) {
        this.coordinationX = coordinationX;
        this.coordinationY = coordinationY;
        this.color = color;

        this.finalDestinations = finalDestinations;
        initializePanel();
    }

    /**
     * Initializes the graphical form of the player on the GameField
     */
    public void initializePanel(){
        setSize(30,30);
        setLocation(18,18);
        setBackground(color);
        setVisible(true);
    }

    /**
     * Basic getter
     * @return numberOfWalls
     */
    public int getNumberOfWalls(){
        return numberOfWalls;
    }

    /**
     * When the wall is laid, it takes away the number of remaining walls
     */
    public void placeWall(){
        if(numberOfWalls > 0){
            numberOfWalls--;
        }
    }

    /**
     * Basic getter
     * @return coordinationX
     */
    public int getCoordinationX() {
        return coordinationX;
    }

    /**
     * Shifts the player on the x-axis, but only by 1
     * @param move Coordinates where the player should move to
     */
    public void moveCoordinationX(int move) {
        if(move - 1 == coordinationX || move + 1 == coordinationX || move == coordinationX || move - 2 == coordinationX || move + 2 == coordinationX ){
            this.coordinationX = move;
        }
    }

    /**
     * Basic getter
     * @return coordinationY
     */
    public int getCoordinationY() {
        return coordinationY;
    }

    /**
     * Moves the player on the y-axis, but always only by 1. Checks if the player has not arrived at the destination
     * @param move Coordinates where the player should move to
     * @return Returns true when the coordinate is one of the target
     */
    public boolean moveCoordinationY(int move) {
        if(move - 1 == coordinationY || move + 1 == coordinationY || move == coordinationY || move - 2 == coordinationY || move + 2 == coordinationY ){
            this.coordinationY = move;

            for (int i = 0; i < finalDestinations.size(); i++) {
                if(coordinationY == finalDestinations.get(i)[1]){
                    return true;
                }
            }
        }
        return false;
    }
}
