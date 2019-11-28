package com.company;
import java.util.*;
import java.util.Scanner;


public class Commands {

    //#######################################################################################
    //#########################    application commands    ##################################
    //#######################################################################################
    /**
     * print the available commands
     * @param listCommand List : list of the available commands
     */
    public static void help(List listCommand)       //display usable command
    {
        for (int i=0; i<listCommand.size(); i++) {
            System.out.println("command " + i + ": " + listCommand.get(i));
        }
    }


    /**
     * using to stop the while loop, and exit
     * @return  boolean : true
     */
    public static boolean exit()
    {
        System.out.println("Thanks to have play this application");
        return true;
    }




    //#######################################################################################
    //###########################    characters editor    ###################################
    //#######################################################################################
    /**
     * create a common character with the parameter added by the user
     * @return  Characters : the new Fighter
     */
    static Characters create()
    {
        Scanner sc = new Scanner(System.in);
        int hisHp=30;
        int hisPower=5;
        int hisInitiative=5;

        System.out.println("what is the character's name?");
        String hisName = sc.nextLine();

        System.out.println("what is the character's amount of hp?");
        try {
            hisHp = sc.nextInt();
            while (hisHp<=0){
                System.out.println("is he already dead? enter an amount of hp higher than 0");
                hisHp = sc.nextInt();
            }
        } catch (Exception e){
            System.out.println("you don't have entered a valid value, setting default value");
        }

        System.out.println("what is the character's power?");
        try {
            hisPower = sc.nextInt();
            while (hisPower <= 0) {
                System.out.println("is your character suffering from myopathy? enter a power higher than 0");
                hisPower = sc.nextInt();
            }
        }catch (Exception e){
            System.out.println("you don't have entered a valid value, setting default value");
        }

        System.out.println("what is the character's initiative value?");
        try {
            hisInitiative = sc.nextInt();
            while (hisInitiative <= 0) {
                System.out.println("even a snail should be faster than this. enter an initiative higher than 0");
                hisInitiative = sc.nextInt();
            }
        } catch (Exception e){
            System.out.println("you don't have entered a valid value, setting default value");
        }


        return new Characters(hisName, hisHp, hisPower, hisInitiative);
    }


    /**
     * create a Warrior character
     * @return  Warrior : the new Fighter
     */
    static Warrior createWarrior(){
        Characters C =create();
        Scanner sc = new Scanner(System.in);
        int hisShield=2;

        System.out.println("what is the character's shield value?");
        try {
            hisShield = sc.nextInt();
            while (hisShield <= 0) {
                System.out.println("even the worst shield should be more efficient than this. enter a shield higher than 0");
                hisShield = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("you don't have entered a valid value, setting default value");
        }

        return new Warrior(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), hisShield);
    }


    /**
     * create a Wizard character
     * @return  Wizard : the new Fighter
     */
    static Wizard createWizard(){
        Characters C =create();
        Scanner sc = new Scanner(System.in);
        int hisIntelligence=10;

        System.out.println("what is the character's intelligence value?");
        try {
            hisIntelligence = sc.nextInt();
            while (hisIntelligence <= 0) {
                System.out.println("even the worst wizard should have more intelligence than this. enter an intelligence higher than 0");
                hisIntelligence = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("you don't have entered a valid value, setting default value");
        }
        return new Wizard(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), hisIntelligence);
    }

    /**
     * create a Rogue character
     * @return  Rogue : the new fighter
     */
    static Rogue createRogue(){
        Characters C =create();
        Scanner sc = new Scanner(System.in);
        int hisDodge=5;
        int hisCritical=5;

        System.out.println("what is the character's dodge value?");
        try {
            hisDodge = sc.nextInt();
            while (hisDodge <= 0) {
                System.out.println("your rogue should have a chance to dodge attack. enter a dodge value higher than 0");
                hisDodge = sc.nextInt();
            }
        }catch (Exception e) {
            System.out.println("you don't have entered a valid value, setting default value");
        }

        System.out.println("what is the character's critical value?");
        try {
            hisCritical = sc.nextInt();
            while (hisCritical <= 0) {
                System.out.println("your rogue should have a chance to do critical attack. enter a critical value higher than 0");
                hisCritical = sc.nextInt();
            }
        }catch (Exception e){
            System.out.println("you don't have entered a valid value, setting default value");
        }


        return new Rogue(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), hisDodge, hisCritical);
    }


    /**
     * create a Paladin character
     * @return  Paladin : the new Fighter
     */
    static Paladin createPaladin(){
        Warrior C =createWarrior();
        Scanner sc = new Scanner(System.in);
        int hisMana=5;

        System.out.println("what is the character's mana value?");
        try {
            hisMana = sc.nextInt();
            while (hisMana <= 0) {
                System.out.println("even the worst paladin should have more mana than this. enter a mana value higher than 0");
                hisMana = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("you don't have entered a valid value, setting default value");
        }

        return new Paladin(C.getName(), C.getHp(), C.getPower(), C.getInitiative(), C.getShield(), hisMana);
    }





    //#######################################################################################
    //#######################    characters list management    ##############################
    //#######################################################################################
    /**
     * delete a character thanks to his id
     * @param listCharacters        ArrayList : characters list
     * @param id                    int : character's id
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




    //#######################################################################################
    //###########################    characters getter    ###################################
    //#######################################################################################
    /**
     * give the stat of a character select by the user
     * @param listCharacters    ArrayList : usable characters list
     * @param id                int : character's id
     */
    static void stat(List listCharacters, int id){

        Characters C = (Characters) listCharacters.get(id);
        System.out.print(C.toString());
    }


    /**
     * give all the characters in the list
     * @param listCharacters    ArrayList : characters list
     */
    static void giveAll(List listCharacters){

        for (int i=0; i<listCharacters.size(); i++)
        {
            Characters C = (Characters) listCharacters.get(i);
            System.out.println( C.setColor() +"id: " + i + " |   name: " + C.getName() + " |  " + C.getClass().getSimpleName() +  "\033[0m");
        }

        if (listCharacters.size()==0){
            System.out.println("any character created");
        }

    }



    //#######################################################################################
    //###########################    characters fight    ###################################
    //#######################################################################################
    /**
     * generate a fight between 2 character selected thanks to their id
     * @param listCharacters        ArrayList : characters list
     * @param id1                   int : first character's id
     * @param id2                   int : second character's id
     */
    static void fight(List listCharacters,  int id1, int id2){
        int turn=0;
        Characters C1 = (Characters) listCharacters.get(id1);
        Characters C2 = (Characters) listCharacters.get(id2);

        boolean isAlive=true;

        if (C2.getInitiative()>C1.getInitiative()){     // first hit by C1
            Characters CSwitch=C1;
            C1=C2;
            C2=CSwitch;
        }

        C1.restore();
        C2.restore();

        System.out.println(C1.getName() + " is too fast for " + C2.getName());

        while ((C1.getHp()>0 && C2.getHp()>0 ) || isAlive){
            turn++;
            System.out.print("\n\033[35m -- turn " + turn + " --\n\033[0m");

            System.out.println(C2.displayFight(C1, C2, turn));
            isAlive=C2.isDead(C2, C1, isAlive);

            if (!isAlive){
                break;
            }
            System.out.println(C1.displayFight(C2, C1, turn));
            isAlive=C1.isDead(C1, C2, isAlive);

        }
        C1.restore();
        C2.restore();

    }

}
