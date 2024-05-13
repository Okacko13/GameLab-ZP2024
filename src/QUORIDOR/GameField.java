package QUORIDOR;

public class GameField {


    private Field[][] fieldArray;

    public GameField() {

    }

    public void initializeFields(){
        fieldArray =  new Field[9][9];
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                fieldArray[i][j] = new Field();
            }
        }
    }
    public void addPlayers(Player player1, Player player2){
        fieldArray[0][4].addPlayer(player1);
        fieldArray[8][4].addPlayer(player2);
    }


}
