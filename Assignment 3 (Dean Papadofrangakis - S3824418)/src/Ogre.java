/**
 * You are not allowed to change to this file.
 */
import java.util.Random;

public class Ogre extends Entity
{
    private static boolean weAreNotAlone = false;
    private static int nameCounter;
    private String name;
    private Random random;    

    public Ogre()
    {
        name = "Ogre" + nameCounter++;

        random = new Random();

        this.health = 1000;
        this.team = "ogre";
    }

    public void add(Entity [] entities)
    {
        this.entities = entities;
    }

    public void attack()
    {
        int randomSelection = random.nextInt(entities.length);

        if(weAreNotAlone)
        {
            do
            {
                randomSelection = random.nextInt(entities.length);
            }
            while(entities[randomSelection] == null || entities[randomSelection].team.equals(team));
        }
        else
        {
            do
            {
                randomSelection = random.nextInt(entities.length);
            }
            while(entities[randomSelection] == null);
        }

        entities[randomSelection].setHealth(
            entities[randomSelection].getHealth() - DAMAGE);

        System.out.println(entities[randomSelection]);

        if(entities[randomSelection].getHealth() <= 0)
        {
            entities[randomSelection] = null;
        }
        
    }
	
	public static void setWeAreNotAlone(boolean weAreNotAlone)
    {
        Ogre.weAreNotAlone = weAreNotAlone;
    }
    
    public String toString()
    {
        return name + " has this much health: " + health;
    }
}
