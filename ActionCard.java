public class ActionCard {

    private String name;
    private int payAmount;
    
    public ActionCard (String n, int amount) {
        name = n;
        payAmount = amount;
    }

    public void checkActionCard (ActionDeck a) {
        switch (a.getCard()) {
            case 1:
                setName ("Collect from the Bank");
                switch (a.getAction("Collect from the Bank")) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
                break;

            case 2:
                setName ("Pay the Bank");
                switch (a.getAction("Collect from the Bank")) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
                break;

            case 3:
                setName ("Pay the Player");
                switch (a.getAction("Collect from the Bank")) {
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;

            case 4:
                setName ("Collect From a Player");
                switch (a.getAction("Collect from the Bank")) {
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
        }
    }

    public void setName (String n) {
        name = n;
    }

    public void setPayAmount (int a) {
        payAmount = a;
    }

    public String getName () {
        return name;
    }

    public int getPayAmount () {
        return payAmount;
    }

    public void displayActionCard () {

    }

    @Override
    public String toString () {
        return "Action Card: " + name + "\n" + "Amount: " + payAmount;
    }
}

