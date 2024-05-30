package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Creates a side panel on which the moin control buttons are located
 */
public class SidePanel extends JPanel {

    private MoveButton moveButton;
    private PlaceWallButton placeWallButton;

    public SidePanel() {

    }

    /**
     * Initializes the panel and its components
     * @param actionListener
     */
    public void initializePanel(ActionListener actionListener){
        moveButton = new MoveButton();
        placeWallButton = new PlaceWallButton();

        moveButton.createMoveButton(actionListener);
        placeWallButton.createMoveButton(actionListener);

        this.setBounds(600,0,150,600);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);

        this.add(moveButton);
        this.add(placeWallButton);
        setVisible(true);
    }

    /**
     * Returns button of moveButton class
     * @return Button
     */
    public JButton getMoveButton(){
        return moveButton.getMoveButton();
    }

    /**
     * Returns button of placeWallButton class
     * @return Button
     */
    public JButton getPlaceWallButton() {
        return placeWallButton.getPlaceWallButton();
    }
}
