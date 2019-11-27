package com.company;

import java.util.Random;

public class Rogue extends Characters{
    private int dodge;
    private int initialDodge;
    private int critical;
    private int initialCritical;


    //#######################################################################################
    //###########################    Rogue Constructor    ###################################
    //#######################################################################################
    /**
     * user's constructor of Rogue
     * @param name          Rogue's name
     * @param hp            Rogue's hp
     * @param power         Rogue's power
     * @param initiative    Rogue's initiative
     * @param dodge         Rogue's dodge
     * @param critical      Rogue's critical
     */
    public Rogue(String name, int hp, int power, int initiative , int dodge ,int critical){
        super(name, hp, power, initiative);
        this.dodge=dodge;
        this.initialDodge=dodge;
        this.critical=critical;
        this.initialCritical=critical;
    }


    //#######################################################################################
    //#############################    Rogue getter    ######################################
    //#######################################################################################
    /**
     * get the Rogue's dodge value
     * @return int dodge
     */
    public int getDodge(){
        return this.dodge;
    }


    /**
     * get the Rogue's critical value
     * @return int critical
     */
    public int getCritical(){
        return this.critical;
    }




    //#######################################################################################
    //##############################    fight Area    #######################################
    //#######################################################################################
    /**
     * restore all Rogue stats
     */
    public void restore(){
        super.restore();
        this.dodge=this.initialDodge;
        this.critical=this.initialCritical;
    }


    /**
     * calculate the total damage done by a Rogue with his critical skill
     * @param turn  number of the current turn
     * @return      int the damageDone
     */
    public int totalDamage(int turn){
        Random rand = new Random();
        this.critical = this.critical + rand.nextInt(2) * this.initialCritical;


        if (this.critical>100){   //&& this.tourCritical<tour-1
            this.critical=this.initialCritical/2;
            this.doACritical=true;
            return this.getPower()*2;
        }

        this.doACritical=false;
        return this.getPower();
    }


    /**
     * calculate Rogue's damage taken with his dodging skill
     * @param damageDone    opponent's damage
     * @return              int damage taken
     */
    public int calculateDamage(int damageDone){
        Random rand = new Random();
        this.dodge=this.dodge+ rand.nextInt(2 )* this.initialDodge;

        if (this.dodge>100){
            this.dodge=this.initialDodge/2;
            return 0;
        }

        return damageDone;
    }




    //#######################################################################################
    //#############################    display Area    ######################################
    //#######################################################################################
    /**
     * display Rogue's stats
     * @return String containing his stats
     */
    public String toString(){
        return setColor() +this.getClass().getSimpleName() + " |  " + super.toString() + " |  dodge: " + this.dodge + " |  critical: " + this.critical + super.setColor();
    }


    /**
     * display the fight conduct
     * @param C1    character who inflict damage
     * @param C2    character who received damage
     * @return      String containing the fight conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone = C2.hurt(C2.calculateDamage(C1.totalDamage(turn)));
        if (damageDone==0){
            return C2.getName()+ " dodge the attack from " +C1.getName() + ". " + C1.getName() + " inflict " + damageDone + " damage to " +C2.getName() + ", he have "  + C2.getHp() + " hp remaining";
        }
        return C1.getName() + " inflict " + damageDone + " damage to " +C2.getName() + ". he have "  + C2.getHp() + " hp remaining";

    }


    /**
     * display character's class
     * @return String containing " the Rogue"
     */
    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }


    /**
     * using to set text color
     * @return String containing the color wanted
     */
    public String setColor(){
        return"\033[32m";
    }

}
