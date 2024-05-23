package FRAME_COMPONENTS;

import FRAME_COMPONENTS.Frame;
import FRAME_COMPONENTS.FramePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JPanel implements ActionListener {

    private JButton resetToLobby;
    private FramePanel framePanel;
    private Frame frame;

    public ResetButton(FramePanel framePanel, Frame frame) {
        this.frame = frame;
        this.framePanel = framePanel;

        setUpPanel();
        setUpResetB();

    }

    public void setFramePanel(FramePanel framePanel){
        this.framePanel = framePanel;
    }

    public void setUpPanel(){
        setSize(200,150);
        setLocation(0,0);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
    }

    public void setUpResetB(){
        resetToLobby = new JButton("LOBBY");
        resetToLobby.setBounds(10,10,180,130);
        resetToLobby.setBackground(new Color(114, 0, 255, 255));
        resetToLobby.setFont(new Font("Arial",Font.BOLD,40));
        resetToLobby.setForeground(Color.WHITE);
        resetToLobby.setFocusable(false);
        resetToLobby.setBorder(null);
        resetToLobby.addActionListener(this);
        resetToLobby.setVisible(true);

        add(resetToLobby);

    }

    public void setVisibility(Boolean visibility){
        setVisible(visibility);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(resetToLobby.equals(e.getSource())){
            framePanel.quitGame();
            frame.enableGameOButtons(true);
            framePanel.textPanel.clearPanel();
            frame.setTitle("Lobby");
        }
    }
}
