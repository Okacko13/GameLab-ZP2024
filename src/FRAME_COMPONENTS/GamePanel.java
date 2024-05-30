package FRAME_COMPONENTS;

import MASTERMIND.Mastermind;
import QUORIDOR.Quoridor;
import TICTACTOE.TicTacToe;

import javax.swing.*;
import java.awt.*;

/**
 * Displays the game itself
 */
public class GamePanel extends JPanel {

    private GamePlaying gamePlaying;
    private TicTacToe ticTacToe;
    private Mastermind mastermind;
    private Quoridor quoridor;

    public GamePanel() {
        setUpPanel();
    }

    /**
     * Sets the panel on which the game will run
     */
    public void setUpPanel(){
        setBounds(0,150,750,600);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setVisible(false);
        gamePlaying = GamePlaying.NONE;
    }

    /**
     * Mediates the visibility of the panel
     * @param bool
     */
    public void setVisibility(boolean bool){
        setVisible(bool);
    }

    /**
     * Removes games from the panel when switching to lobbies
     */
    public void removeGame(){

        switch (gamePlaying){
            case NONE:
                break;
            case QUORIDOR:
                gamePlaying = GamePlaying.NONE;
                remove(quoridor);
                break;
            case TICTACTOE:
                gamePlaying = GamePlaying.NONE;
                remove(ticTacToe);
                break;
            case MASTERMIND:
                gamePlaying = GamePlaying.NONE;
                remove(mastermind);
                break;
        }

    }

    /**
     * Starts a game of Tic Tac Toe
     * @param ticTacToe
     */
    public void startTicTacToe(TicTacToe ticTacToe){

        gamePlaying = GamePlaying.TICTACTOE;
        setLayout(null);

        this.ticTacToe = ticTacToe;

        add(ticTacToe);

    }

    /**
     * Starts the game Mastermind
     * @param mastermind
     */
    public void startMastermind(Mastermind mastermind){

        gamePlaying = GamePlaying.MASTERMIND;
        setLayout(null);

        this.mastermind = mastermind;

        add(mastermind);
    }

    /**
     * Starts the game Quoridor
     * @param quoridor
     */
    public void startQuoridor(Quoridor quoridor){

        gamePlaying = GamePlaying.QUORIDOR;
        setLayout(null);

        this.quoridor = quoridor;
        add(quoridor);

    }

    /**
     * Returns information about which game is currently running on the panel
     * @return Enum gamePlaying
     */
    public GamePlaying getGame(){
        return this.gamePlaying;
    }

    public TicTacToe getTicTacToe(){
        return ticTacToe;
    }
    public Mastermind getMastermind(){
        return mastermind;
    }
    public Quoridor getQuoridor(){
        return quoridor;
    }

}
