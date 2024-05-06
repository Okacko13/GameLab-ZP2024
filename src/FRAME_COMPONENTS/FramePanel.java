package FRAME_COMPONENTS;

import MASTERMIND.Mastermind;
import TICTACTOE.ResetTicTacToeButton;
import TICTACTOE.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class FramePanel extends JPanel {

    private GamePanel gamePanel;
    protected TextPanel textPanel;
    private ResetTicTacToeButton resetTTT;
    private ResetButton backToLobby;
    private JPanel top;

    public FramePanel(GamePanel gamePanel, TextPanel textPanel, ResetTicTacToeButton resetTTT, ResetButton backToLobby) {
        this.gamePanel = gamePanel;
        this.textPanel = textPanel;
        this.resetTTT = resetTTT;
        this.backToLobby = backToLobby;
        backToLobby.setFramePanel(this);

        setTop();
        add(gamePanel,BorderLayout.CENTER);
        setFramePanel();
    }

    public void setVisibility(boolean bool){
        setVisible(bool);
    }
    public void setTop(){
        top = new JPanel();
        top.setBounds(0,0,750,150);
        top.setBackground(Color.BLACK);
        top.setLayout(null);
        top.add(backToLobby);
        top.add(resetTTT);
        top.add(textPanel);
        top.setVisible(false);

        textPanel.setTextOnPanel("Tic-Tac-Toe");

        this.add(top,BorderLayout.NORTH);
    }
    public void setFramePanel(){
        setBounds(0,0,750,750);
        setLayout(new BorderLayout());
        setVisible(false);
    }

    public void startTicTacToe(TicTacToe ticTacToe){
        ticTacToe.setTextPanel(this.textPanel);

        gamePanel.setVisibility(true);
        gamePanel.startTicTacToe(ticTacToe);

        resetTTT.setTicTacToe(ticTacToe);

        top.setVisible(true);
        setVisibility(true);

    }
    public void startMastermind(Mastermind mastermind){
        gamePanel.setVisibility(true);
        gamePanel.startMastermind(mastermind);

        top.setVisible(true);

        setVisibility(true);
    }

    public void quitGame(){
        gamePanel.removeGame();
        setVisibility(false);
    }


}
