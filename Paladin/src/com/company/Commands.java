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
        listCommand.add("createWarrior");
        listCommand.add("createWizard");
        listCommand.add("createRogue");
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
     * @return the new Fighter
     */
    static Characters create()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("what is the character's name?");
        String hisName = sc.nextLine();

        System.out.println("what is the character's amount of hp?");
        int hisHp = sc.nextInt();
        while (hisHp<=0){
            System.out.println("is he already die? enter an amount of hp higher than 0");
            hisHp = sc.nextInt();
        }

        System.out.println("what is the character's power?");
        int hisPower = sc.nextInt();
        while (hisPower<=0){
            System.out.println("is your character suffering from myopathy? enter a power higher than 0");
            hisPower = sc.nextInt();
        }

        System.out.println("what is the character's initiative value?");
        int hisInitiative = sc.nextInt();
        while (hisInitiative<=0){
            System.out.println("even a snail should be faster than this. enter a shield higher than 0");
            hisInitiative = sc.nextInt();
        }

        return new Characters(hisName, hisHp, hisPower, hisInitiative);
    }


    /**
     * create a Warrior character
     * @param hisShield     shield value of the Warrior
     * @return the new Fighter
     */
    static Characters createWarrior(){
        Characters C =create();
        Scanner sc = new Scanner(System.in);

        System.out.println("what is the character's shield value?");
        int hisShield = sc.nextInt();
        while (hisShield<=0){
            System.out.println("even the worst shield should be more efficient than this, enter a shield higher than 0");
            hisShield = sc.nextInt();
        }
        return new Warrior(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), hisShield);
    }


    /**
     * create a Wizard character
     * @return the new Fighter
     */
    static Characters createWizard(){
        Characters C =create();
        Scanner sc = new Scanner(System.in);

        System.out.println("what is the character's intelligence value?");
        int hisIntelligence = sc.nextInt();
        while (hisIntelligence<=0){
            System.out.println("even the worst wizard should have more intelligence than this, enter an intelligence higher than 0");
            hisIntelligence = sc.nextInt();
        }
        return new Wizard(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), hisIntelligence);
    }


    static Characters createRogue(){
        Characters C =create();
        Scanner sc = new Scanner(System.in);

        System.out.println("what is the character's dodge value?");
        int hisDodge = sc.nextInt();
        while (hisDodge<=0){
            System.out.println("your rogue should have a chance to dodge attack. enter a dodge value higher than 0");
            hisDodge = sc.nextInt();
        }

        System.out.println("what is the character's critical value?");
        int hisCritical = sc.nextInt();
        while (hisCritical<=0){
            System.out.println("your rogue should have a chance to do critical attack. enter a dodge value higher than 0");
            hisCritical = sc.nextInt();
        }

        return new Rogue(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), hisDodge, hisCritical);
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

            C2.hurt(C1.calculateDamage(C1.totalDamage(i)));
            System.out.println(C2.displayFight(C1, C2, i));
            isAlive=C2.isDead(C2, C1, isAlive);

            if (!isAlive){
                break;
            }
            C1.hurt(C2.calculateDamage(C2.totalDamage(i)));
            System.out.println(C1.displayFight(C2, C1, i));
            isAlive=C1.isDead(C1, C2, isAlive);

        }
        C1.heal();
        C2.heal();

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
        System.out.println("are you sure you want to delete "+ C.getName() + "?");

        String confirm = sc.nextLine().toLowerCase();

        if (confirm.equals("no"))
        {
            System.out.println(C.getName()+ C.displayClass() + " is grateful");
        }
        else if (confirm.equals("yes")){
            System.out.println(C.getName() + C.displayClass() + " walk far away...");
            listCharacters.remove(id);
        }
        else{
            System.out.println("you don't seem sure, "+  C.getName()+ C.displayClass() + " stay here");
        }
    }

}
