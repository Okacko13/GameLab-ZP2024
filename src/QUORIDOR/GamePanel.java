package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class that transfers graphical representation
 * Most of the logic for the quoridor game is handled here
 */
public class GamePanel extends JPanel implements ActionListener {
    private GameField gameField;
    private HiddenMoveButton[][] hiddenButtons;
    private ArrayList<int[]> indexShownButtons = new ArrayList<>();
    private Wall[][] horizontalWalls;
    private Wall[][] verticalWalls;
    private Quoridor quoridor;
    private ArrayList<int[]> indexPlacedWallsHorizontal = new ArrayList<>();
    private ArrayList<int[]> indexPlacedWallsVertical = new ArrayList<>();
    private ArrayList<Wall> temporaryWallPlace = new ArrayList<>();
    private boolean addingToHorizontal;

    public GamePanel(Quoridor quoridor) {
        this.quoridor = quoridor;
    }

    /**
     * Initializes the panel and most other elements of the class
     * @param width sets the width
     * @param height sets the height
     * @param x sets location on x-axis
     * @param y sets location on y-axis
     * @param player1 sets player 1
     * @param player2 sets player 2
     */
    public void initializePanel(int width, int height, int x, int y,Player player1, Player player2){
        setBounds(x,y,width,height);
        setBackground(Color.BLACK);
        setLayout(null);

        initializeGameField(player1,player2);
        initializeWalls();
        initializeButtons();

        gameField.setHiddenMoveButtons(this.hiddenButtons);

        setVisible(true);
    }
    public void initializeButtons(){
        this.hiddenButtons = new HiddenMoveButton[9][9];

        for (int i = 0; i < hiddenButtons.length; i++) {
            for (int j = 0; j < hiddenButtons.length; j++) {
                hiddenButtons[i][j] = new HiddenMoveButton(j,i);
                gameField.addMoveButtonByIndex(j,i,hiddenButtons[i][j]);
            }
        }

    }

    /**
     * Puts the walls in place
     * @param bool
     */
    public void placeWalls(boolean bool){
        gameField.setVisibleField(false);


        for (int i = 0; i < 8; i++) {       //horizontal
            for (int j = 0; j < 9; j++) {

               if(!horizontalWalls[i][j].isPlaced()){
                   if(bool){
                       gameField.addWall(horizontalWalls[i][j]);
                   }else{
                       gameField.removeComponent(horizontalWalls[i][j]);
                   }
               }

            }
        }

        for (int i = 0; i < 9; i++) {       //vertical
            for (int j = 0; j < 8; j++) {

                if(!verticalWalls[i][j].isPlaced()){
                    if(bool){
                        gameField.addWall(verticalWalls[i][j]);
                    }else{
                        gameField.removeComponent(verticalWalls[i][j]);
                    }
                }


            }
        }
        gameField.setVisibleField(true);
    }

    /**
     * Initializes the walls
     */
    public void initializeWalls(){
        verticalWalls = new Wall[9][8];

        double coordinationX;
        double coordinationY;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {

                coordinationX = 66.66666;
                coordinationY = 66.66666;

                coordinationX = (coordinationX + coordinationX * j) - 5;
                coordinationY = (coordinationY * i) - (i * 5);

                int resultX = (int) Math.round(coordinationX);
                int resultY = (int) Math.round(coordinationY);

                verticalWalls[i][j] = new Wall(j,i);
                verticalWalls[i][j].setDirection(WallDirection.VERTICAL);
                verticalWalls[i][j].setPlace(resultX,resultY);
                verticalWalls[i][j].setActionListener(this);

            }
        }

