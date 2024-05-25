package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class Wall extends JPanel {

    private WallDirection direction;
    private Field blocked1;
    private Field blocked2;
    private boolean placed;

    private JButton placeWall;

    public Wall() {
        initializePanel();
        initializeWallButton();
    }

    public void initializePanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);

    }
    public void initializeWallButton(){
        placeWall = new JButton();
        placeWall.setBackground(new Color(128, 74, 0));
        add(placeWall);
    }
    public void setPlace(int coordinationX, int coordinationY){
        this.setLocation(coordinationX,coordinationY);
    }
    public void placeWall(Field field1,Field field2){
        placeWall.setVisible(false);
        this.setBackground(new Color(128, 74, 0));

        placed = true;

        this.blocked1 = field1;
        this.blocked2 = field2;

    }

    public WallDirection getDirection() {
        return direction;
    }

    public void setDirection(WallDirection direction) {
        this.direction = direction;
        if(direction == WallDirection.VERTICAL){
            this.setSize(10,64);
        } else if(direction == WallDirection.HORIZONTAL){
            this.setSize(66,10);
        }
    }

    public void setBlocked1(Field blocked1) {
        this.blocked1 = blocked1;
    }

    public void setBlocked2(Field blocked2) {
        this.blocked2 = blocked2;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
}
