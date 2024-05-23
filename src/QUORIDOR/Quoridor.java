package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Quoridor extends JPanel implements ActionListener {
    private Player playerOnTurn;
    private Player player1;
    private Player player2;

    private GamePanel gamePanel;

    private SidePanel sidePanel;

    public Quoridor() {
        initializeMailPanel();
        setFirstPlayer();
    }

    public void initializeMailPanel(){
        player1 = new Player(new Color(255, 0, 0, 224),4,0);
        player2 = new Player(new Color(255, 218, 0, 255),4,8);

        setSize(750,600);
        setLocation(0,0);
        setBackground(Color.YELLOW);
        setLayout(null);

        sidePanel = new SidePanel();
        sidePanel.initializePanel(this);

        gamePanel = new GamePanel();
        gamePanel.initializePanel(600,600,0,0,player1,player2);
        gamePanel.getGameField().setQuoridor(this);

        add(sidePanel);
        add(gamePanel);
        setVisible(true);
    }
    public void setFirstPlayer(){
        Random random = new Random();

        int rand = random.nextInt(6450);

        if(rand % 2 == 0){
            playerOnTurn = player1;
            gamePanel.getGameField().setFirstPlayerOnTurn(true);
        } else {
            playerOnTurn = player2;
            gamePanel.getGameField().setFirstPlayerOnTurn(false);
        }
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setPlayerOnTurn(Player playerOnTurn) {
        this.playerOnTurn = playerOnTurn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sidePanel.getMoveButton()){
            gamePanel.showHiddenMoveButtons(playerOnTurn);
        }
    }
}
