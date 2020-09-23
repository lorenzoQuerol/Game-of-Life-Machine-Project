package Model;

public abstract class Space {
    private int index;
    private String color;

    public Space (int index, String color) {
        this.index = index;
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public String getColor() {
        return color;
    }
}
