import javax.swing.*;
import java.awt.*;

public class ResetButton extends JPanel {

    private JButton resetToLobby;

    public ResetButton() {

        setSize(100,100);
        setLocation(50,50);
        setBackground(new Color(118, 70, 215));
        setLayout(null);

    }


    public void setVisibility(Boolean visibility){
        setVisible(visibility);
    }



}
