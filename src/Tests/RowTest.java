package Tests;

import MASTERMIND.Pin;
import MASTERMIND.Row;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    private Pin pin1;
    private Pin pin2;
    private Pin pin3;
    private Row row;


    @org.junit.jupiter.api.Test
    void setPinByIndex() {
        row = new Row();

        row.setPinByIndex(0,Color.MAGENTA);
        row.setPinByIndex(1,Color.CYAN);
        row.setPinByIndex(2,Color.YELLOW);
        row.setPinByIndex(3,Color.BLACK);

        assertEquals(Color.MAGENTA,row.getPin(0).getColor());
        assertEquals(Color.CYAN,row.getPin(1).getColor());
        assertEquals(Color.YELLOW,row.getPin(2).getColor());
        assertEquals(Color.BLACK,row.getPin(3).getColor());
    }

    @org.junit.jupiter.api.Test
    void getPin() {
        row = new Row();

        row.setPinByIndex(0,Color.RED);
        row.setPinByIndex(1,Color.GREEN);
        row.setPinByIndex(2,Color.BLUE);

        pin1 = row.getPin(0);

        pin2 = row.getPin(1);

        pin3 = row.getPin(2);

        assertEquals(pin1,row.getPin(0));
        assertEquals(pin2,row.getPin(1));
        assertEquals(pin3,row.getPin(2));

    }

    @org.junit.jupiter.api.Test
    void numberOfColoredPins() {
        row = new Row();

        row.setPinByIndex(0,null);
        row.setPinByIndex(1,Color.LIGHT_GRAY);
        row.setPinByIndex(2,Color.GRAY);
        row.setPinByIndex(3,Color.DARK_GRAY);

        assertEquals(3,row.numberOfColoredPins(row));

    }
}