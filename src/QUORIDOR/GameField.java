package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public void initializePanel(){
        setLayout(null);
        setBounds(0,0,600,562);
        setBackground(Color.BLACK);
    }

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


    public void addMoveButtonByIndex(int coordinationX,int coordinationY,HiddenMoveButton moveButton){
        fieldArray[coordinationY][coordinationX].addMoveButton(moveButton);
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

    public Field getFieldByIndex(int coordinationX, int coordinationY){
        return fieldArray[coordinationY][coordinationX];
    }
    public void changePlayerOnTurn(){
        if(firstPlayerOnTurn){
            setFirstPlayerOnTurn(false);
        } else {
            setFirstPlayerOnTurn(true);
        }
    }
    public void addWall(JPanel component){
        add(component,JLayeredPane.MODAL_LAYER);
    }
    public void removeComponent(JPanel component){
        remove(component);
    }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean operationDone = false;
        for (int i = 0; i < hiddenMoveButtons.length; i++) {
            if(operationDone)break;
            for (int j = 0; j < hiddenMoveButtons.length; j++) {

                if(!operationDone){

                    if(e.getSource().equals(hiddenMoveButtons[i][j].getHiddenButton())){

                        operationDone = true;
                        if(firstPlayerOnTurn){

                            fieldArray[player1.getCoordinationY()][player1.getCoordinationX()].removePlayer();

                            player1.moveCoordinationX(hiddenMoveButtons[i][j].getCoordinationX());
                            if(player1.moveCoordinationY(hiddenMoveButtons[i][j].getCoordinationY())) quoridor.setWin(true);


                            fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player1);
                            this.quoridor.setPlayer1(player1);

                            this.quoridor.changePlayerOnTurn();

                            setFirstPlayerOnTurn(false);

                        } else {
                            fieldArray[player2.getCoordinationY()][player2.getCoordinationX()].removePlayer();

                            player2.moveCoordinationX(hiddenMoveButtons[i][j].getCoordinationX());
                            if(player2.moveCoordinationY(hiddenMoveButtons[i][j].getCoordinationY())) quoridor.setWin(true);


                            fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player2);
                            this.quoridor.setPlayer2(player2);

                            this.quoridor.changePlayerOnTurn();

                            setFirstPlayerOnTurn(true);

                        }
                        gamePanel.hideHiddenMoveButtons();
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
