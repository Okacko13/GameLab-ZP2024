package FRAME_COMPONENTS;

import MASTERMIND.Mastermind;
import QUORIDOR.Quoridor;
import TICTACTOE.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GamePlaying gamePlaying;
    private TicTacToe ticTacToe;
    private Mastermind mastermind;
    private Quoridor quoridor;

    public GamePanel() {
        setUpPanel();
    }

    public void setUpPanel(){
        setBounds(0,150,750,600);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setVisible(false);
        gamePlaying = GamePlaying.NONE;
    }

    public void setVisibility(boolean bool){
        setVisible(bool);
    }
    public void removeGame(){

        switch (gamePlaying){
            case NONE:
                break;
            case QUORIDOR:
                gamePlaying = GamePlaying.NONE;
                //remove(quoridor);
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

    public void startTicTacToe(TicTacToe ticTacToe){

        gamePlaying = GamePlaying.TICTACTOE;
        setLayout(null);

        this.ticTacToe = ticTacToe;

        add(ticTacToe);

    }
    public void startMastermind(Mastermind mastermind){

        gamePlaying = GamePlaying.MASTERMIND;
        setLayout(null);

        this.mastermind = mastermind;

        add(mastermind);
    }

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
