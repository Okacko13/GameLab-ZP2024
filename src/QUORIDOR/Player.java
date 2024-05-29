package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JPanel {

    private final Color color;
    private int numberOfWalls = 8;
    private int coordinationX;
    private int coordinationY;
    private ArrayList<int[]> finalDestinations;

    public Player(Color color, int coordinationX,int coordinationY,ArrayList<int[]> finalDestinations) {
        this.coordinationX = coordinationX;
        this.coordinationY = coordinationY;
        this.color = color;

        this.finalDestinations = finalDestinations;
        initializePanel();
    }

    public void initializePanel(){
        setSize(30,30);
        setLocation(18,18);
        setBackground(color);
        setVisible(true);
    }
    public int getNumberOfWalls(){
        return numberOfWalls;
    }

    public void placeWall(){
        if(numberOfWalls > 0){
            numberOfWalls--;
        }
    }

    public int getCoordinationX() {
        return coordinationX;
    }

    public void moveCoordinationX(int move) {
        if(move - 1 == coordinationX || move + 1 == coordinationX || move == coordinationX || move - 2 == coordinationX || move + 2 == coordinationX ){
            this.coordinationX = move;
        }
    }

    public int getCoordinationY() {
        return coordinationY;
    }

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
