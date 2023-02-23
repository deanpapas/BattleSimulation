public class Potion extends Item {

    //Potion Use Counter
    private int potionCounter = 0;

    //Add item to items array
    public void add(Item[] items){
        this.items = items;
    }

    //Calculate amount of health boost given
    public int applyHealthBoost(int currentHealth){

        if (potionCounter < 1) //Limit number of potion uses
        {
            potionCounter++;
            return POTIONBOOST;
        } 
        else
        {
            System.out.println("Potion Bottle Empty!!");
            return currentHealth;
        }

    }

    @Override
    public int applySwordBoost(int currentDamage) {
        return 0;
    }

    @Override
    public int applyArmourBoost() {
        return 0;
    }
    
}
