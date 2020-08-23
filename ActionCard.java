public class ActionCard {

    private String name;
    private int payAmount;
    
    public void checkActionCard (ActionDeck a) {
        switch (a.getCard()) {
            case 1:
                setName ("Collect from the Bank");
                switch (a.getAction("Collect from the Bank")) {
                    case 1:
                        setName ("Tax Refund");
                        setPayAmount (15000);
                        break;
                    case 2:                      
                        setName ("Sell an Item");
                        setPayAmount (7500);
                        break;
                    case 3:
                        setName ("Bonus Payday");
                        setPayAmount (20000);
                        break;
                    case 4:
                        setName ("Setup School");
                        setPayAmount (50000);
                        break;
                    case 5:
                        setName ("Write a Book");
                        setPayAmount (10000);
                        
                        break;
                }
                break;

            case 2:
                setName ("Pay the Bank");
                switch (a.getAction("Pay the Bank")) {
                    case 1:
                        setName ("Buy an Item");
                        setPayAmount (-10000);
                        break;
                    case 2:
                        setName ("Visit a Place");
                        setPayAmount (-25000);;
                        break;
                    case 3:
                        setName ("Hiking");
                        setPayAmount (-20000);
                        break;
                    case 4:
                        setName ("Watch a Show");
                        setPayAmount (-2500);
                        break;
                    case 5:
                        setName ("Win a Competition");
                        setPayAmount (-15000);  
                        break;
                    case 6:
                        setName ("Traffic Violation");
                        setPayAmount (-1000);
                        break;
                }
                break;

            case 3:
                setName ("Pay the Player");
                switch (a.getAction("Pay the Player")) {
                    case 1:
                        setName ("Lawsuit");
                        setPayAmount (-50000);
                        break;
                    case 2:
                        setName ("Christmas Bonus!");
                        setPayAmount (-25000);
                        break;
                }
                break;

            case 4:
                setName ("Collect From a Player");
                switch (a.getAction("Collect From a Player")) {
                    case 1:
                        setName ("File a Lawsuit");
                        setPayAmount (30000);
                        break;
                    case 2:
                        setName ("It's your Birthday!");
                        setPayAmount (15000); 
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

