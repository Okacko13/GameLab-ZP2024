package MASTERMIND;

public class Row {

    private Pin[] pins;

    public Row() {
        initializePins();
    }

    public void setAllPins(Colors colors1, Colors colors2, Colors colors3, Colors colors4) {

        pins[0].setColor(colors1);
        pins[1].setColor(colors2);
        pins[2].setColor(colors3);
        pins[3].setColor(colors4);

    }

    public void initializePins(){
        pins = new Pin[4];

        for (int i = 0; i < pins.length; i++) {
            pins[i] = new Pin();
        }

    }

    public void setPinOne(Colors color){
        pins[0].setColor(color);
    }
    public void setPinTwo(Colors color){
        pins[1].setColor(color);
    }
    public void setPinThree(Colors color){
        pins[2].setColor(color);
    }
    public void setPinFour(Colors color){
        pins[3].setColor(color);
    }

}
