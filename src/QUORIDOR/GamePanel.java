package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameField gameField;
    private HiddenMoveButton[][] hiddenButtons;

    public GamePanel() {

    }

    public void initializePanel(int width, int height, int x, int y,Player player1, Player player2){
        setBounds(x,y,width,height);
        setBackground(Color.RED);

        setLayout(null);
        initializeButtons();
        initializeGameField(player1,player2);

        setVisible(true);
    }
    public void initializeButtons(){
        this.hiddenButtons = new HiddenMoveButton[9][9];
        for (int i = 0; i < hiddenButtons.length; i++) {
            for (int j = 0; j < hiddenButtons.length; j++) {
                hiddenButtons[i][j] = new HiddenMoveButton();
                add(hiddenButtons[i][j]);
            }
        }

    }

    public void initializeGameField(Player player1, Player player2){
        gameField = new GameField();

        gameField.addPlayers(player1,player2);

        add(gameField);

    }
    public void move(Player player){
        int coordinationX = player.getCoordinationX();
        int coordinationY = player.getCoordinationY();

        if(coordinationX < hiddenButtons.length && coordinationY < hiddenButtons.length && coordinationX > -1 && coordinationY > -1){

            if(coordinationY + 1 < hiddenButtons.length){
                hiddenButtons[coordinationY + 1][coordinationX].setVisibleButton(true);
            } if(coordinationY - 1 > -1){
                hiddenButtons[coordinationY - 1][coordinationX].setVisibleButton(true);
            } if(coordinationX + 1 < hiddenButtons.length){
                hiddenButtons[coordinationY][coordinationX + 1].setVisibleButton(true);
            } if(coordinationX - 1 > -1){
                hiddenButtons[coordinationY][coordinationX - 1].setVisibleButton(true);
            }

        }

    }

}
