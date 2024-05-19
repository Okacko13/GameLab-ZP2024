package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quoridor extends JPanel implements ActionListener {

    private Player playerOnTurn;

    private GamePanel gamePanel;

    private SidePanel sidePanel;

    public Quoridor() {
        initializeMailPanel();
    }

    public void initializeMailPanel(){
        setSize(750,600);
        setLocation(0,0);
        setBackground(Color.YELLOW);
        setLayout(null);

        sidePanel = new SidePanel();
        sidePanel.initializePanel(this);

        gamePanel = new GamePanel();
        gamePanel.initializePanel(600,600,0,0,new Player(Color.BLUE),new Player(Color.RED));

        add(sidePanel);
        add(gamePanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
