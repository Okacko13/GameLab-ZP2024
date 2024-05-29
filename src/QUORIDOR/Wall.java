package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wall extends JPanel {

    private WallDirection direction;
    private Field blocked1;
    private Field blocked2;
    private int coordinationX;
    private int coordinationY;
    private int xPlacement;
    private int yPlacement;
    private boolean placed;
    private JButton placeWall;

    public Wall(int coordinationX, int coordinationY) {
        this.coordinationX = coordinationX;
        this.coordinationY = coordinationY;
        initializePanel();
        initializeWallButton();
        setVisible(true);
    }

    public void initializePanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);

    }
    public void initializeWallButton(){
        placeWall = new JButton();
        placeWall.setBackground(new Color(70, 128, 0));
        placeWall.setFocusable(false);
        placeWall.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
        placeWall.setVisible(true);
        add(placeWall);
    }
    public void setPlace(int coordinationX, int coordinationY){
        this.setLocation(coordinationX,coordinationY);
        this.xPlacement = coordinationX;
        this.yPlacement = coordinationY;
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
    public void visibleWall(boolean bool){

        setVisible(bool);

    }

    public JButton getPlaceWall() {
        return placeWall;
    }

    public void setBlocked1(Field blocked1) {
        this.blocked1 = blocked1;
    }

    public void setBlocked2(Field blocked2) {
        this.blocked2 = blocked2;
    }

    public Field getBlocked1() {
        return blocked1;
    }

    public Field getBlocked2() {
        return blocked2;
    }

    public boolean isPlaced() {
        return placed;
    }

    public int getCoordinationX() {
        return coordinationX;
    }

    public int getCoordinationY() {
        return coordinationY;
    }

    public int getXPlacement() {
        return xPlacement;
    }

    public int getYPlacement() {
        return yPlacement;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
        placeWall.setVisible(false);
        this.setBackground(new Color(128, 74, 0));
        setVisible(false);
    }

    public void setActionListener(ActionListener actionListener){
        this.placeWall.addActionListener(actionListener);
    }
}
