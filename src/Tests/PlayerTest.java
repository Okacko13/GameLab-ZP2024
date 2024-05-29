package Tests;

import QUORIDOR.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @Test
    void moveCoordinationX() {

        ArrayList<int[]> finalDestinations = new ArrayList<>();
        int[] coordination = new int[]{0,0};
        finalDestinations.add(coordination);

        int coordinationX = 5;
        int coordinationY = 5;

        player = new Player(Color.BLACK,coordinationX,coordinationY,finalDestinations);

        player.moveCoordinationX(9);
        assertEquals(coordinationX,player.getCoordinationX());

        player.moveCoordinationX(6);
        assertEquals(6,player.getCoordinationX());

    }
}