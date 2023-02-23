import java.util.Random;

public class Armour extends Item {

    //Add item to items Array
    public void add(Item[] items){
        this.items = items;
    }
    
    //Calculate ArmourBoost with 50/50 probability
    public int applyArmourBoost(){

        Random random = new Random();
        if (random.nextInt(2) == 1){
            System.out.println("Armour!");
            return ARMOURBOOST;
        } else { 
            return 0;
        }
        
    }

    @Override
    public int applySwordBoost(int currentDamage) {
        return 0;
    }

    @Override
    public int applyHealthBoost(int currentHealth) {
        return 0;
    }
    

}

