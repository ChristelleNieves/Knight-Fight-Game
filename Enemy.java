// Name: Christelle Nieves

import java.util.Random;

public abstract class Enemy
{
    String type;
    int health;
    int attackDamage;
    boolean defeated;

    // TakeDamage will subtract the damage taken from the health of the enemy.
    public void takeDamage(int damage) throws NegativeDamageException
    {
        // If we get a negative number for damage we will throw the exception.
        if (damage < 0)
        {
            throw new NegativeDamageException();
        }
        else
        {
            // Subtract the damage from the health.
            this.health = this.health - damage;
        }

        // If the health reaches zero or less, the enemy has been defeated.
        if (this.health <= 0)
        {
            defeated = true;
        }
    }

    // Set the type of enemy (Ogre, Sorcerer, Troll)
    public void setType(String type)
    {
        this.type = type;
    }

    // Return the enemy type
    public String getType()
    {
        return this.type;
    }

    // Set the amount of damage the enemy can deal per turn.
    public void setAttackDamage(int damage)
    {
        this.attackDamage = damage;
    }

    // Return the enemy attack damage
    public int getAttackDamage()
    {
        return this.attackDamage;
    }

    // Set the defeated attribute
    public void setDefeated(boolean defeated)
    {
        this.defeated = defeated;
    }

    // Return whether the enemy has been defeated or not
    public boolean getDefeated()
    {
        return this.defeated;
    }

    // Set the health of the enemy.
    public void setHealth(int health)
    {
        this.health = health;
    }

    // Return the health of the enemy.
    public int getHealth()
    {
        return this.health;
    }

    // Return a randomly generated Enemy object instantiated from one of the subclasses.
    public static Enemy getRandomEnemy()
    {
        Random rand = new Random();
        int enemyType = rand.nextInt(3);

        if (enemyType == 1)
        {
            return new Ogre();
        }
        else if (enemyType == 2)
        {
            return new Sorcerer();
        }
        else 
        {
            return new Troll();
        }
    }

    // toString method must be overridden by subclasses.
    public abstract String toString();

    // Fight method must be overridden by subclasses and returns an int for damage.
    public abstract int fight();
}