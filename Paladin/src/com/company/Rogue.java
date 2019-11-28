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
     * @param name          String : Rogue's name
     * @param hp            int : Rogue's hp, when they pass trough 0, the character die
     * @param power         int : Rogue's power, representing the damage done by the character
     * @param initiative    int : Rogue's initiative, determinate which character attack in first place
     * @param dodge         int : Rogue's dodge, higher it is, higher is chance to dodge are increased
     * @param critical      int : Rogue's critical, higher it is, higher is chance to do a critical are increased
     */
    public Rogue(String name, int hp, int power, int initiative , int dodge ,int critical){
        super(name, hp, power, initiative);

        if (dodge>100){
            dodge=100;
        }
        this.dodge=dodge;
        this.initialDodge=dodge;

        if (critical>100){
            critical=100;
        }
        this.critical=critical;
        this.initialCritical=critical;
    }


    //#######################################################################################
    //#############################    Rogue getter    ######################################
    //#######################################################################################
    /**
     * get the Rogue's dodge value
     * @return int : dodge
     */
    public int getDodge(){
        return this.dodge;
    }


    /**
     * get the Rogue's critical value
     * @return int : critical
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
     * calculate the total damage done by a Rogue, with his possibility to inflict critical damage
     * @param turn  int : number of the current turn
     * @return      int : the damageDone
     */
    public int totalDamage(int turn){
        Random rand = new Random();
        this.critical = 1 +this.critical + rand.nextInt(2) * this.initialCritical;

        if ((this.critical>100) && !doACritical){
            this.critical=this.initialCritical-Math.round(this.initialCritical/3);
            this.doACritical=true;
            return this.getPower()*2;
        }

        this.doACritical=false;
        return this.getPower();
    }


    /**
     * calculate Rogue's damage taken, with his possibility to dodge
     * @param damageDone    int : opponent's damage
     * @return              int : damage taken
     */
    public int calculateDamage(int damageDone){
        Random rand = new Random();
        this.dodge = 1 + this.dodge+ rand.nextInt(2 )* this.initialDodge;

        if (this.dodge>100){
            this.dodge=this.initialDodge-Math.round(this.initialDodge/3);
            return 0;
        }

        return damageDone;
    }




    //#######################################################################################
    //#############################    display Area    ######################################
    //#######################################################################################
    /**
     * display Rogue's stats
     * @return String : containing his stats
     */
    public String toString(){
        return setColor() +this.getClass().getSimpleName() + " |  " + super.toString() + " |  dodge: " + this.dodge + " |  critical: " + this.critical + super.setColor();
    }


    /**
     * display the fight conduct
     * @param C1    Characters : character who inflict damage
     * @param C2    Characters : character who received damage
     * @param turn  int : current turn
     * @return      String : containing the fight conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone = C2.hpVar(C2.calculateDamage(C1.totalDamage(turn)));

        if (damageDone==0){
            return C2.setColor() +C2.getName()+ "\033[0m dodge the attack from " + C1.setColor() + C1.getName() + "\033[0m. " + C1.setColor() + C1.getName() + "\033[0m inflict " + damageDone + " damage to " + C2.setColor() +C2.getName() + "\033[0m, he have "  + C2.getHp() + " hp remaining";
        }
        if (C1.doACritical){
            return C1.setColor() +C1.getName() + "\033[0m inflict " + damageDone + " critical damage to " + C2.setColor() +C2.getName() + "\033[0m. he have "  + C2.getHp() + " hp remaining";
        }
        return C1.setColor() +C1.getName() + "\033[0m inflict " + damageDone + " damage to " + C2.setColor() +C2.getName() + "\033[0m. he have "  + C2.getHp() + " hp remaining";
    }


    /**
     * display character's class
     * @return String : containing " the Rogue"
     */
    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }


    /**
     * using to set text color
     * @return String : containing the color wanted
     */
    public String setColor(){
        return "\033[32m";
    }

}
