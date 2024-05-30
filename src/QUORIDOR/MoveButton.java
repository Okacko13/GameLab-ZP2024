package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class that displays hidden buttons for movement
 */
public class MoveButton extends JPanel {

    private JButton moveButton;

    public MoveButton() {
    }

    /**
     * Creates a button
     * @param actionListener
     */
    public void createMoveButton(ActionListener actionListener){
        initializePanel();
        initializeButton(actionListener);
        add(moveButton);
        setVisible(true);
    }

    /**
     * Initializes the panel on which the button will be located
     */
    public void initializePanel(){
        setBounds(0,0,150,250);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
    }

    /**
     * Initializes the button
     * @param actionListener
     */
    public void initializeButton(ActionListener actionListener){
        moveButton = new JButton("MOVE");
        moveButton.setFocusable(false);
        moveButton.setBackground(Color.GRAY);
        moveButton.setBorder(null);
        moveButton.setBounds(20,30,95,190);
        moveButton.addActionListener(actionListener);
        moveButton.setVisible(true);
    }

    /**
     *
     * @return
     */
    public JButton getMoveButton(){
        return moveButton;
    }

}
