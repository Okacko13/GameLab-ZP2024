package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates obstacles between Fields and graphical output for the players
 */
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

    /**
     * Initializes the panel on which the wall button is located
     */
    public void initializePanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.DARK_GRAY);

    }

    /**
     * Initializes the button through which the player places the wall
     */
    public void initializeWallButton(){
        placeWall = new JButton();
        placeWall.setBackground(new Color(70, 128, 0));
        placeWall.setFocusable(false);
        placeWall.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
        placeWall.setVisible(true);
        add(placeWall);
    }

    /**
     * Sets the coordinates at which the button will be located
     * @param coordinationX
     * @param coordinationY
     */
    public void setPlace(int coordinationX, int coordinationY){
        this.setLocation(coordinationX,coordinationY);
        this.xPlacement = coordinationX;
        this.yPlacement = coordinationY;
    }

    /**
     * Basic getter
     * @return direction
     */
    public WallDirection getDirection() {
        return direction;
    }

    /**
     * Sets direction, width and height of wall
     * @param direction
     */
    public void setDirection(WallDirection direction) {

        this.direction = direction;

        if(direction == WallDirection.VERTICAL){
            this.setSize(10,64);
        } else if(direction == WallDirection.HORIZONTAL){
            this.setSize(66,10);
        }

    }

    /**
     * Basic getter
     * @return placeWall button
     */
    public JButton getPlaceWall() {
        return placeWall;
    }

    /**
     * Basic setter
     * @param blocked1
     */
    public void setBlocked1(Field blocked1) {
        this.blocked1 = blocked1;
    }

    /**
     * Basic setter
     * @param blocked2
     */
    public void setBlocked2(Field blocked2) {
        this.blocked2 = blocked2;
    }

    /**
     * Basic getter
     * @return Blocked field number 1
     */
    public Field getBlocked1() {
        return blocked1;
    }

    /**
     * Basic getter
     * @return Blocked field number 2
     */
    public Field getBlocked2() {
        return blocked2;
    }

    /**
     * Basic getter
     * @return Returns true if wall is placed and false when wall is not placed
     */
    public boolean isPlaced() {
        return placed;
    }

    /**
     * Basic getter
     * @return coordinationX
     */
    public int getCoordinationX() {
        return coordinationX;
    }

    /**
     * Basic getter
     * @return coordinationY
     */
    public int getCoordinationY() {
        return coordinationY;
    }

    /**
     * Basic getter
     * @return
     */
    public int getXPlacement() {
        return xPlacement;
    }

    /**
     * Basic getter
     * @return
     */
    public int getYPlacement() {
        return yPlacement;
    }

    /**
     * Make wall placed
     * @param placed
     */
    public void setPlaced(boolean placed) {
        this.placed = placed;
        placeWall.setVisible(false);
        this.setBackground(new Color(128, 74, 0));
        setVisible(false);
    }

    /**
     * Basic setter
     * @param actionListener
     */
    public void setActionListener(ActionListener actionListener){
        this.placeWall.addActionListener(actionListener);
    }
}
