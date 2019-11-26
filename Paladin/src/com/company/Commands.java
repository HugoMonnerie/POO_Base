package com.company;
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

        listCommand.add("exit");
        listCommand.add("help");
        listCommand.add("create");
        listCommand.add("createWarior");
        listCommand.add("stat");
        listCommand.add("giveAll");
        listCommand.add("delete");
        listCommand.add("fight");

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
     * create a common character with the parameter added by the user
     * @param hisName       name choose by the user
     * @param hisHp         amount of hp choose by the user
     * @param hisPower      the power choose by the user
     * @param hisInitiative initiative choose by the user
     * @param  newFighter    the character created
     * @return newFighter
     */
    static Characters create()
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
        return newFighter;
    }


    /**
     * create a warior character
     * @param hisShield     shield value of the warrior
     * @return newFighter
     */
    static Characters createWarrior(){
        Characters C =create();
        Scanner sc = new Scanner(System.in);

        System.out.println("what is the shield of this character");
        int hisShield = sc.nextInt();
        Characters newFighter = new Warrior(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), hisShield);
        return newFighter;
    }


    /**
     * add a character into the characters list
     * @param newFighter        the character created
     * @param listCharacters    characters list
     */
    static void addToList(Characters newFighter,List listCharacters){
        listCharacters.add(newFighter);
    }


    /**
     * give the stat of a character select by the user
     * @param listCharacters    usable characters list
     * @param id                character's id
     */
    static void stat(List listCharacters, int id){

        Characters C = (Characters) listCharacters.get(id);
        System.out.print(C.toString());
    }


    /**
     * give all the characters in the list
     * @param listCharacters    characters list
     */
    static void giveAll(List listCharacters){

        for (int i=0; i<listCharacters.size(); i++)
        {
            Characters C = (Characters) listCharacters.get(i);
            System.out.println("id: " + i + " |   name: " + C.getName());
        }

        if (listCharacters.size()==0){
            System.out.println("any character created");
        }

    }


    /**
     * generate a fight between 2 character selected thanks to their id
     * @param listCharacters        characters list
     * @param id1                   first character's id
     * @param id2                   second character's id
     * @param isAlive               check if someone is dead
     */
    static void fight(List listCharacters,  int id1, int id2){
        int i=0;
        Characters C1 = (Characters) listCharacters.get(id1);
        Characters C2 = (Characters) listCharacters.get(id2);
        int hpMax1=C1.getHp();
        int hpMax2=C2.getHp();
        boolean isAlive=true;

        if (C2.getInitiative()>C1.getInitiative()){     // first hit by C1
            Characters CSwitch=C1;
            C1=C2;
            C2=CSwitch;
        }

        System.out.println(C1.getName() + " is too fast for " + C2.getName());

        while ((C1.getHp()>0 && C2.getHp()>0 ) || isAlive){
            i++;
            System.out.print("\n -- tour " + i + " --\n");

            C2.hurt(C1.getPower());
            System.out.println(C2.displayFight(C1, C2));
            isAlive=C2.isDead(C2, C1, isAlive);

            if (!isAlive){
                break;
            }

            C1.hurt(C2.getPower());
            System.out.println(C1.displayFight(C2, C1));
            isAlive=C1.isDead(C1, C2, isAlive);



        }
        C1.heal(hpMax1);
        C2.heal(hpMax2);

    }


    /**
     * delete a character thanks to his id
     * @param listCharacters        characters list
     * @param id                    character's
     */
    static void delete(List listCharacters, int id)
    {
        Scanner sc = new Scanner(System.in);
        Characters C = (Characters) listCharacters.get(id);
        System.out.println("are you sure you want to delete"+ C.getName() + "?");

        String confirm = sc.nextLine();

        if (confirm.equals("no") || confirm.equals("No"))
        {
            System.out.println(C.getName()+ " thank you");
        }
        else{
            System.out.println(C.getName() + " walk far away...");
            listCharacters.remove(id);
        }
    }

}
