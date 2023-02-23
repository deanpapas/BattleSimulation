/**
 * You are not allowed to change to this file.
 */
public abstract class Entity
{
    protected Entity[] entities;
    protected int health;
    protected String team;

    protected final int DAMAGE = 250;

    public abstract void attack();

    public abstract void add(Entity[] entities);    

    public void setTeam(String team)
    {
        this.team = team;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }

}
