package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {

    private final Color color;

    public Player(Color color) {
        this.color = color;
        initializePanel();
    }

    public void initializePanel(){
        setSize(30,30);
        setLocation(5,5);
        setBackground(color);
    }




}
