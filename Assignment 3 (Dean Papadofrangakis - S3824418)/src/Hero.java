import java.util.Random;

public class Hero extends Entity{
    
    //Variables
    protected Item[] items;
    private String name;
    private static int heroNameCounter ;
    private Random random;

    public Hero(){

        //Hero Characteristics
        random = new Random();
        this.name = "Hero" + heroNameCounter++;
        this.health =  (int)Math.floor(Math.random()*(500-150+1)+150);
        this.team  ="hero";

        //Creating Hero Items
        items = new Item[3];
        items[0] = new Sword();
        items[0].add(items);
        items[1] = new Armour();
        items[1].add(items);
        items[2] = new Potion();
        items[2].add(items);

    }

    //Copy Constructor
    public Hero(Entity hero) {
        this.name = ((Hero)hero).getName();
        this.health = hero.health;
    }

    //Add entity to entity array
    public void add(Entity [] entities)
    {
        this.entities = entities;
    }

    //Attack AI for Heroes
    public void attack(){

        //Variables
        int newDamage = 250;
        int attackIndex = 0;
        int randomSelection = random.nextInt(entities.length);

        //Attack Message
        System.out.println(name + " is attacking!");

        //Algorithm to Find currently attacking Hero
        for (int i = 0; i < 4; i++){
            if (name.equals("Hero" + i)){
                attackIndex = i+4; //Save Index for future use
            }
        }

        //Apply HealthBoost
        if (entities[attackIndex].getHealth() < 200)
                {
                        entities[attackIndex].setHealth(items[2].applyHealthBoost(entities[attackIndex].getHealth()));
                        System.out.println("Potion Used!");
                }

        //Apply Damage Boost
        newDamage = items[0].applySwordBoost(entities[attackIndex].DAMAGE);

        //Regular Attack AI
        //Same as Ogre without the ability to attack entities on the same team
        do
        {
            randomSelection = random.nextInt(entities.length);
        }
        while(entities[randomSelection] == null || entities[randomSelection].team.equals(team));
    
        entities[randomSelection].setHealth(entities[randomSelection].getHealth() - newDamage);

        System.out.println(entities[randomSelection]);

        if(entities[randomSelection].getHealth() <= 0)
        {
            entities[randomSelection] = null;
        }

}

    public String toString(){
        //Apply Armour Boost when Attacked
        this.health = this.health + items[1].applyArmourBoost();
        return name + " has this much health: " + health;
    }

   public String getName()
   {
        return this.name;
    }

    public int getHealth()
    {
        return this.health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }
    
}

