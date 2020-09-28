package Model;

public abstract class Space {
    private int index;
    private String color;

    /**
     *  This constructs the for the board.
     * @param index the index/position of the space on the board
     * @param color the color of the space on the board
     */
    public Space (int index, String color) {
        this.index = index;
        this.color = color;
    }

    /**
     *  This gets the index of the space.
     * @return the index of the space on the board
     */
    public int getIndex() {
        return index;
    }

    /**
     * This gets the color of the space.
     * @return the color of the space on the board
     */
    public String getColor() {
        return color;
    }
}