        horizontalWalls = new Wall[8][9];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {

                coordinationX = 66.66;
                coordinationY = 66.66;

                coordinationX = (coordinationX * j);
                coordinationY = (coordinationY + coordinationY * i) - (5 * ( i + 1 ));

                int resultX = (int) Math.round(coordinationX);
                int resultY = (int) Math.round(coordinationY);

                horizontalWalls[i][j] = new Wall(j,i);
                horizontalWalls[i][j].setDirection(WallDirection.HORIZONTAL);
                horizontalWalls[i][j].setPlace(resultX,resultY);
                horizontalWalls[i][j].setActionListener(this);

            }
        }

        addFieldsToWalls();

    }

    /**
     * Assigns fields to the walls that will block
     */
    public void addFieldsToWalls(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                verticalWalls[i][j].setBlocked1(gameField.getFieldByIndex( j , i ));
                verticalWalls[i][j].setBlocked2(gameField.getFieldByIndex( (j + 1) , i ));
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                horizontalWalls[i][j].setBlocked1(gameField.getFieldByIndex(j,i));
                horizontalWalls[i][j].setBlocked2(gameField.getFieldByIndex(j , ( i + 1 )));
            }
        }
    }

    /**
     * Displays a wall on the screen
     * @param wall
     */
    public void displayWall(JPanel wall){
        gameField.addWall(wall);
    }

    /**
     * Initializes the GameField
     * @param player1 Assigns GameField to player 1
     * @param player2 Assigns GameField to player 2
     */
    public void initializeGameField(Player player1, Player player2){
        gameField = new GameField(this);
        gameField.addPlayers(player1,player2);
        add(gameField);
    }

    /**
     * Hides the buttons for movement
     */
    public void hideHiddenMoveButtons(){

        for(int i = 0; i < indexShownButtons.size(); i++){
            int indexY = indexShownButtons.get(i)[0];
            int indexX = indexShownButtons.get(i)[1];
            hiddenButtons[indexY][indexX].setVisibleButton(false);
        }

    }

    /**
     * Adds a wall to the temporary arrayList
     * When the temporary ArrayList is of size two, the method performs a wall check
     * @param wall Added wall to temporary arrayList
     */
    public void addWallTemporary(Wall wall){
        temporaryWallPlace.add(wall);
        if(temporaryWallPlace.size() == 2){
            this.placeTemporaryWalls();
        }
    }

    /**
     * Check if the walls in the temporary arrayList are adjacent to each other
     * @return Returns true when they are next to each other and false when they are not next to each other
     */
    public boolean checkTemporaryWallArray(){
        if(temporaryWallPlace.get(0).getDirection() == temporaryWallPlace.get(1).getDirection()){

            WallDirection tempDirection = temporaryWallPlace.get(0).getDirection();

            switch (tempDirection){
                case HORIZONTAL:
                    if((temporaryWallPlace.get(0).getCoordinationX() + 1 == temporaryWallPlace.get(1).getCoordinationX() || temporaryWallPlace.get(0).getCoordinationX() - 1 == temporaryWallPlace.get(1).getCoordinationX())
                            && temporaryWallPlace.get(0).getCoordinationY() == temporaryWallPlace.get(1).getCoordinationY()){
                        addingToHorizontal = true;
                        return true;
                    }
                    break;
                case VERTICAL:
                    if((temporaryWallPlace.get(0).getCoordinationY() + 1 == temporaryWallPlace.get(1).getCoordinationY() || temporaryWallPlace.get(0).getCoordinationY() - 1 == temporaryWallPlace.get(1).getCoordinationY())
                            && temporaryWallPlace.get(0).getCoordinationX() == temporaryWallPlace.get(1).getCoordinationX()){
                        addingToHorizontal = false;
                        return true;
                    }
            }
        }
        return false;
    }

    /**
     * Creates a record of the addition of a new wall to the GameField and creates a graphic output on the screen
     */
    public void placeTemporaryWalls(){
        int[] coordinationOfPlacedWall1;
        int[] coordinationOfPlacedWall2;

        if(checkTemporaryWallArray()){

            temporaryWallPlace.get(0).setPlaced(true);
            coordinationOfPlacedWall1 = new int[]{temporaryWallPlace.get(0).getCoordinationX(),temporaryWallPlace.get(0).getCoordinationY()};

            temporaryWallPlace.get(1).setPlaced(true);
            coordinationOfPlacedWall2 = new int[]{temporaryWallPlace.get(1).getCoordinationX(),temporaryWallPlace.get(1).getCoordinationY()};

            if(addingToHorizontal){
                indexPlacedWallsHorizontal.add(coordinationOfPlacedWall1);
                indexPlacedWallsHorizontal.add(coordinationOfPlacedWall2);
            }else{
                indexPlacedWallsVertical.add(coordinationOfPlacedWall1);
                indexPlacedWallsVertical.add(coordinationOfPlacedWall2);
            }

            displayWall(gameField.createWallDisplay(temporaryWallPlace.get(0), temporaryWallPlace.get(1)));

            quoridor.getPlayerOnTurn().placeWall();

            quoridor.changePlayerOnTurn();
            gameField.changePlayerOnTurn();

            placeWalls(false);
        }

        temporaryWallPlace.remove(temporaryWallPlace.get(1));
        temporaryWallPlace.remove(temporaryWallPlace.get(0));
    }

    /**
     * Checks if there is a wall between fields start and end
     * @param start Field that player is standing on
     * @param end Field where player is going
     * @return returns true if there is wall
     * @return returns false if there is no wall
     */
    public boolean checkVerticalWallPlaced(Field start,Field end){
        for (int i = 0; i < indexPlacedWallsVertical.size(); i++) {
            if(     (verticalWalls[indexPlacedWallsVertical.get(i)[1]][indexPlacedWallsVertical.get(i)[0]].getBlocked1() == start
                    && verticalWalls[indexPlacedWallsVertical.get(i)[1]][indexPlacedWallsVertical.get(i)[0]].getBlocked2() == end )
                    ||
                    (verticalWalls[indexPlacedWallsVertical.get(i)[1]][indexPlacedWallsVertical.get(i)[0]].getBlocked2() == start
                    && verticalWalls[indexPlacedWallsVertical.get(i)[1]][indexPlacedWallsVertical.get(i)[0]].getBlocked1() == end)){
                return true;
            }
        }


        return false;
    }

    /**
     * Checks if there is a wall between fields start and end
     * @param start Field that player is standing on
     * @param end Field where player is going
     * @return returns true if there is wall
     * @return returns false if there is no wall
     */
    public boolean checkHorizontalWallPlaced(Field start, Field end){
        for (int i = 0; i < indexPlacedWallsHorizontal.size(); i++) {
            if(     (horizontalWalls[indexPlacedWallsHorizontal.get(i)[1]][indexPlacedWallsHorizontal.get(i)[0]].getBlocked1() == start
                    && horizontalWalls[indexPlacedWallsHorizontal.get(i)[1]][indexPlacedWallsHorizontal.get(i)[0]].getBlocked2() == end )
                    ||
                    (horizontalWalls[indexPlacedWallsHorizontal.get(i)[1]][indexPlacedWallsHorizontal.get(i)[0]].getBlocked2() == start
                    && horizontalWalls[indexPlacedWallsHorizontal.get(i)[1]][indexPlacedWallsHorizontal.get(i)[0]].getBlocked1() == end)){
                return true;
            }
        }

        return false;
    }

    /**
     * Shows options where the player can move
     * @param player The player for whom the options appear
     */
    public void showHiddenMoveButtons(Player player){
        int coordinationX = player.getCoordinationX();
        int coordinationY = player.getCoordinationY();

        int i = 1; // Helper variable

        if(coordinationX < hiddenButtons.length && coordinationY < hiddenButtons.length && coordinationX > -1 && coordinationY > -1){ // Check if coordinates are within the bounds of the game board

            if(coordinationY + 1 < hiddenButtons.length){ // Check move up (north)

                if(!checkHorizontalWallPlaced(gameField.getFieldByIndex(coordinationX,coordinationY),gameField.getFieldByIndex(coordinationX,coordinationY + 1))){

                    if(gameField.getFieldByIndex(coordinationX,coordinationY + 1).getPlayer() != null) i++; // If there's a player, increment i
                    if(coordinationY + i < hiddenButtons.length){

                        hiddenButtons[coordinationY + i][coordinationX].setVisibleButton(true);
                        int[] coordination = {coordinationY + i, coordinationX};
                        indexShownButtons.add(coordination);
                    }

                    i = 1;
                }

            }
            if(coordinationY - 1 > -1){ // Check move down (south)

                if(!checkHorizontalWallPlaced(gameField.getFieldByIndex(coordinationX,coordinationY),gameField.getFieldByIndex(coordinationX,coordinationY - 1))){

                    if(gameField.getFieldByIndex(coordinationX,coordinationY - 1).getPlayer() != null) i++; // If there's a player, increment i
                    if(coordinationY - i > -1) {

                        hiddenButtons[coordinationY - i][coordinationX].setVisibleButton(true);
                        int[] coordination = {coordinationY - i, coordinationX};
                        indexShownButtons.add(coordination);
                    }

                    i = 1;
                }

            }
            if(coordinationX + 1 < hiddenButtons.length){ // Check move right (east)

                if(!checkVerticalWallPlaced(gameField.getFieldByIndex(coordinationX,coordinationY),gameField.getFieldByIndex(coordinationX + 1,coordinationY))){

                    if(gameField.getFieldByIndex(coordinationX + 1,coordinationY).getPlayer() != null) i++; // If there's a player, increment i
                    if(coordinationX + i < hiddenButtons.length){

                        hiddenButtons[coordinationY][coordinationX + i].setVisibleButton(true);
                        int[] coordination = {coordinationY, coordinationX + i};
                        indexShownButtons.add(coordination);
                    }

                    i = 1;
                }

            }
            if(coordinationX - 1 > -1){ // Check move left (west)

                if(!checkVerticalWallPlaced(gameField.getFieldByIndex(coordinationX,coordinationY),gameField.getFieldByIndex(coordinationX-1,coordinationY))){

                    if(gameField.getFieldByIndex(coordinationX - 1,coordinationY).getPlayer() != null) i++; // If there's a player, increment i
                    if(coordinationX - i > -1){

                        hiddenButtons[coordinationY][coordinationX - i].setVisibleButton(true);
                        int[] coordination = {coordinationY, coordinationX - i};
                        indexShownButtons.add(coordination);
                    }
                }

            }
        }

    }

    /**
     * basic getter
     * @return
     */
    public GameField getGameField(){
        return this.gameField;
    }

    /**
     * Records which wall button has been pressed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean done = false;

        for (int i = 0; i < 8; i++) {

            if(done) break;

            for (int j = 0; j < 9; j++) {

                if(e.getSource() == horizontalWalls[i][j].getPlaceWall()) {
                    addWallTemporary(horizontalWalls[i][j]);
                    done = true;
                }

            }
        }

        for (int i = 0; i < 9; i++) {

            if(done) break;

            for (int j = 0; j < 8; j++) {

                if(e.getSource() == verticalWalls[i][j].getPlaceWall()) {

                    addWallTemporary(verticalWalls[i][j]);
                    done = true;

                }

            }
        }
    }

}
