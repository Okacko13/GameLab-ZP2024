package FRAME_COMPONENTS;

import MASTERMIND.Mastermind;
import MASTERMIND.ResetMastermind;
import QUORIDOR.Quoridor;
import QUORIDOR.ResetQuoridorButton;
import TICTACTOE.ResetTicTacToeButton;
import TICTACTOE.TicTacToe;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a panel on which everything is on when you start one of the games
 */
public class FramePanel extends JPanel {

    private GamePanel gamePanel;
    protected TextPanel textPanel;
    private ResetTicTacToeButton resetTTT;
    private ResetMastermind resetMastermind;
    private ResetQuoridorButton resetQuoridor;
    private ResetButton backToLobby;
    private JPanel top;

    public FramePanel(GamePanel gamePanel, TextPanel textPanel, ResetTicTacToeButton resetTTT, ResetMastermind resetMastermind, ResetQuoridorButton resetQuoridor, ResetButton backToLobby) {
        this.gamePanel = gamePanel;
        this.textPanel = textPanel;
        this.resetTTT = resetTTT;
        this.resetMastermind = resetMastermind;
        this.resetQuoridor = resetQuoridor;
        this.backToLobby = backToLobby;
        backToLobby.setFramePanel(this);
        setTop();

        add(gamePanel,BorderLayout.CENTER);
        setFramePanel();
    }

    /**
     * Adjusts the visibility of the panel
     * @param bool
     */
    public void setVisibility(boolean bool){
        setVisible(bool);
    }

    /**
     * sets the top, which includes Reset Button, Lobby Button and Text Panel
     */
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

    /**
     * Sets main panel
     */
    public void setFramePanel(){
        setBounds(0,0,750,750);
        setLayout(new BorderLayout());
        setVisible(false);
    }

    /**
     * Starts a game of Tic Tac Toe
     * @param ticTacToe
     */
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

    /**
     * Starts a game Mastermind
     * @param mastermind
     */
    public void startMastermind(Mastermind mastermind){

        top.add(resetMastermind);

        mastermind.setTextPanel(this.textPanel);
        gamePanel.setVisibility(true);
        gamePanel.startMastermind(mastermind);

        resetMastermind.setGamePanel(this);

        top.setVisible(true);

        setVisibility(true);
    }

    /**
     * Starts a game Quoridor
     * @param quoridor
     */
    public void startQuoridor(Quoridor quoridor){

        top.add(resetQuoridor);

        quoridor.setTextPanel(this.textPanel);
        quoridor.setFirstPlayer();
        gamePanel.startQuoridor(quoridor);
        gamePanel.setVisibility(true);

        resetQuoridor.setGamePanel(this);

        top.setVisible(true);
        setVisibility(true);
    }

    /**
     * Shuts down the game and puts the panel in a state where it is ready to accept a new game
     */
    public void quitGame(){

        switch (gamePanel.getGame()){
            case MASTERMIND:
                top.remove(resetMastermind);
                break;
            case TICTACTOE:
                top.remove(resetTTT);
                break;
            case QUORIDOR:
                top.remove(resetQuoridor);
                break;
            case NONE:
                break;
        }

        gamePanel.removeGame();
        setVisibility(false);
    }


}
