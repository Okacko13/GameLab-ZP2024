package MASTERMIND;

import javax.swing.*;
import java.awt.*;

/**
 * Class to store pins in a group
 */
public class Row {
    private JPanel rowPanel;
    private JPanel[] pinDisplays;
    protected Pin[] pins;
    private JPanel[] checkDisplays;

    public Row() {
        initializePins();
    }

    /**
     * Initializes Pins
     */
    public void initializePins(){
        pins = new Pin[4];

        for (int i = 0; i < pins.length; i++) {
            pins[i] = new Pin();
        }

    }

    /**
     * Sets the pin color according to the specified index
     * @param i Index of the pin to which the color is assigned
     * @param color The colour that is stored in the pin
     */
    public void setPinByIndex(int i, Color color){

        switch (i){
            case 0:
                pins[0].setColor(color);
                break;
            case 1:
                pins[1].setColor(color);
                break;
            case 2:
                pins[2].setColor(color);
                break;
            case 3:
                pins[3].setColor(color);
                break;
        }

    }

    /**
     * Basic pin getter
     * @param index
     * @return
     */
    public Pin getPin(int index){
        return pins[index];
    }

    /**
     * Checks if there are not two of the same colour in a row
     * @param row Row that is controlled
     * @return Returns true or false depending on whether some colors are the same
     */
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

    /**
     * Calculates how many real colors are specified
     * @param row Row that is controlled
     * @return Returns the number of pins with color
     */
    public int numberOfColoredPins(Row row){
        int numberOfColoredPins = 0;

        for (int i = 0; i < pins.length; i++) {
            if(!row.getPin(i).getColor().equals(Color.PINK)) numberOfColoredPins++;
        }

        return numberOfColoredPins;
    }

    /**
     * Basic getter
     * @return
     */
    public JPanel getRowPanel(){
        return rowPanel;
    }

    /**
     * Creates a graphical transfer for the player
     * @param indexOfRow Determine how high the row will be
     */
    public void createVisibleRow(int indexOfRow){

        initializeRowPanel(getHeightByIndex(indexOfRow));
        initializeCheckPanels();

        for (int i = 0; i < pinDisplays.length; i++) {
            rowPanel.add(pinDisplays[i]);
            rowPanel.add(checkDisplays[i]);
        }
        setCheckDisplaysColor(Color.DARK_GRAY);
        rowPanel.setVisible(true);
    }

    /**
     * Initializes the panel to display the row
     * @param height Determine how high the row will be
     */
    public void initializeRowPanel(int height){

        rowPanel= new JPanel();
        rowPanel.setBounds(0,height,750,20);
        rowPanel.setBackground(Color.DARK_GRAY);
        rowPanel.setLayout(null);

    }

    /**
     * Initializes the panel to display the colored pins
     */
    public void initializePinDisplays(){
        pinDisplays = new JPanel[4];

        for (int i = 0; i < pinDisplays.length; i++) {
            pinDisplays[i] = new JPanel();
            pinDisplays[i].setSize(20,20);
            pinDisplays[i].setVisible(false);

        }

    }

    /**
     * Sets the pin display locations
     */
    public void setLocationPinDisplays(){

        pinDisplays[0].setLocation(37,0);
        pinDisplays[1].setLocation(131,0);
        pinDisplays[2].setLocation(224,0);
        pinDisplays[3].setLocation(318,0);

    }

    /**
     * sets the visibility of the pins
     * @param bool
     */
    public void setVisiblePinDisplay(boolean bool){

        for (int i = 0; i < pinDisplays.length; i++) {
            pinDisplays[i].setVisible(bool);
        }
    }

    /**
     * basic setter
     * @param index
     * @param color
     */
    public void setPinDisplaysColor(int index,Color color){

        pinDisplays[index].setBackground(color);

    }

    /**
     * Returns the height according to the order of the row
     * @param index Row index
     * @return returns a number for the y-coordinate at which the row view will be located
     */
    public int getHeightByIndex(int index){

        switch (index){

            case 0: return 470;
            case 1: return 425;
            case 2: return 380;
            case 3: return 335;
            case 4: return 290;
            case 5: return 245;
            case 6: return 200;
            case 7: return 155;
            case 8: return 110;
            case 9: return 65;

        }

        return 0;
    }

    /**
     * Inicializes panels for feedback dots
     */
    public void initializeCheckPanels(){
        checkDisplays = new JPanel[4];
        for(int i = 0; i <checkDisplays.length; i++){
            checkDisplays[i] = new JPanel();
            checkDisplays[i].setSize(20,20);
            checkDisplays[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
            checkDisplays[i].setVisible(true);
        }

        checkDisplays[0].setLocation(505,0);
        checkDisplays[1].setLocation(545,0);
        checkDisplays[2].setLocation(585,0);
        checkDisplays[3].setLocation(625,0);

    }

    /**
     * Sets the colours to display
     * @param color The colour that will be seen on the screen
     */
    public void setCheckDisplaysColor(Color color){
        for (int i = 0; i < checkDisplays.length; i++) {
            checkDisplays[i].setBackground(color);
        }
    }

    /**
     * Checks if the pins in the rows are the same
     * @param row Compared row
     * @return Returns true or false depending on whether the pins are the same
     */
    public boolean hasRowSimilarPins(Row row){

        if(this.pins[0].getColor().equals(row.getPin(0).getColor()) && this.pins[1].getColor().equals(row.getPin(1).getColor()) && this.pins[2].getColor().equals(row.getPin(2).getColor()) && this.pins[3].getColor().equals(row.getPin(3).getColor())) {

            setCheckDisplaysColor(Color.GREEN);
            return true;
        }

        return false;
    }

    /**
     * Generates the resulting feedback for the player who types
     * @param row Row that is controlled
     */
    public void check(Row row){
        boolean isColored;

        for (int i = 0; i < pins.length; i++) {

            isColored = false;

            for(int j = 0; j < pins.length; j++){

                if(pins[i].getColor() == row.pins[j].getColor()){
                    if(i == j){
                        checkDisplays[i].setBackground(Color.GREEN);
                    } else {
                        checkDisplays[i].setBackground(Color.BLUE);
                    }
                    isColored = true;
                    break;
                }

            }
            if(!isColored){
                checkDisplays[i].setBackground(Color.RED);
            }
        }

    }

}
