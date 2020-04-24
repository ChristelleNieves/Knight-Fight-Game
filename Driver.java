// Name: Christelle Nieves
// Program Description: A text-based fight game in which a user plays as a Knight against auto
// generated enemies

import java.util.Scanner;
import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args) throws NegativeDamageException
    {
        String exit = "n";
        Knight player;
        Scanner in = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to KnightFight!!");

        // Keep accepting input until the user enters "y" to exit the program
        while (exit.equals("n"))
        {
            // Get the name of the player
            System.out.print("\nEnter the name of your Knight: ");
            String name = in.next();

            // Create the player Knight with the inputs from the user.
            player = new Knight(name);

            System.out.print("\nHow many enemies does your knight see? ");
            int numEnemies = in.nextInt();

            // Create the arraylist of enemies
            ArrayList<Enemy> allEnemies = new ArrayList<Enemy>();

            // Add enemies to the arraylist
            for (int i = 0; i < numEnemies; i++)
            {
                allEnemies.add(Enemy.getRandomEnemy());
            }

            int playerDamageDealt = 0;
            int numTurns = 0;

            // Display starting stats for the Knight
            System.out.println("\nStarting stats for your Knight: ");
            System.out.println();
            System.out.println(player.toString());

            // Display starting stats for all enemies
            System.out.println("\nStarting stats for all enemies: ");
            for (int i = 0; i < allEnemies.size(); i++)
            {
                System.out.println();
                int num = i + 1;
                System.out.println("Enemy " + num + ":");
                System.out.print(allEnemies.get(i).toString());
                System.out.print("\n");
            }

            // Ask the player if they want to start the fight.
            String start = "";
            System.out.print("\nAre you ready to start the fight? (y/n): ");
            start = in.next();

            // If the player does not choose to start the fight, exit the loop.
            if (!start.equals("y"))
            {
                break;
            }

            System.out.println("\nFighting.........\n");

            int enemiesDefeated = 0;

            // Keep fighting until the Knight defeats all enemies or the Knight is defeated.
            while (enemiesDefeated != allEnemies.size() && player.gethealth() > 0)
            {
                // If all enemies are defeated, break from the loop.
                if (enemiesDefeated >= allEnemies.size())
                {
                    break;
                }

                // Loop through the arraylist and fight all the enemies.
                for (int i = 0; i < allEnemies.size(); i++)
                {
                    if (!(allEnemies.get(i).getHealth() <= 0) && !(player.gethealth() <= 0))
                    {
                        // Subtract all damage dealt from the player/enemy and increment the number of turns.
                        numTurns++;
                        player.takeDamage(allEnemies.get(i).getAttackDamage());
                        allEnemies.get(i).takeDamage(player.attackDamage());
                        playerDamageDealt += player.attackDamage();
                    }

                    // If the current enemy health is <=0 then it has been defeated.
                    if (allEnemies.get(i).getHealth() <= 0)
                    {
                        enemiesDefeated++;
                    }

                    // If the player's health is <= 0 they have been defeated so stop fighting.
                    if (player.gethealth() <= 0)
                    {
                        break;
                    }
                }
            }

            // If the Knight defeated all the enemies then the Knight wins.
            if (enemiesDefeated >= allEnemies.size())
            {
                System.out.println("Your Knight defeated all the enemies!!! :)");
                System.out.println();
            }
            // If the Knight's health is <= 0 then the Knight was defeated.
            else if (player.gethealth() <= 0)
            {
                System.out.println("Your Knight has been defeated :(");
                System.out.println();
            }

            // Display the summary of the fight
            System.out.println("Fight Summary:");
            System.out.println();

            System.out.println("Number of Rounds: " + numTurns);
            System.out.println();

            System.out.println("Player: " + player.getName());
            System.out.println("Health: " + player.gethealth());
            System.out.println("Total Damage Dealt: " + playerDamageDealt);
            System.out.println();

            // Display final stats for all enemies
            for (int i = 0; i < allEnemies.size(); i++)
            {
                int num = i + 1;
                System.out.println("Enemy " + num + ":");
                System.out.println(allEnemies.get(i).toString());
                System.out.println();
            }

            // Ask if the user would like to exit the program or continue to play another round.
            System.out.print("Would you like to exit the program? (y/n): ");
            exit = in.next();

        }

        // Close the scanner and exit the program
        in.close();
        System.out.println("Goodbye!");
    }
}