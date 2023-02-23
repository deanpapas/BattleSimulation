public class Sword extends Item {
    
    //Sword Swing Counter
    private int swordCounter;

    //Add item to items array
    public void add(Item[] items)
    {
        this.items = items;
    }
    
    //Calculate if enough sword swings are left
    //Return updated damage
    public int applySwordBoost(int currentDamage)
    {
        swordCounter++;

        if (swordCounter < 5) //Limit number of Sword Swings
        {
            System.out.println("Sword Boost Used!!");
            System.out.println(5-swordCounter + " Sword Swings Left");
            return currentDamage*SWORDBOOST;
        } 
        else
        {
            System.out.println("The Sword is Broken!!");
            return currentDamage;
        }
    }

    @Override
    public int applyHealthBoost(int currentHealth) {
        return 0;
    }

    @Override
    public int applyArmourBoost() {
        return 0;
    }
    




    

}

