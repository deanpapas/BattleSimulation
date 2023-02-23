public abstract class Item
{
    //Item Level Characteristics
    protected Item[] items;
    protected String name;

    //Values used to change boosots 
    protected final int SWORDBOOST = 2;
    protected final int ARMOURBOOST = 125;
    protected final int POTIONBOOST = 500;

    //Methods for Boosts
    public abstract int applySwordBoost(int currentDamage);
    public abstract int applyHealthBoost(int currentHealth);
    public abstract int applyArmourBoost();

    //Add method
    public abstract void add(Item[] items);



}
