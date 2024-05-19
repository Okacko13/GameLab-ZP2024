package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    private Player player1;
    private Player player2;
    private Field[][] fieldArray;

    public GameField() {
        initializePanel();
        initializeFields();
    }
    public void initializePanel(){
        setLayout(new GridLayout(9,9));
        setBounds(0,0,600,562);
        setBackground(Color.BLACK);
    }

    public void initializeFields(){
        fieldArray =  new Field[9][9];
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                fieldArray[i][j] = new Field(this);
                add(fieldArray[i][j]);
                fieldArray[i][j].setVisibility(true);
            }
        }
    }
    public void setVisibleField(boolean bool){
        setVisible(bool);
    }
    public void addPlayers(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        fieldArray[0][4].addPlayer(player1);
        fieldArray[8][4].addPlayer(player2);
    }
    public void movePlayer(int coordinationX, int coordinationY, boolean player1){
        if(player1){
            this.player1.setCoordinationX(coordinationX);
            this.player1.setCoordinationY(coordinationY);
        }else if(!player1){
            this.player2.setCoordinationX(coordinationX);
            this.player2.setCoordinationY(coordinationY);
        }
    }
    public Field getFieldByIndex(int indexY,int indexX){
        return fieldArray[indexY][indexX];
    }
    public int getLenght(){
        return fieldArray.length;
    }

    public Player getPlayer1(){
        return this.player1;
    }
    public Player getPlayer2(){
        return this.player2;
    }

}
