package FRAME_COMPONENTS;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private JLabel texPanel;

    public TextPanel() {

        initializeTextPanel();
        initializePanel();

    }

    public void initializeTextPanel(){
        texPanel = new JLabel();

        texPanel.setBounds(10,10,310,130);

        texPanel.setBackground(new Color(114, 0, 255, 255));
        texPanel.setForeground(Color.WHITE);
        texPanel.setHorizontalAlignment(JLabel.CENTER);
        texPanel.setFont(new Font("Arial",Font.BOLD,40));
        texPanel.setFocusable(false);
        texPanel.setOpaque(true);

        texPanel.setText("Pokus");

    }

    public void initializePanel(){
        setSize(350,150);
        setLocation(400,0);
        setBackground(new Color(72, 67, 66));
        setLayout(null);

        add(texPanel);
        setVisible(true);
    }

    public void setTextOnPanel(String text){
        texPanel.setText(text);
    }
}
