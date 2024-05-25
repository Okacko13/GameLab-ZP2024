package QUORIDOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameField extends JPanel implements ActionListener {

    private boolean firstPlayerOnTurn;
    private Player player1;
    private Player player2;
    private Field[][] fieldArray;
    private Quoridor quoridor;
    private HiddenMoveButton[][] hiddenMoveButtons;
    private GamePanel gamePanel;


    public GameField(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
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
                            player1.moveCoordinationY(hiddenMoveButtons[i][j].getCoordinationY());

                            fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player1);
                            this.quoridor.setPlayer1(player1);

                            this.quoridor.setPlayerOnTurn(player2);

                            setFirstPlayerOnTurn(false);

                        } else {
                            fieldArray[player2.getCoordinationY()][player2.getCoordinationX()].removePlayer();

                            player2.moveCoordinationX(hiddenMoveButtons[i][j].getCoordinationX());
                            player2.moveCoordinationY(hiddenMoveButtons[i][j].getCoordinationY());

                            fieldArray[hiddenMoveButtons[i][j].getCoordinationY()][hiddenMoveButtons[i][j].getCoordinationX()].addPlayer(player2);
                            this.quoridor.setPlayer2(player2);

                            this.quoridor.setPlayerOnTurn(player1);

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
