// Name: Christelle Nieves

public class Troll extends Enemy 
{
    // Troll constructor
    public Troll()
    {
        super();
        type = "Troll";
        health = 6;
        attackDamage = 2;
        defeated = false;
    }

    // Return the Troll attributes as a string.
    @Override
    public String toString()
    {
        return "Type: " + getType() + "\n" + "Health: " + getHealth() + "\n" + "Attack Damage: " + getAttackDamage();
    }

    // Return the amount of damage that a Troll deals per turn.
    @Override
    public int fight()
    {
        return 2;
    }
}