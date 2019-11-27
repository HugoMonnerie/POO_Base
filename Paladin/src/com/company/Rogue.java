package com.company;

import java.util.Random;

public class Rogue extends Characters{

    private int critic;
    private int dodge;
    private boolean criticPrec = true;

    /**
     * get the critic of the character
     * @return character's critic
     */
    public int getCritic(){
        return this.critic;
    }

    /**
     * get the power of the character
     * @return character's power
     */
    public int getPower(){
        Random rand = new Random();
        if (rand.nextInt(100) <= critic) {
            if (!criticPrec) {
                criticPrec = true;
                return super.getPower() * 2;
            }
            else {
                criticPrec = false;
                return super.getPower();
            }
        }
        else {
            criticPrec = false;
            return super.getPower();
        }
    }

    /**
     * constructor of rogue
     * @param name          character's name
     * @param hp            character's hp
     * @param power         character's power
     * @param initiative    character's initiative
     * @param critic        character's critic
     * @param dodge         character's dodge
     */
    public Rogue(String name, int hp, int power, int initiative, int critic, int dodge){
        super(name, hp, power, initiative);
        this.critic=critic;
        this.dodge=dodge;
    }

    /**
     * calcul of damages inflict by the character
     * @return hp remaining after applying damage value
     */
    public int hurt(int damageDone){
        Random rand = new Random();
        if (rand.nextInt(100) <= dodge){
            damageDone=0;
            return super.hurt(damageDone);
        } else {
            return super.hurt(damageDone);
        }
    }

    /**
     * display character's information
     */
    public String toString(){
        return super.toString()+ " |  critic: " + this.critic+" | dodge: "+ this.dodge;
    }
}
