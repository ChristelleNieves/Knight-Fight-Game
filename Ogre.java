// Name: Christelle Nieves

public class Ogre extends Enemy 
{
    // Ogre constructor
    public Ogre()
    {
        super();
        type = "Ogre";
        health = 10;
        attackDamage = 4;
        defeated = false;
    }

    // Return Ogre attributes as a string.
    @Override
    public String toString()
    {
        return "Type: " + getType() + "\n" + "Health: " + getHealth() + "\n" + "Attack Damage: " + getAttackDamage();
    }

    // Return the amount of damage an Ogre deals per turn.
    @Override
    public int fight()
    {
        return 4;
    }
}