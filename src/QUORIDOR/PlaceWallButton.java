package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlaceWallButton extends JPanel {


    private JButton placeWallButton;

    public PlaceWallButton() {
    }

    public void createMoveButton(ActionListener actionListener){
        initializePanel();
        initializeButton(actionListener);
        add(placeWallButton);
        setVisible(true);
    }

    public void initializePanel(){
        setBounds(0,250,150,250);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
    }

    public void initializeButton(ActionListener actionListener){
        placeWallButton = new JButton("WALL");
        placeWallButton.setFocusable(false);
        placeWallButton.setBackground(Color.GRAY);
        placeWallButton.setBorder(null);
        placeWallButton.setBounds(20,30,95,190);
        placeWallButton.addActionListener(actionListener);
        placeWallButton.setVisible(true);
    }

}
