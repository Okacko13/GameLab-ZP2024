package Tests;

import FRAME_COMPONENTS.TextPanel;
import QUORIDOR.Player;
import QUORIDOR.Quoridor;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class QuoridorTest {

    @Test
    void changePlayerOnTurn() {
        Quoridor quoridor = new Quoridor();

        Player player1 = new Player(Color.MAGENTA,2,2,quoridor.getFinalDestinationsPlayer1());
        Player player2 = new Player(Color.BLUE,6,1,quoridor.getFinalDestinationsPlayer2());

        quoridor.setPlayer1(player1);
        quoridor.setPlayer2(player2);

        TextPanel textPanel = new TextPanel();
        quoridor.setTextPanel(textPanel);

        boolean player1OnTurn;

        if(quoridor.getPlayerOnTurn() == player1){
            player1OnTurn = true;
        } else {
            player1OnTurn = false;
        }

        if(player1OnTurn){
            quoridor.changePlayerOnTurn();

            assertEquals(player2,quoridor.getPlayerOnTurn());

        } else {
            quoridor.changePlayerOnTurn();

            assertEquals(player1,quoridor.getPlayerOnTurn());

        }
    }
}