package com.company;

import java.util.ArrayList;

public class Characters {
    private String name;
    private int hp;
    private int maxHp;
    private int power;
    private int initiative;


    /**
     * get the name of the character
     * @return character's name
     */
    public String getName(){
        return this.name;
    }


    /**
     * get the hearth points of the character
     * @return character's hp
     */
    public int getHp(){
        return this.hp;
    }


    /**
     * get the power of the character
     * @return character's power
     */
    public int getPower(){
        return this.power;
    }


    /**
     * get the initiative of the character
     * @return character's initiative
     */
    public int getInitiative(){
        return this.initiative;
    }


    /**
     * calculate hp remaining after receiving damage
     */
    public void hurt(int damageDone){
        this.hp=this.hp-damageDone;
    }


    /**
     * give the hp wanted by the user to the wounded character
     * @param hpMax     character's max hp
     */
    public void heal(){
        this.hp=this.maxHp;
    }


    /**
     * constructor of character
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
    }


    public Characters(){
        this("hugo", 30, 5, 8);
    }

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
    public String displayFight(Characters C1, Characters C2, int tour){
        return C1.getName() + " inflict " + C1.totalDamage(tour) + " damage to " + C2.getName() + ". he have "  + C2.getHp() + " hp remaining";
    }



    public int calculateDamage(int damageDone){
        return damageDone;
    }



    public int totalDamage(int tour){
       return this.getPower();
    }


    public boolean isDead(Characters C1, Characters C2, boolean isAlive){
        if (C1.getHp()<=0)
        {
            System.out.println(C1.getName() + " is down\n" + C2.getName() + " is victorious\n");
            return isAlive==false;
        }
        return isAlive==true;
    }


    public String displayClass(){
        return "";
    }

}
