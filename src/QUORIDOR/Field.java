package QUORIDOR;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private Player player;
    private Color background;

    public Field() {

    }

    public void addPlayer(Player player){
        this.player = player;
    }

    public void removePlayer(){
        this.player = null;
    }

}
