package com.company;

public class Wizard extends Characters{

    private int magic;
    private int powerMagic = super.getPower() + magic;

    /**
     * get the magic of the character
     * @return character's magic
     */
    public int getMagic(){
        return this.magic;
    }

    /**
     * constructor of wizard
     * @param name          character's name
     * @param hp            character's hp
     * @param power         character's power
     * @param initiative    character's initiative
     * @param magic         character's magic
     */
    public Wizard(String name, int hp, int power, int initiative, int magic){
        super(name, hp, power, initiative);
        this.magic=magic;
    }

    /**
     * calcul of damages inflict by the character
     * @return hp remaining after applying damage value
     */
    public int hurt(int damageDone){

        return super.hurt(damageDone) ;
    }

    /**
     * display character's information
     */
    public String toString(){
        return super.toString()+ " |  magic: " + this.magic;
    }
}
