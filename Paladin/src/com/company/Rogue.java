package com.company;

import java.util.Random;

public class Rogue extends Characters{
    private int dodge;
    private int initialDodge;
    private int doADodge = 0;
    private int critical;
    private int initialCritical;
    private int doACritical = 0;
    private int tourCritical = -2;

    public Rogue(String name, int hp, int power, int initiative , int dodge ,int critical){
        super(name, hp, power, initiative);
        this.dodge=dodge;
        this.initialDodge=dodge;
        this.critical=critical;
        this.initialCritical=critical;
    }

    public int getDodge(){
        return this.dodge;
    }


    public int getCritical(){
        return this.critical;
    }


    public String toString(){
        return super.toString() + " |  dodge: " + this.dodge + " |  critical: " + this.critical + "\n";
    }

    //have to update
    public int totalDamage(int tour){
        this.critical=this.critical+ tour%3*this.critical;

        if (this.critical>100 && this.tourCritical<tour-1){   //&& this.tourCritical<tour-1
            this.doACritical+=1;

            this.tourCritical=tour;
        }

        if(this.doACritical==1){
            return this.getPower()*2;
        }
        else
        {
            this.critical=this.initialCritical;
        }

        this.doACritical=0;
        return this.getPower();
    }


    public int calculateDamage(int damageDone){
        /*Random rand = new Random();
        this.dodge=this.dodge+ rand.nextInt(5 * this.dodge);

        if (this.dodge>100){
            this.doADodge+=1;
            this.dodge=this.initialDodge;
        }

        if(this.doADodge==1){
            return 0;
        }

        this.doADodge=0;*/
        return damageDone;

    }


    public String displayFight(Characters C1, Characters C2, int tour){
        return C1.getName() + " inflict " + C1.calculateDamage(C1.totalDamage(tour)) + " damage to " +C2.getName() + ". he have "  + C2.getHp() + " hp remaining";

    }


    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }

}
