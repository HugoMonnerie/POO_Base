package com.company;

public class Wizard extends Characters{

    private int magic;

    /**
     * get the magic of the character
     * @return character's magic
     */
    public int getMagic(){
        return this.magic;
    }

    /**
     * get the power of the character
     * @return character's power
     */
    public int getPower(){
        int result = super.getPower()+this.magic;
        this.magic = this.magic/2;
        return result;
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
     * display character's information
     */
    public String toString(){
        return super.toString()+ " |  magic: " + this.magic;
    }
}
