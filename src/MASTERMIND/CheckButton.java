package MASTERMIND;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 */
public class CheckButton extends JButton {

    private String text;

    public CheckButton() {

        setFocusable(false);
        setBounds(275,400,200,50);
        setFont(new Font("Times new roman", Font.PLAIN, 20));
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        setVisible(true);

    }

    /**
     * basic setter
     * @param s
     */
    public void setTextButton(String s){
        setText(s);
        text = s;
    }

    /**
     * assigns the ActionListener to the button
     * @param actionListener
     */
    public void setActionListener(ActionListener actionListener){
        addActionListener(actionListener);
    }



}
