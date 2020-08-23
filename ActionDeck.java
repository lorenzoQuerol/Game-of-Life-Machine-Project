import java.util.Stack;

public class ActionDeck {
    
    private Stack<Integer> actionCardDeck;
    private int[] collectFromBank;
    private int[] payToBank;
    private int[] collectFromPlayer;
    private int[] payToPlayer;
    private static boolean isEmpty;

    public ActionDeck () {
        actionCardDeck = new Stack<Integer>();
        collectFromBank = new int[5];
        payToBank = new int[6];
        collectFromPlayer = new int[2];
        payToPlayer = new int[2];
        isEmpty = true;
    }

    /**
     * This randomly generates integers from 1 to 4 and puts it 
     * into a stack of 50 elements for reading later on.
     */
    public void generateNewActionDeck () {
        for (int i = 0; i < 50; i++) 
            actionCardDeck.push((int)(Math.random() * ((4-1) + 1) + 1)); 
    }

    /**
     * This assigns integer values for each type of action card and 
     * will be used in interpreting what kind of action card it will be.
     */
    public void assignActions () {
        for (int i = 0; i < 5; i++) 
            collectFromBank[i] = i+1;

        for (int i = 0; i < 6; i++) 
            payToBank[i] = i+1;
        
        for (int i = 0; i < 2; i++) 
            collectFromPlayer[i] = i+1;
        
        for (int i = 0; i < 2; i++) 
            payToPlayer[i] = i+1;
    }

    /**
     * This pops the stack and returns a value for interpreting 
     * the action card.
     * 
     * @return integer value of the topmost card of the stack
     */
    public int getActionCard () {
        return actionCardDeck.pop();
    }

    /**
     * 
     * @param n the name of the card's specific action
     * @return the integer value of that card's specific
     * action
     */
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

    /**
     * This checks if the Action Card deck is empty or not.
     * @param s stack
     * @return boolean value for when stack is empty or not 
     */
    private boolean isEmpty (Stack s) {
        return s.empty() ?  true : false;
    }

    @Override
    public String toString () {
        return "Current Stack: " + actionCardDeck;
    }

}