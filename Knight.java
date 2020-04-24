// Name: Christelle Nieves

import java.util.Random;

public class Knight
{
    String name;
    String weapon;
    String armorType;
    int health;

    // Create a Knight object with a user-set name and random attributes.
    public Knight(String name)
    {
        setName(name);
        Random random = new Random();
        setWeapon(random.nextInt(3) + 1);
        setArmorType(random.nextInt(2) + 1);
        sethealth();
    }

    // Set knight name
    public void setName(String name)
    {
        this.name = name;
    }

    // Get knight name
    public String getName()
    {
        return this.name;
    }

    // Set knight weapon according to user's menu choice
    public void setWeapon(int choice)
    {
        switch (choice)
        {
            case 1:
                this.weapon = "Long Sword";
                break;
            case 2:
                this.weapon = "Battle Axe";
                break;
            case 3:
                this.weapon = "Spear";
                break;
            case 4:
                this.weapon = "Warhammer";
                break;
            default:
                break;
        }
    }

    // Get knight weapon
    public String getWeapon()
    {
        return this.weapon;
    }

    // Set knight armor type according to the user's menu choice.
    public void setArmorType(int choice)
    {
        switch (choice)
        {
            case 1:
                this.armorType = "Leather";
                break;
            case 2:
                this.armorType = "Steel";
                break;
            case 3:
                this.armorType = "Cloth";
                break;
            default:
                break;
        }
    }

    // Get knight armor type
    public String getArmorType()
    {
        return this.armorType;
    }

    // Set knight health as a randomized int
    public void sethealth()
    {
        Random random = new Random();
        this.health = random.nextInt(15) + 15; // Set health to a random value between 15 and 30
    }

    // Set knight health to an int parameter
    public void sethealth(int health)
    {
        this.health = health;
    }

    // Get remaining knight health
    public int gethealth()
    {
        return this.health;
    }

    // Returns attributes as a string.
    public String toString()
    {
        String stats = "Name: " + name + "\nWeapon: " + weapon + "\nArmor Type: " + armorType + "\nhealth: " + health;
        return stats;
    }

    // This function sets damage dealt according to weapon type and armor type of the opponent.
    public int attackDamage()
    {
        int damageDealt = 0;

        // Set the damage dealt according to the Knight's weapon type.
        if (weapon.equals("Long Sword"))
        {
            damageDealt = 4;
        }
        else if (weapon.equals("Battle Axe"))
        {
            damageDealt = 3;
        }
        else if (weapon.equals("Spear"))
        {
            damageDealt = 2;
        }
        else if (weapon.equals("Warhammer"))
        {
            damageDealt = 1;
        }

        // Return the damage that the player dealt to the opponent.
        return damageDealt;
    }

    public void takeDamage(int dmg)
    {
        this.health -= dmg;
    }
}