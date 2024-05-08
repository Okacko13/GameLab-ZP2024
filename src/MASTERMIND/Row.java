package MASTERMIND;

public class Row {

    protected Pin[] pins;

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
    public void setPinByIndex(int i,Colors colors){

        switch (i){
            case 0:
                pins[0].setColor(colors);
                break;
            case 1:
                pins[1].setColor(colors);
                break;
            case 2:
                pins[2].setColor(colors);
                break;
            case 3:
                pins[3].setColor(colors);
                break;
        }

    }

    public Pin getPin(int index){
        return pins[index];
    }

    public boolean checkSameColorInRow(Row row){

        for (int i = 0; i < row.pins.length ; i++) {
            switch (i){
                case 0 :
                    if(row.getPin(i).getColor().equals(row.getPin(1).getColor()) || row.getPin(i).getColor().equals(row.getPin(2).getColor()) || row.getPin(i).getColor().equals(row.getPin(3).getColor())) return true;
                    break;
                case 1 :
                    if(row.getPin(i).getColor().equals(row.getPin(0).getColor()) || row.getPin(i).getColor().equals(row.getPin(2).getColor()) || row.getPin(i).getColor().equals(row.getPin(3).getColor())) return true;
                    break;
                case 2 :
                    if(row.getPin(i).getColor().equals(row.getPin(0).getColor()) || row.getPin(i).getColor().equals(row.getPin(1).getColor()) || row.getPin(i).getColor().equals(row.getPin(3).getColor())) return true;
                    break;
                case 3 :
                    if(row.getPin(i).getColor().equals(row.getPin(0).getColor()) || row.getPin(i).getColor().equals(row.getPin(1).getColor()) || row.getPin(i).getColor().equals(row.getPin(2).getColor())) return true;
                    break;
            }
        }

        return false;
    }
    public int numberOfColoredPins(Row row){
        int numberOfColoredPins = 0;

        for (int i = 0; i < pins.length; i++) {
            if(!row.getPin(i).getColor().equals(Colors.NONE)) numberOfColoredPins++;
        }

        return numberOfColoredPins;
    }

}
