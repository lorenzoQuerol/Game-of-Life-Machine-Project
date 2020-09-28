package Model;

public class BlueCard {
    public static final String[] BLUE = {"Lawsuit", "Tax Due", "Computer Repair", "Ski Accident", "Tip the Server", "F1 Race", "World Cup"};
    
    private String name;
    private String careerLink;
    
    public BlueCard (String n, String link) {
        this.name = n;
        this.careerLink = link;
    }

    /**
     *  This returns the name of the blue card
     * @return name The name of the blue card
     */
    public String getName() {
        return name;
    }

    /**
     *  This returns the career that is linked to the blue card
     * @return name The career link of the blue card
     */
    public String getCareerLink() {
        return careerLink;
    }

    /**
     * Formats the output for a blue card.
     */
    @Override
    public String toString() {
        return "Name: " + name;
    }
}
