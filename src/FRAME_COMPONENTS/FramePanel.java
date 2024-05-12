package FRAME_COMPONENTS;

import MASTERMIND.Mastermind;
import MASTERMIND.ResetMastermind;
import TICTACTOE.ResetTicTacToeButton;
import TICTACTOE.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class FramePanel extends JPanel {

    private GamePanel gamePanel;
    protected TextPanel textPanel;
    private ResetTicTacToeButton resetTTT;
    private ResetMastermind resetMastermind;
    private ResetButton backToLobby;
    private JPanel top;

    public FramePanel(GamePanel gamePanel, TextPanel textPanel, ResetTicTacToeButton resetTTT, ResetMastermind resetMastermind, ResetButton backToLobby) {
        this.gamePanel = gamePanel;
        this.textPanel = textPanel;
        this.resetTTT = resetTTT;
        this.resetMastermind = resetMastermind;
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
        top.add(textPanel);
        top.setVisible(false);

        this.add(top,BorderLayout.NORTH);
    }
    public void setFramePanel(){
        setBounds(0,0,750,750);
        setLayout(new BorderLayout());
        setVisible(false);
    }

    public void startTicTacToe(TicTacToe ticTacToe){

        top.add(resetTTT);

        ticTacToe.setTextPanel(this.textPanel);
        ticTacToe.firstTurn();

        gamePanel.setVisibility(true);
        gamePanel.startTicTacToe(ticTacToe);

        resetTTT.setTicTacToe(ticTacToe);

        top.setVisible(true);
        setVisibility(true);

    }
    public void startMastermind(Mastermind mastermind){

        top.add(resetMastermind);

        mastermind.setTextPanel(this.textPanel);
        gamePanel.setVisibility(true);
        gamePanel.startMastermind(mastermind);

        resetMastermind.setGamePanel(this);

        top.setVisible(true);

        setVisibility(true);
    }

    public void quitGame(){

        switch (gamePanel.getGame()){
            case MASTERMIND:
                top.remove(resetMastermind);
                break;
            case TICTACTOE:
                top.remove(resetTTT);
                break;
            case QUORIDOR:
                //top.remove(resetQuoridor);
                break;
            case NONE:
                break;
        }

        gamePanel.removeGame();
        setVisibility(false);
    }


}
