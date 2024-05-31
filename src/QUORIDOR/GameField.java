package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is where most of the game is processed
 * Includes the playing field and working with the players
 */
public class GameField extends JLayeredPane implements ActionListener {

    private boolean firstPlayerOnTurn;
    private Player player1;
    private Player player2;
    private Field[][] fieldArray;
    private Quoridor quoridor;
    private HiddenMoveButton[][] hiddenMoveButtons;
    private GamePanel gamePanel;

    private int numberOfPlacedWalls = 0;


    public GameField(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        initializePanel();
        initializeFields();
    }

    /**
     * Initializes the panel on which the graphic output is subsequently located
     */
    public void initializePanel(){
        setLayout(null);
        setBounds(0,0,600,562);
        setBackground(Color.BLACK);
    }

    /**
     * Initializes the playing field
     */
    public void initializeFields(){
        fieldArray =  new Field[9][9];

        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {

                fieldArray[i][j] = new Field(this,j,i);
                fieldArray[i][j].setVisibility(true);
                add(fieldArray[i][j],JLayeredPane.DEFAULT_LAYER);

            }
        }
    }

    /**
     * Assigns hidden move buttons to fields
     * @param coordinationX
     * @param coordinationY
     * @param moveButton
     */
    public void addMoveButtonByIndex(int coordinationX,int coordinationY,HiddenMoveButton moveButton){
        fieldArray[coordinationY][coordinationX].addMoveButton(moveButton);
    }

    /**
     * basic setter
     * @param bool
     */
    public void setVisibleField(boolean bool){
        setVisible(bool);
    }
    public void addPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;

        fieldArray[0][4].addPlayer(player1);
        fieldArray[8][4].addPlayer(player2);
    }

    /**
     * Sets hidden buttons for movement
     * @param hiddenMoveButtons
     */
    public void setHiddenMoveButtons(HiddenMoveButton[][] hiddenMoveButtons){
        this.hiddenMoveButtons = hiddenMoveButtons;
        for (HiddenMoveButton[] hiddenMoveButton : hiddenMoveButtons) {
            for (int j = 0; j < hiddenMoveButtons.length; j++) {
                hiddenMoveButton[j].addActionListener(this);
            }
        }
    }

    public void setFirstPlayerOnTurn(boolean bool){
        this.firstPlayerOnTurn = bool;
    }

    public void setQuoridor(Quoridor quoridor) {
        this.quoridor = quoridor;
    }

    /**
     * Returns a field according to the given coordinate
     * @param coordinationX
     * @param coordinationY
     * @return Returns the given field
     */
    public Field getFieldByIndex(int coordinationX, int coordinationY){
        return fieldArray[coordinationY][coordinationX];
    }

    /**
     * Transfers the game to the other player
     */
    public void changePlayerOnTurn(){
        if(firstPlayerOnTurn){
            setFirstPlayerOnTurn(false);
        } else {
            setFirstPlayerOnTurn(true);
        }
    }

    /**
     * Adds panel to the main panel
     * @param component Panel we want to add
     */
    public void addWall(JPanel component){
        add(component,JLayeredPane.MODAL_LAYER);
    }

    /**
     * Removes panels from the main panel
     * @param component The panel we want to remove
     */

    public void removeComponent(JPanel component){
        remove(component);
    }

    /**
     * Creates a permanent representation of the laid wall
     * @param wall1 The first wall from which the subsequent wall is formed
     * @param wall2 The second wall from which the subsequent wall is formed
     * @return The panel that will be subsequently added for graphic output to the monitor
     */
    public JPanel createWallDisplay(Wall wall1,Wall wall2){

        JPanel wall = new JPanel();
        wall.setBackground(new Color(128, 74, 0));

        if(wall1.getDirection() == WallDirection.HORIZONTAL){
            if(wall1.getXPlacement() < wall2.getXPlacement()){
                wall.setBounds(wall1.getXPlacement(),wall1.getYPlacement(),130,10);
            }else{
                wall.setBounds(wall2.getXPlacement(),wall2.getYPlacement(),130,10);
            }

        } else if(wall1.getDirection() == WallDirection.VERTICAL) {
            if(wall1.getYPlacement() < wall2.getYPlacement()){
                wall.setBounds(wall1.getXPlacement(),wall1.getYPlacement(),10,128);
            }else{
                wall.setBounds(wall2.getXPlacement(),wall2.getYPlacement(),10,128);
            }
        }

        return wall;
    }

    /**
     * Processes attempted player movement
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean operationDone = false;
        for (int i = 0; i < hiddenMoveButtons.length; i++) {
            if(operationDone)break;
            for (int j = 0; j < hiddenMoveButtons.length; j++) {

                if(!operationDone){ // Break outer loop if operation is done

                    if(e.getSource().equals(hiddenMoveButtons[i][j].getHiddenButton())){

                        operationDone = true;

                        if(firstPlayerOnTurn){ // Check if it's the first player's turn

                            fieldArray[player1.getCoordinationY()][player1.getCoordinationX()].removePlayer(); // Remove player 1 from current position

                            player1.moveCoordinationX(hiddenMoveButtons[i][j].getCoordinationX()); // Move player 1's X coordinate

                            if(player1.moveCoordinationY(hiddenMoveButtons[i][j].getCoordinationY())) { // Move player 1's Y coordinate and check for win condition

                                quoridor.setWin(true);
                                quoridor.getTextPanel().setSizeOfText(30);
                                quoridor.getTextPanel().setTextOnPanel("Player 1 is winner");
                                fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player1);

                            } else {

                                fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player1);
                                this.quoridor.setPlayer1(player1);

                                this.quoridor.changePlayerOnTurn(); // Change turn to next player

                                setFirstPlayerOnTurn(false);
                            }

                        } else { // It's the second player's turn

                            fieldArray[player2.getCoordinationY()][player2.getCoordinationX()].removePlayer();  // Remove player 2 from current position

                            player2.moveCoordinationX(hiddenMoveButtons[i][j].getCoordinationX());

                            if(player2.moveCoordinationY(hiddenMoveButtons[i][j].getCoordinationY())){ // Move player 2's Y coordinate and check for win condition

                                quoridor.setWin(true);
                                quoridor.getTextPanel().setSizeOfText(30);
                                quoridor.getTextPanel().setTextOnPanel("Player 2 is winner");
                                fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player2);

                            } else {

                                fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player2);
                                this.quoridor.setPlayer2(player2);

                                this.quoridor.changePlayerOnTurn(); // Change turn to next player

                                setFirstPlayerOnTurn(true);
                            }

                        }
                        gamePanel.hideHiddenMoveButtons(); // Hide the move buttons
                        setVisibleField(false);
                        break;
                    }
                }else{
                    break;
                }

            }
        }
        setVisibleField(true);
    }
}
