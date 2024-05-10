package MASTERMIND;

import java.awt.*;

public class Pin {

    private Color color;

    public Pin() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if(color != null){
            this.color = color;
        }
    }

}
