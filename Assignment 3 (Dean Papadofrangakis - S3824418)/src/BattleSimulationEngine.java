import java.util.Random;
import java.util.Scanner;

public class BattleSimulationEngine
{
    /**
     * You are not allow to change to this class field.
     */
    private Random random = new Random();

    /**
     * You are not allow to change to this class field.
     */
    private boolean running = false;

    // Number of entities must not change
    private Entity [] entities = new Entity[8]; 

    /**
     * Further class fields can be added.
     */

    /**
     * You are allow to add to this method,
     * but it must do at least the current
     * functionality when you first download
     * this code.
     * 
     * That is, it must create four Ogres, add
     * them to entities array and execute the 
     * splashScreen
     */
    public void init()
    {
        entities[0] = new Ogre();
        entities[1] = new Ogre();
        entities[2] = new Ogre();
        entities[3] = new Ogre();

        entities[0].add(entities);
        entities[1].add(entities);
        entities[2].add(entities);
        entities[3].add(entities);        

        splashScreen();
    }

    /**
     * You are not allow to change to this method.
     */
    private void start()
    {
        running = true;

        update();
    }

    /**
     * You are allow to add to this method,
     * but it must do at least the current
     * functionality when you first download
     * this code.
     */
    private void update()
    {
        while(running)
        {
            allEntitiesAreOgre();

            int randomEntity;

            do
            {
                randomEntity = random.nextInt(entities.length);
            }
            while(entities[randomEntity] == null);

            //Checks if attacking entity is an Ogre
            if (randomEntity < 4){
                System.out.println("Ogre" + randomEntity + " is attacking!"); //Output attack message
            }

            entities[randomEntity].attack();            

            if(areAllEntitiesDead(entities))
            {
                running = false;
                gameOver();
            }
            else if(allEntitiesAreHero())
            {
                running = false;
                win();
            }

            sleep();
        }
    }

    /**
     * You are not allow to change to this method.
     */
    private void sleep()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            // Simply ignore interrupted exception
        }
    }

    /**
     * You are allowed to make style changes, but must be a game output.
     */
    private void gameOver()
    {
        System.out.println("\n");
        System.out.println("************************");
        System.out.println("*      GAME OVER       *");
        System.out.println("*                      *");
        System.out.println("************************");
    }
    /**
     * You are allowed to make style changes, but must be a win output.
     */
    private void win()
    {
        System.out.println("\n");
        System.out.println("************************");
        System.out.println("*         WIN          *");
        System.out.println("*                      *");
        System.out.println("************************");
    }

    /**
     * You are allowed to make style changes, but must be a splashScreen
     * and call to menu.
     */
    private void splashScreen()
    {
        System.out.println("*************************");
        System.out.println("*      Welcome to       *");
        System.out.println("*                       *");
        System.out.println("*   BATTLE SIMULATION   *");
        System.out.println("*************************");
        System.out.println("\n");

        menu();
    }

    /**
     * Add a menu interface
     * 
     * Add hero characters
     * Sort hero characters by health
     * Print here characters stats (name, health)
     * Run the simulation
     * Exit the simulation
     */
    private void menu(){
        
        // This method should be only called within the run simulation branch
        
        //Hero Creator Visual
        System.out.println("**************************");
        System.out.println("*      Hero Creator      *");
        System.out.println("**************************");
        
        //Variables (Order of Appearance)
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int spawnCount;
        int[] heroHealthArray;


        //Heroes
        //Prompting User
        while (n == 0)
        {
            System.out.print("Enter Number of Heroes (1-4): ");
        
            //Validating Entry
            while (!scanner.hasNextInt())
            {        
                scanner.next(); 
                System.out.print("Please enter an integer: "); 
            }

            //Enter Number of Desired Heroes
            spawnCount = scanner.nextInt(); 

            //Validate Entry is Between 1 and 4
            if (spawnCount > 4 || spawnCount < 1)
            {
                System.out.println("Please enter a number between 1 & 4");
            } 
            else 
            {

                //Create Heroes
                for (int i = 4; i < (spawnCount + 4); i++)
                {
                    entities[i] = new Hero();
                    entities[i].add(entities);
                }   
            
                //Creating Array for Hero Health
                heroHealthArray = new int[4];
                for (int i = 4; i < (spawnCount+4); i++)
                {
                heroHealthArray[i-4] = new Hero(entities[i]).health;
                }

                //Sorting Hero Health
                for (int i = 0; i < heroHealthArray.length - 1; i++)
                {
                    int index = i;  
                    for (int j = i + 1; j < heroHealthArray.length; j++)
                    {  
                        if (heroHealthArray[j] < heroHealthArray[index])
                        {  
                        index = j; //Searching for Lowest Value
                        }  
                    }  
                    int TemporaryPosition = heroHealthArray[index]; //Moving Value To Temporary Integer
                    heroHealthArray[index] = heroHealthArray[i];  //Swapping Values
                    heroHealthArray[i] = TemporaryPosition; //Input of Temporary Integer
                }  

                //Correct Hero Health According to Sorted Value
                for (int i = 0; i < (entities.length-4); i++)
                {
                entities[i+spawnCount].setHealth(heroHealthArray[i]);
                }

                //Hero Spawn Visual
                System.out.println("\n");
                System.out.println("**************************");
                System.out.println("*     Heroes Spawned     *");
                System.out.println("*                        *");
                System.out.println("*     + Items added      *");
                System.out.println("**************************");

                //Print Heroes with Sorted Health
                for (int i = 4; i < (entities.length); i++)
                {
                    if(entities[i] != null)
                    {
                        System.out.println(entities[i]);
                    }
                }

                //Simulation Start Visual
                System.out.println("\n");
                System.out.println("***************************");
                System.out.println("*     Simulation Start    *");
                System.out.println("***************************");  
                n = 1;  
                
            }         
        }
        scanner.close();
        start(); //Start Simulation
    }

    /**
     * You are not allow to change to this method.
     */
    private boolean areAllEntitiesDead(Entity[] entities)
    {
        for(Entity e: entities)
            if(!(e == null))
                return false;
        return true;
    }

    /**
     * You are not allow to change to this method.
     */
    private void allEntitiesAreOgre()
    {
        boolean searching = true;
        int search = 0;

        Ogre.setWeAreNotAlone(false);

        while(searching && search < entities.length)
        {
            if(entities[search] != null)
            {
                if(!(entities[search].team.equals("ogre")))
                {
                    Ogre.setWeAreNotAlone(true);
                    searching = false;
                }
            }
            search++;    
        }        
    }

    /**
     * You are not allow to change to this method.
     */
    private boolean allEntitiesAreHero()
    {
        for(Entity e: entities)
            if(e != null)
                if(!(e.team.equals("hero")))
                    return false;
        return true;       
    }
}
