package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Quoridor extends JPanel implements ActionListener {
    private Player playerOnTurn;
    private Player player1;
    private Player player2;
    private GamePanel gamePanel;
    private SidePanel sidePanel;
    private boolean win;

    public Quoridor() {
        initializeMailPanel();
        setFirstPlayer();
    }

    public void initializeMailPanel(){

        player1 = new Player(new Color(255, 0, 0, 224),4,0, getFinalDestinationsPlayer1());
        player2 = new Player(new Color(255, 218, 0, 255),4,8, getFinalDestinationsPlayer2());

        setSize(750,600);
        setLocation(0,0);
        setBackground(Color.YELLOW);
        setLayout(null);

        sidePanel = new SidePanel();
        sidePanel.initializePanel(this);

        gamePanel = new GamePanel(this);
        gamePanel.initializePanel(600,600,0,0,player1,player2);
        gamePanel.getGameField().setQuoridor(this);

        add(sidePanel);
        add(gamePanel);

        setVisible(true);
    }
    public ArrayList<int[]> getFinalDestinationsPlayer1(){
        ArrayList<int[]> finalDestinations = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            int[] destination = {i,8};
            finalDestinations.add(destination);
        }

        return finalDestinations;
    }
    public ArrayList<int[]> getFinalDestinationsPlayer2(){
        ArrayList<int[]> finalDestinations = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            int[] destination = {i,0};
            finalDestinations.add(destination);
        }

        return finalDestinations;
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
    public void changePlayerOnTurn(){

        if(playerOnTurn == player1){

            playerOnTurn = player2;
        } else {

            playerOnTurn = player1;

        }
    }

    public Player getPlayerOnTurn() {
        return playerOnTurn;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!win){
            if(e.getSource() == sidePanel.getMoveButton()){

                gamePanel.placeWalls(false);
                gamePanel.showHiddenMoveButtons(playerOnTurn);

            }else if(e.getSource() == sidePanel.getPlaceWallButton()){
                if(playerOnTurn.getNumberOfWalls() != 0){

                    gamePanel.hideHiddenMoveButtons();
                    gamePanel.placeWalls(true);

                }

            }
        }


    }
}
