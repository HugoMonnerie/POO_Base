package com.company;
import java.util.*;

public class Commands {

    /**
     * print the available commands
     * @listCommand Array containing all commands in class Commands
     */
    public static void help()       //display usable command
    {
        ArrayList listCommand = new ArrayList();

        listCommand.add("help");
        listCommand.add("exit");
        listCommand.add("create");
        listCommand.add("delete");

        for (int i=0; i<listCommand.size(); i++) {
            System.out.println("command " + i + ": " + listCommand.get(i));
            //System.out.println("available commands : help / exit / delete" );
        }
    }

    /**
     * using to stop the while loop
     * @return true
     */
    public static boolean exit()       //command to exit
    {
        System.out.println("Thanks to have play this application");
        return true;
    }

    /**
     * create character
     */
    static void create()       //command to create a new character
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name");
        String name=sc.nextLine();
        System.out.println("HP");
        int hp=sc.nextInt();
        System.out.println("power");
        int power=sc.nextInt();
        System.out.println("initiative");
        int initiative=sc.nextInt();

        Characters newFighter = new Characters(name, hp, power, initiative);

        Characters.toString(name, hp, power, initiative);
    }

    static void delete()       //command to delete a character (using is Id)
    {

    }

}
