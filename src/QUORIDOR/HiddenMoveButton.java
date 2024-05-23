package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HiddenMoveButton extends JPanel{

    private JButton hiddenButton;
    private int coordinationX;
    private int coordinationY;

    public HiddenMoveButton(int coordinationX,int coordinationY) {
        this.coordinationX = coordinationX;
        this.coordinationY = coordinationY;
        createButton();
    }

    public void createButton() {
        this.setBounds(10,10,46,46);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setBorder(null);
        this.setFocusable(false);
        this.setVisible(false);

        initializeButton();

        add(hiddenButton);
    }
    public void initializeButton(){
        hiddenButton = new JButton();

        hiddenButton.setBounds(5,5,36,36);
        hiddenButton.setBorder(null);
        hiddenButton.setFocusable(false);
        hiddenButton.setBackground(new Color(52, 255, 223, 255));
        hiddenButton.setVisible(true);
    }


    public void addActionListener(ActionListener actionListener){
        hiddenButton.addActionListener(actionListener);
    }

    public void setVisibleButton(boolean bool){
        setVisible(bool);
    }

    public int getCoordinationX() {
        return coordinationX;
    }

    public int getCoordinationY() {
        return coordinationY;
    }

    public JButton getHiddenButton(){
        return this.hiddenButton;
    }
}
