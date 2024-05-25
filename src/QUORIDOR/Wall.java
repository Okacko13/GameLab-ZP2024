package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wall extends JPanel implements ActionListener {

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
        setVisible(false);

    }
    public void initializeWallButton(){
        placeWall = new JButton();
        placeWall.setBackground(new Color(128, 74, 0));
        placeWall.setFocusable(false);
        placeWall.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
        placeWall.addActionListener(this);
        add(placeWall);
    }
    public void setPlace(int coordinationX, int coordinationY){
        this.setLocation(coordinationX,coordinationY);
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

    public void setBlocked1(Field blocked1) {
        this.blocked1 = blocked1;
    }

    public void setBlocked2(Field blocked2) {
        this.blocked2 = blocked2;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
        if(placed){
            setVisible(true);
            placeWall.setVisible(false);
            this.setBackground(new Color(128, 74, 0));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==  placeWall){
            setPlaced(true);
        }
    }
}
