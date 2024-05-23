package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel {

    private MoveButton moveButton;
    private PlaceWallButton placeWallButton;

    public SidePanel() {

    }

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

    public JButton getMoveButton(){
        return moveButton.getMoveButton();
    }

}
