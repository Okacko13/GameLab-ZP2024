package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class containing a button for displaying walls on the playing field
 */
public class PlaceWallButton extends JPanel {


    private JButton placeWallButton;

    public PlaceWallButton() {
    }

    /**
     * Creates a button with a background behind it
     * @param actionListener
     */
    public void createMoveButton(ActionListener actionListener){
        initializePanel();
        initializeButton(actionListener);
        add(placeWallButton);
        setVisible(true);
    }

    /**
     * Initializes the panel on which the wall button is located
     */
    public void initializePanel(){
        setBounds(0,250,150,250);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
    }

    /**
     * Initializes the button for displaying walls
     * @param actionListener
     */
    public void initializeButton(ActionListener actionListener){
        placeWallButton = new JButton("WALL");
        placeWallButton.setFocusable(false);
        placeWallButton.setBackground(Color.GRAY);
        placeWallButton.setBorder(null);
        placeWallButton.setBounds(20,30,95,190);
        placeWallButton.addActionListener(actionListener);
        placeWallButton.setVisible(true);
    }

    /**
     * basic getter
     * @return
     */
    public JButton getPlaceWallButton() {
        return placeWallButton;
    }
}
