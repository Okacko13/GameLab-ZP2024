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
        if(gamePlaying == GamePlaying.TICTACTOE){
            gamePlaying = GamePlaying.NONE;
            remove(ticTacToe);
        }
        switch (gamePlaying){
            case NONE:
                break;
            case QUORIDOR:
                gamePlaying = GamePlaying.NONE;
                //remove(quoridor);
            case TICTACTOE:
                gamePlaying = GamePlaying.NONE;
                remove(ticTacToe);
            case MASTERMIND:
                gamePlaying = GamePlaying.NONE;
                //remove(mastermind);
        }

    }

    public void startTicTacToe(TicTacToe ticTacToe){

        gamePlaying = GamePlaying.TICTACTOE;

        this.ticTacToe = ticTacToe;

        add(ticTacToe);

    }

    public void getGame(){
        switch (gamePlaying){
            case NONE :
                break;
            case TICTACTOE:
                getTicTacToe();
                break;
            case MASTERMIND:
                getMastermind();
                break;
            case QUORIDOR:
                getQuoridor();
                break;
        }
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
