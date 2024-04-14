import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JPanel implements ActionListener {

    private JButton resetToLobby;

    public ResetButton() {

        setSize(200,100);
        setLocation(50,50);
        setBackground(new Color(86, 75, 21));
        setLayout(null);

    }

    public void setUpResetB(){
        resetToLobby = new JButton("back to lobby");
        resetToLobby.setBounds(5,5,180,90);
        resetToLobby.setIcon(null);
        resetToLobby.setBackground(new Color(215, 191, 70));
        resetToLobby.setBorderPainted(false);
        resetToLobby.setFont(new Font("High game font",Font.PLAIN,20));
        resetToLobby.setForeground(new Color(0,0,0));
        resetToLobby.setFocusable(false);
        resetToLobby.addActionListener(this);
        resetToLobby.setVisible(true);

    }

    public void setVisibility(Boolean visibility){
        setVisible(visibility);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
