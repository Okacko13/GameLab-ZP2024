package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private GameField gameField;
    private HiddenMoveButton[][] hiddenButtons;
    private ArrayList<int[]> indexShownButtons = new ArrayList<>();
    private Wall[][] horizontalWalls;
    private Wall[][] verticalWalls;

    public GamePanel() {
    }

    public void initializePanel(int width, int height, int x, int y,Player player1, Player player2){
        setBounds(x,y,width,height);
        setBackground(Color.RED);
        setLayout(null);

        initializeGameField(player1,player2);
        initializeButtons();
        initializeWalls();

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

    public void initializeWalls(){
        verticalWalls = new Wall[9][8];

        double coordinationX;
        double coordinationY;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {

                coordinationX = 66.66;
                coordinationY = 66.66;

                coordinationX = (coordinationX + coordinationX * j) - 5;
                coordinationY = (coordinationY * i) - (i * 5);

                int resultX = (int) Math.round(coordinationX);
                int resultY = (int) Math.round(coordinationY);

                verticalWalls[i][j] = new Wall();
                verticalWalls[i][j].setDirection(WallDirection.VERTICAL);
                verticalWalls[i][j].setPlace(resultX,resultY);
                add(verticalWalls[i][j]);

            }
        }

        horizontalWalls = new Wall[8][9];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {

                coordinationX = 66.66;
                coordinationY = 66.66;

                coordinationX = (coordinationX * j);
                coordinationY = (coordinationY + coordinationY * i) - (5 * ( i+ 1 ));

                int resultX = (int) Math.round(coordinationX);
                int resultY = (int) Math.round(coordinationY);

                horizontalWalls[i][j] = new Wall();
                horizontalWalls[i][j].setDirection(WallDirection.HORIZONTAL);
                horizontalWalls[i][j].setPlace(resultX,resultY);
                add(horizontalWalls[i][j]);

            }
        }

        addFieldsToWalls();
    }
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
    public void setVisibleWalls(boolean bool){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if(!horizontalWalls[i][j].isPlaced()){
                    horizontalWalls[i][j].visibleWall(bool);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                verticalWalls[i][j].visibleWall(bool);
            }
        }
        setVisible(false);
        setVisible(true);

    }

    public void initializeGameField(Player player1, Player player2){
        gameField = new GameField(this);

        gameField.addPlayers(player1,player2);

        add(gameField);

    }
    public void hideHiddenMoveButtons(){

        for(int i = 0; i < indexShownButtons.size(); i++){

            int indexY = indexShownButtons.get(i)[0];
            int indexX = indexShownButtons.get(i)[1];

            hiddenButtons[indexY][indexX].setVisibleButton(false);
        }

    }
    public void synchronizeHidden(HiddenMoveButton[][] hiddenButtons){
        this.hiddenButtons = hiddenButtons;
    }

    public void showHiddenMoveButtons(Player player){

        int coordinationX = player.getCoordinationX();
        int coordinationY = player.getCoordinationY();

        int i = 1;

        if(coordinationX < hiddenButtons.length && coordinationY < hiddenButtons.length && coordinationX > -1 && coordinationY > -1){

            if(coordinationY + 1 < hiddenButtons.length){

                if(gameField.getFieldByIndex(coordinationX,coordinationY + 1).getPlayer() != null) i++;

                if(coordinationY + i < hiddenButtons.length){

                    hiddenButtons[coordinationY + i][coordinationX].setVisibleButton(true);
                    int[] coordination = {coordinationY + i, coordinationX};
                    indexShownButtons.add(coordination);


                }

                i = 1;
            }
            if(coordinationY - 1 > -1){

                if(gameField.getFieldByIndex(coordinationX,coordinationY - 1).getPlayer() != null) i++;

                if(coordinationY - i > -1) {

                    hiddenButtons[coordinationY - i][coordinationX].setVisibleButton(true);
                    int[] coordination = {coordinationY - i, coordinationX};
                    indexShownButtons.add(coordination);
                }

                i = 1;
            }
            if(coordinationX + 1 < hiddenButtons.length){

                if(gameField.getFieldByIndex(coordinationX + 1,coordinationY).getPlayer() != null) i++;

                if(coordinationX + i < hiddenButtons.length){

                    hiddenButtons[coordinationY][coordinationX + i].setVisibleButton(true);
                    int[] coordination = {coordinationY, coordinationX + i};
                    indexShownButtons.add(coordination);

                }

                i = 1;
            }
            if(coordinationX - 1 > -1){

                if(gameField.getFieldByIndex(coordinationX - 1,coordinationY).getPlayer() != null) i++;

                if(coordinationX - i > -1){

                    hiddenButtons[coordinationY][coordinationX - i].setVisibleButton(true);
                    int[] coordination = {coordinationY, coordinationX - i};
                    indexShownButtons.add(coordination);

                }

            }
        }
    }

    public GameField getGameField(){
        return this.gameField;
    }

}
