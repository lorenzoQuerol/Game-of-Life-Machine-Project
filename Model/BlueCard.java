package Model;

public class BlueCard {
    public static final String[] BLUE = {"Lawsuit", "Tax Due", "Computer Repair", "Ski Accident", "Tip the Server", "F1 Race", "World Cup"};
    
    private String name;
    private String careerLink;
    
    public BlueCard (String n, String link) {
        this.name = n;
        this.careerLink = link;
    }
    
    public String getName() {
        return name;
    }

    public String getCareerLink() {
        return careerLink;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}
