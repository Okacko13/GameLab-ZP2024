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
        texPanel.setBackground(Color.DARK_GRAY);
        texPanel.setForeground(Color.WHITE);
        texPanel.setFont(new Font("Times new roman",Font.BOLD,30));
        texPanel.setFocusable(false);
    }

    public void initializePanel(){
        setBackground(Color.BLACK);
        setLayout(null);
        add(texPanel);
        setVisible(true);
    }

    public void setTextOnPanel(String text){
        texPanel.setText(text);
    }
}
