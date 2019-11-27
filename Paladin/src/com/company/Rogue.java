package com.company;

import java.util.Random;

public class Rogue extends Characters{
    private int dodge;
    private int initialDodge;
    private int critical;
    private int initialCritical;

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


    public void heal(){
        super.heal();
        this.dodge=this.initialDodge;
        this.critical=this.initialCritical;
    }


    public int totalDamage(int tour){
        Random rand = new Random();
        this.critical = this.critical + rand.nextInt(2) * this.initialCritical;


        if (this.critical>100){   //&& this.tourCritical<tour-1
            this.critical=this.initialCritical/2;
            return this.getPower()*2;
        }

        return this.getPower();
    }

        //the last things to do
    public int calculateDamage(int damageDone){
        Random rand = new Random();
        this.dodge=this.dodge+ rand.nextInt(2 )* this.initialDodge;

        if (this.dodge>100){
            this.dodge=this.initialDodge/2;
            return 0;
        }

        return damageDone;
    }


    public String displayFight(Characters C1, Characters C2, int tour){
        int damageDone = C2.hurt(C2.calculateDamage(C1.totalDamage(tour)));
        return C1.getName() + " inflict " + damageDone + " damage to " +C2.getName() + ". he have "  + C2.getHp() + " hp remaining";

    }


    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }

}
