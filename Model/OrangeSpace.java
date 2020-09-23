package Model;

public class OrangeSpace extends Space {
    private String orangeDescription = "You landed on an orange space! Draw an Action Card!";

    public OrangeSpace (int index){
        super(index, "orange");
    }

    @Override
    public String toString() {
        return this.orangeDescription;
    }
}
