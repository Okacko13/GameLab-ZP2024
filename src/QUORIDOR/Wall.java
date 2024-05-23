package QUORIDOR;

public class Wall {

    private Enum direction;
    private Field blocked1;
    private Field blocked2;
    private boolean placed;

    public Wall() {
    }

    public void setBlocked1(Field blocked1) {
        this.blocked1 = blocked1;
    }

    public void setBlocked2(Field blocked2) {
        this.blocked2 = blocked2;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
}
