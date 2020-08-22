public class ActionCard {

    private String name;
    private int payAmount;
    
    public void checkActionCard (ActionDeck a) {
        switch (a.getCard()) {
            case 1:
                setName ("Collect from the Bank");
                switch (a.getAction("Collect from the Bank")) {
                    case 1:
                        // (input value you want to set) call setName
                        break;
                    case 2:
                        // (input value you want to set)
                        break;
                    case 3:
                        // (input value you want to set)
                        break;
                    case 4:
                        // (input value you want to set)
                        break;
                    case 5:
                        // (input value you want to set)
                        break;
                }
                break;

            case 2:
                setName ("Pay the Bank");
                switch (a.getAction("Pay the Bank")) {
                    case 1:
                        // (input value you want to set)
                        break;
                    case 2:
                        // (input value you want to set)
                        break;
                    case 3:
                        // (input value you want to set)
                        break;
                    case 4:
                        // (input value you want to set)
                        break;
                    case 5:
                        // (input value you want to set)    
                        break;
                    case 6:
                        // (input value you want to set)
                        break;
                }
                break;

            case 3:
                setName ("Pay the Player");
                switch (a.getAction("Pay the Player")) {
                    case 1:
                        // (input value you want to set)
                        break;
                    case 2:
                        // (input value you want to set)
                        break;
                }
                break;

            case 4:
                setName ("Collect From a Player");
                switch (a.getAction("Collect From a Player")) {
                    case 1:
                        // (input value you want to set)
                        break;
                    case 2:
                        // (input value you want to set)
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

    public void displayCard () {
        System.out.println(getName());
        System.out.println(getPayAmount());
    }

    @Override
    public String toString () {
        return "Action Card: " + name + "\n" + "Amount: " + payAmount;
    }
}

