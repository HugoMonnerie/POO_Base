package com.company;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;


public class Commands {

    /**
     * print the available commands
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
     * @param listCharacters        characters list
     */
    static void create(List listCharacters)
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
    }

    /**
     * create a warrior with the parameter added by the user
     *@param listCharacters        characters list
     */
    static void warrior(List listCharacters)
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

        System.out.println("what is the shield of this character");
        int hisShield = sc.nextInt();

        Characters newFighter = new Warrior(hisName, hisHp, hisPower, hisInitiative, hisShield);
        listCharacters.add(newFighter);
    }

    /**
     * create a wizard with the parameter added by the user
     *@param listCharacters        characters list
     */
    static void wizard(List listCharacters)
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

        System.out.println("what is the magic of this character");
        int hisMagic = sc.nextInt();

        Characters newFighter = new Wizard(hisName, hisHp, hisPower, hisInitiative, hisMagic);
        listCharacters.add(newFighter);
    }

    /**
     * create a rogue with the parameter added by the user
     *@param listCharacters        characters list
     */
    static void rogue(List listCharacters)
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

        System.out.println("what is the luck of critic of this character (%)");
        int hisCritic = sc.nextInt();

        System.out.println("what is the luck of dodge of this character (%)");
        int hisDodge = sc.nextInt();

        Characters newFighter = new Rogue(hisName, hisHp, hisPower, hisInitiative, hisCritic, hisDodge);
        listCharacters.add(newFighter);
    }

    /**
     * give the stat of a character select by the user
     * @param listCharacters    usable characters list
     * @param id                character's id
     */
    static void stat(List listCharacters, int id){

        Characters C = (Characters) listCharacters.get(id);
        System.out.println(C);

    }

    /**
     * give all the characters in the list
     * @param listCharacters    characters list
     */
    static void giveAll(List listCharacters){

        for (int i=0; i<listCharacters.size(); i++)
        {
            Characters C = (Characters) listCharacters.get(i);
            System.out.println("id: " + i + " |  name: " + C.getName());
        }

        if (listCharacters.size()==0){
            System.out.println("any character created");
        }

    }

    /**
     * delete a character by his id
     * @param listCharacters        characters list
     * @param id                    character's
     */
    static void delete(List listCharacters, int id)
    {
        listCharacters.remove(id);
    }

    /**
     * start fight between 2 character by hid id
     * @param listCharacters        characters list
     * @param id1                   id first character
     * @param id2                   id secondary character
     */

    static void fight(List listCharacters, int id1, int id2)
    {
        Characters C1 = (Characters) listCharacters.get(id1);
        Characters C2 = (Characters) listCharacters.get(id2);
        int turn = 0;

        if (C1.getInitiative() > C2.getInitiative()) {
            while (C1.getHp() >= 0 || C2.getHp() >= 0) {
                turn++;
                System.out.println( "\n-- turn "+ turn +" --\n");
                C2.hurt(C1.getPower());
                System.out.println(C1.getName()+" inflict "+C1.getPower()+" to "+ C2.getName()+", have "+C2.getHp()+" HP ");

                if (C1.getHp() >= 0 || C2.getHp() >= 0){
                    C1.hurt(C2.getPower());
                    System.out.println(C2.getName()+" inflict "+C2.getPower()+" to "+ C1.getName()+", have "+C1.getHp()+" HP ");
                }
            }
        }
        else {
            while (C1.getHp() >= 0 || C2.getHp() >= 0) {
                turn++;
                System.out.println( "\n-- turn "+ turn +" --\n");
                C1.hurt(C2.getPower());
                System.out.println(C2.getName()+" inflict "+C2.getPower()+" to "+ C1.getName()+", have "+C1.getHp()+" HP ");

                if (C1.getHp() >= 0 || C2.getHp() >= 0){
                    C2.hurt(C2.getPower());
                    System.out.println(C1.getName()+" inflict "+C1.getPower()+" to "+ C2.getName()+", have "+C2.getHp()+" HP ");
                }
            }
        }

    }

}
