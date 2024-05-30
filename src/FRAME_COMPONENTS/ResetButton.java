package FRAME_COMPONENTS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Shuts down the game and returns the player to the game lobby
 */
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

    /**
     * Basic setter
     * @param framePanel
     */
    public void setFramePanel(FramePanel framePanel){
        this.framePanel = framePanel;
    }

    /**
     * Sets the panel
     */
    public void setUpPanel(){
        setSize(200,150);
        setLocation(0,0);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
    }

    /**
     * Sets the button to be functional
     */
    public void setUpResetB(){
        resetToLobby = new JButton("LOBBY");
        resetToLobby.setBounds(10,10,180,130);
        resetToLobby.setBackground(new Color(34, 215, 113, 148));
        resetToLobby.setFont(new Font("Arial",Font.BOLD,40));
        resetToLobby.setForeground(Color.WHITE);
        resetToLobby.setFocusable(false);
        resetToLobby.setBorder(null);
        resetToLobby.addActionListener(this);
        resetToLobby.setVisible(true);

        add(resetToLobby);

    }

    /**
     * Sets the visibility of the button
     * @param visibility
     */
    public void setVisibility(Boolean visibility){
        setVisible(visibility);
    }

    /**
     * Mediates a return to the game lobby
     * @param e the event to be processed
     */
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
