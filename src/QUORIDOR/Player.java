package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {

    private final Color color;
    private int numberOfWalls = 8;

    private int coordinationX;
    private int coordinationY;

    public Player(Color color) {
        this.color = color;
        initializePanel();
    }

    public void initializePanel(){
        setSize(30,30);
        setLocation(5,5);
        setBackground(color);
    }
    public int getNumebreOfWalls(){
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

    public void setCoordinationX(int move) {
        if(move - 1 == coordinationX || move + 1 == coordinationX){
            this.coordinationX = move;
        }
    }

    public int getCoordinationY() {
        return coordinationY;
    }

    public void setCoordinationY(int move) {
        if(move - 1 == coordinationX || move + 1 == coordinationX){
            this.coordinationY = move;
        }
    }
}
