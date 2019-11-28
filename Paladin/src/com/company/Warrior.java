package com.company;

public class Warrior extends Characters {

    private int shield;

    /**
     * get the shield of the character
     * @return character's shield
     */
    public int getShield(){

        return this.shield;
    }

    /**
     * constructor of warrior
     * @param name          character's name
     * @param hp            character's hp
     * @param power         character's power
     * @param initiative    character's initiative
     * @param shield        character's shield
     */
    public Warrior(String name, int hp, int power, int initiative, int shield){
        super(name, hp, power, initiative);
        this.shield=shield;
    }

    /**
     * calcul of damages inflict by the character
     * @return hp remaining after applying damage value
     */
    public int hurt(int damageDone){
        damageDone=damageDone-this.shield;
        return super.hurt(damageDone) ;
    }

    /**
     * display character's information
     */
    public String toString(){
        return super.toString()+ " |  shield: " + this.shield;
    }

}
