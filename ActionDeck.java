import java.util.Stack;

public class ActionDeck {
    
    private Stack<Integer> actionCardDeck;
    private int[] collectFromBank;
    private int[] payToBank;
    private int[] collectFromPlayer;
    private int[] PayToPlayer;
    private static boolean isEmpty;

    public ActionDeck () {
        actionCardDeck = new Stack<Integer>();
        collectFromBank = new int[5];
        payToBank = new int[6];
        collectFromPlayer = new int[2];
        PayToPlayer = new int[2];
        isEmpty = true;
    }

    public void generateNewDeck () {
        for (int i = 0; i < 50; i++) 
            actionCardDeck.push((int)(Math.random() * ((4-1) + 1) + 1)); // generates random integers from 1 to 4 til it fills up to 50
    }

    public void generateActions () {
        for (int i = 0; i < 5; i++) 
            collectFromBank[i] = i+1;

        for (int i = 0; i < 6; i++) 
            payToBank[i] = i+1;
        

        for (int i = 0; i < 2; i++) 
            collectFromPlayer[i] = i+1;
        
        for (int i = 0; i < 2; i++) 
            PayToPlayer[i] = i+1;
    }

    public int getCard () {
        return actionCardDeck.pop();
    }
    
    public int getAction (String n) {
        int type = 0;
        switch (n) {
            case "Collect from the Bank":
                type = (int)((Math.random() * ((5-1) + 1) + 1));
                break;
                
            case "Pay the Bank":
                type = (int)((Math.random() * ((6-1) + 1) + 1));
                break;

            case "Pay the Player":
                type = (int)((Math.random() * ((2-1) + 1) + 1));
                break;

            case "Collect from a Player":
                type = (int)((Math.random() * ((2-1) + 1) + 1));
                break;
        }
            return type;
    }

    private boolean isEmpty (Stack s) {
        return s.empty() ?  true : false;
    }

    @Override
    public String toString () {
        return "Current Stack: " + actionCardDeck;
    }

}