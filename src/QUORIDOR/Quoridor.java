package QUORIDOR;

import FRAME_COMPONENTS.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * There's a whole game of quoridor going on here
 */
public class Quoridor extends JPanel implements ActionListener {
    private Player playerOnTurn;
    private Player player1;
    private Player player2;
    private GamePanel gamePanel;
    private SidePanel sidePanel;
    private boolean win;
    private TextPanel textPanel;

    public Quoridor() {
        initializeMailPanel();
    }

    /**
     * Initializes the panel and components needed to play the game
     */
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

    /**
     * Generates destinations for the first player
     * @return Returns a list of coordinates of the fields where the first player wins
     */
    public static ArrayList<int[]> getFinalDestinationsPlayer1(){
        ArrayList<int[]> finalDestinations = new ArrayList<>();

        for(int i = 0; i < 9; i++){

            int[] destination = {i,8};
            finalDestinations.add(destination);

        }

        return finalDestinations;
    }

    /**
     * Generates destinations for the second player
     * @return Returns a list of coordinates of the fields where the second player wins
     */
    public static ArrayList<int[]> getFinalDestinationsPlayer2(){
        ArrayList<int[]> finalDestinations = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            int[] destination = {i,0};
            finalDestinations.add(destination);
        }

        return finalDestinations;
    }

    /**
     * Randomly determine which player will start
     */
    public void setFirstPlayer(){
        Random random = new Random();

        int rand = random.nextInt(6450);

        if(rand % 2 == 0){
            playerOnTurn = player1;
            gamePanel.getGameField().setFirstPlayerOnTurn(true);

            textPanel.setTextOnPanel("Player 1 begins");

        } else {
            playerOnTurn = player2;
            gamePanel.getGameField().setFirstPlayerOnTurn(false);

            textPanel.setTextOnPanel("Player 2 begins");
        }
    }

    /**
     * Basic setter
     * @param player1
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Basic setter
     * @param player2
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Switches players on the turn
     */
    public void changePlayerOnTurn(){

        if(playerOnTurn == player1){

            playerOnTurn = player2;
            textPanel.setTextOnPanel("Player 2 is on turn");

        } else {

            playerOnTurn = player1;
            textPanel.setTextOnPanel("Player 1 is on turn");

        }
    }

    /**
     * Basic getter
     * @return playerOnTurn
     */
    public Player getPlayerOnTurn() {
        return playerOnTurn;
    }

    /**
     * Basic setter
     * @param win
     */
    public void setWin(boolean win) {
        this.win = win;
    }

    /**
     * Checks if the move or wall button has been pressed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = "Player 2 ";
        if(playerOnTurn == player1){
            name = "Player 1 ";
        }

        if(!win){
            if(e.getSource() == sidePanel.getMoveButton()){

                gamePanel.placeWalls(false);
                textPanel.setSizeOfText(30);
                textPanel.setTextOnPanel(name + "is moving");
                gamePanel.showHiddenMoveButtons(playerOnTurn);


            }else if(e.getSource() == sidePanel.getPlaceWallButton()){
                if(playerOnTurn.getNumberOfWalls() != 0){

                    gamePanel.hideHiddenMoveButtons();
                    textPanel.setSizeOfText(25);
                    textPanel.setTextOnPanel(name + "is placing a wall");
                    gamePanel.placeWalls(true);

                }

            }
        }
    }

    /**
     * Basic getter
     * @return textPanel
     */
    public TextPanel getTextPanel() {
        return textPanel;
    }

    /**
     * Basic setter
     * @param textPanel
     */
    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }
}
