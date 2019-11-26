package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;


public class Commands {

    /**
     * print the available commands
     * @param listCommand       Array containing all commands in class Commands
     */
    public static void help()       //display usable command
    {
        ArrayList listCommand = new ArrayList();

        listCommand.add("help");
        listCommand.add("exit");
        listCommand.add("create");
        listCommand.add("stat");
        listCommand.add("giveAll");
        listCommand.add("delete");

        for (int i=0; i<listCommand.size(); i++) {
            System.out.println("command " + i + ": " + listCommand.get(i));
            //System.out.println("available commands : help / exit / delete" );
        }
    }

    /**
     * using to stop the while loop, and exit
     * @return true
     */
    public static boolean exit()
    {
        System.out.println("Thanks to have play this application");
        return true;
    }

    /**
     * create a character with the parameter added by the user
     * @param hisName       name choose by the user
     * @param hisHp         amount of hp choose by the user
     * @param hisPower      the power choose by the user
     * @param hisInitiative initiative choose by the user
     */
    static List create(List listCharacters)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("what is the name of this character");
        String hisName = sc.nextLine();
        System.out.println("what is the amount of hp of this character");
        int hisHp = sc.nextInt();

        System.out.println("what is the power of this character");
        int hisPower = sc.nextInt();
        System.out.println("what is the initiative of this character");
        int hisInitiative = sc.nextInt();

        Characters newFighter = new Characters(hisName, hisHp, hisPower, hisInitiative);
        listCharacters.add(newFighter);

        return listCharacters;
    }

    /**
     * give the stat of a character select by the user
     * @param listCharacters    usable characters list
     * @param id                character's id
     */
    static void stat(List listCharacters, int id){

        Characters C = (Characters) listCharacters.get(id);
        System.out.println("  name: " + C.getName() + " |  hp: " + C.getHp() + " |  power: " + C.getPower() + " |  initiative: "+ C.getInitiative());

    }

    /**
     * give all the characters in the list
     * @param listCharacters    characters list
     */
    static void giveAll(List listCharacters){

        for (int i=0; i<listCharacters.size(); i++)
        {
            Characters C = (Characters) listCharacters.get(i);
            System.out.println(Characters.toString(C.getName(), C.getHp(), C.getPower(), C.getInitiative()));
        }

    }

    /**
     *
     */
    static void delete()       //command to delete a character (using is Id)
    {

    }

}
