package com.company;

import java.util.ArrayList;

public class Characters {
    private String name;
    private int hp;
    private int maxHp;
    private int power;
    private int initiative;
    protected boolean doACritical;


    //#######################################################################################
    //########################    characters constructors    ################################
    //#######################################################################################
    /**
     * user's constructor of characters
     * @param name          character's name
     * @param hp            character's hp
     * @param power         character's power
     * @param initiative    character's initiative
     */
    public Characters(String name,  int hp, int power, int initiative){
        this.name=name;
        this.hp=hp;
        this.maxHp=hp;
        this.power=power;
        this.initiative=initiative;
        this.doACritical=false;
    }


    /**
     * default constructor characters
     */
    public Characters(){
        this("hugo", 30, 5, 8);
    }




    //#######################################################################################
    //###########################    character getters    ###################################
    //#######################################################################################
    /**
     * get the character's name
     * @return int character's name
     */
    public String getName(){
        return this.name;
    }


    /**
     * get the character's hearth points
     * @return int character's hp
     */
    public int getHp(){
        return this.hp;
    }


    /**
     * get the character's power
     * @return int character's power
     */
    public int getPower(){
        return this.power;
    }


    /**
     * get the character's initiative
     * @return int character's initiative
     */
    public int getInitiative(){
        return this.initiative;
    }




    //#######################################################################################
    //############################     fighting Area     ####################################
    //#######################################################################################
    /**
     * calculate hp remaining after receiving damage
     * @return int the damage done
     */
    public int hurt(int damageDone){
        this.hp=this.hp-damageDone;
        return damageDone;
    }


    /**
     * restore the wounded character's hp
     */
    public void restore(){
        this.hp=this.maxHp;
    }


    /**
     * calculate damage received by a character
     * @param damageDone    damage done by a character
     * @return              int the damage done
     */
    public int calculateDamage(int damageDone){
        return damageDone;
    }


    /**
     * calculate the total damage done by a character
     * @param turn  number of the current turn
     * @return      int the damage done
     */
    public int totalDamage(int turn){
        return this.getPower();
    }


    /**
     * check if a character is dead, show the looser and the winner
     * @param C1        character which could be dead
     * @param C2        character which could win
     * @param isAlive   boolean which check if C1 is alive
     * @return          boolean isAlive=true if C1 is Alive
     */
    public boolean isDead(Characters C1, Characters C2, boolean isAlive){
        if (C1.getHp()<=0)
        {
            System.out.println(C1.getName() + " is down\n" + C2.getName() + " is victorious\n");
            return isAlive==false;
        }
        return isAlive==true;
    }





    //#######################################################################################
    //############################    displaying area    ####################################
    //#######################################################################################
    /**
     * display character's stats
     * @return  String containing his stats
     */
    public String toString(){
        return "name: " + this.name + " |  hp: " + this.hp + " |  power: " + this.power + " |  initiative: " + this.initiative ;
    }


    /**
     * display the fight conduct
     * @param C1    character who inflict damage
     * @param C2    character who received damage
     * @return      String containing the conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone =C2.hurt(C2.calculateDamage(C1.totalDamage(turn)));

        if (doACritical){
            return C1.getName() + " inflict " + damageDone + " critical damage to " +C2.getName() + ". he have "  + C2.getHp() + " hp remaining";
        }

        return C1.getName() + " inflict " + damageDone + " damage to " + C2.getName() + ". he have "  + C2.getHp() + " hp remaining";
    }


    /**
     * display the character's Class
     * @return String containing nothing for a common Character
     */
    public String displayClass(){
        return "";
    }


    /**
     * using to set text color
     * @return String containing the color wanted
     */
    public String setColor(){
        return"\033[0m";
    }

}
