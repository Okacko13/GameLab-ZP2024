package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private GameField gameField;
    private HiddenMoveButton[][] hiddenButtons;

    private ArrayList<int[]> indexShownButtons;

    public GamePanel() {
        initializeShownArray();
    }

    public void initializePanel(int width, int height, int x, int y,Player player1, Player player2){
        setBounds(x,y,width,height);
        setBackground(Color.RED);

        setLayout(null);
        initializeGameField(player1,player2);
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
    public void initializeShownArray(){
        this.indexShownButtons = new ArrayList<>();
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
