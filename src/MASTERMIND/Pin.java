package MASTERMIND;

import java.awt.*;

/**
 * Class for storing colour values
 */
public class Pin {

    private Color color;

    public Pin() {
    }

    public Color getColor() {
        return color;
    }

    /**
     * Assigns a color to the pin. If the input is null, it gives it the color pink.
     * @param color
     */
    public void setColor(Color color) {
        if(color != null){
            this.color = color;
        }else{
            this.color = Color.PINK;
        }

    }

}
