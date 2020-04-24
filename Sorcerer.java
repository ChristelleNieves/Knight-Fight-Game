// Name: Christelle Nieves

public class Sorcerer extends Enemy 
{
    // Sorcerer constructor
    public Sorcerer()
    {
        super();
        type = "Sorcerer";
        health = 8;
        attackDamage = 3;
        defeated = false;
    }

    // Return sorcerer attributes as a string.
    @Override
    public String toString()
    {
        return "Type: " + getType() + "\n" + "Health: " + getHealth() + "\n" + "Attack Damage: " + getAttackDamage();
    }

    // Return the amount of damage a sorcerer deals per turn.
    @Override
    public int fight()
    {
        return 3;
    }
}