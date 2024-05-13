package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {

    }

    public void initializePanel(int width, int length, int x, int y){
        setBounds(x,y,width,length);
        setLayoutOfPanel();
    }
    public void setLayoutOfPanel(){
        setLayout(new GridLayout(9,9));
    }

}
