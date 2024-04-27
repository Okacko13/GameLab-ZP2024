import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        setUpPanel();
    }

    public void setUpPanel(){
        setBounds(0,0,750,750);
        setLayout(null);
        setBackground(Color.BLACK);
        setVisible(false);
    }

    public void setVisibility(boolean bool){
        setVisible(bool);
    }




}