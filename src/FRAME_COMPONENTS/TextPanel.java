package FRAME_COMPONENTS;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a text panel that provides players with information about the games
 */
public class TextPanel extends JPanel {

    private JLabel texPanel;

    public TextPanel() {

        initializeTextLabel();
        initializePanel();

    }

    /**
     * Initializes text label on which the text is subsequently printed
     */
    public void initializeTextLabel(){
        texPanel = new JLabel();

        texPanel.setBounds(10,10,310,130);

        texPanel.setBackground(new Color(34, 215, 113, 148));
        texPanel.setForeground(Color.WHITE);
        texPanel.setHorizontalAlignment(JLabel.CENTER);
        texPanel.setFont(new Font("Arial",Font.BOLD,40));
        texPanel.setFocusable(false);
        texPanel.setOpaque(true);

    }

    /**
     * Initializes panel on which textLabel is located
     */
    public void initializePanel(){
        setSize(350,150);
        setLocation(400,0);
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        add(texPanel);
        setVisible(true);
    }

    /**
     * Set the text to be displayed
     * @param text Displayed text
     */
    public void setTextOnPanel(String text){
        texPanel.setText(text);
    }

    /**
     * Clears text panel so there is nothing on it
     */
    public void clearPanel(){
        texPanel.setText("");
    }

    /**
     * Resize text
     * @param size
     */
    public void setSizeOfText(int size){
        texPanel.setFont(new Font("Arial",Font.BOLD,size));
    }

}
