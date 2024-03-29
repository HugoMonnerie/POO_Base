package com.company;

public class Warrior extends Characters {
    private int shield;


    //#######################################################################################
    //##########################    Warrior constructor    ##################################
    //#######################################################################################
    /**
     * user's constructor of Warriors
     * @param name          String : Warrior's name
     * @param hp            int : Warrior's hp, when they pass trough 0, the character die
     * @param power         int : Warrior's power, representing the damage done by the character
     * @param initiative    int : Warrior's initiative, determinate which character attack in first place
     * @param shield        int : Warrior's shield, that reduce damage received by the chosen value
     */
    public Warrior(String name, int hp, int power, int initiative , int shield){
        super(name, hp, power, initiative);
        this.shield=shield;
    }




    //#######################################################################################
    //############################    Warriors getter    ####################################
    //#######################################################################################
    /**
     * get the Warrior's shield value
     * @return int : shield
     */
    public int getShield(){
        return this.shield;
    }




    //#######################################################################################
    //##############################    fight Area    #######################################
    //#######################################################################################
    /**
     * calculate Warrior's damage taken with his shield
     * @param damageDone    int : opponent's damage
     * @return              int : damage taken
     */
    public int calculateDamage(int damageDone){
        damageDone=damageDone-this.shield;
        if (damageDone<0){
            damageDone=0;
        }
        return damageDone;
    }




    //#######################################################################################
    //##############################    display Area    #####################################
    //#######################################################################################
    /**
     * display Warrior's stats
     * @return   String : containing his stats
     */
    public String toString(){
        return setColor() + this.getClass().getSimpleName() + " |  " + super.toString() +" |  shield: " + this.shield + super.setColor();
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
        if (C1.doACritical){
            return C1.setColor() +C1.getName() + "\033[0m inflict only " + damageDone + " critical damage to " + C2.setColor() +C2.getName() + "\033[0m thanks to his shield. he have "  + C2.getHp() + " hp remaining";
        }
        return C1.setColor() +C1.getName() + "\033[0m inflict only " + damageDone + " damage to " + C2.setColor() +C2.getName() + "\033[0m thanks to his shield. he have "  +C2.getHp() + " hp remaining";
    }


    /**
     * display character's class
     * @return String : containing " the Warrior"
     */
    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }


    /**
     * using to set text color
     * @return String : containing the color wanted
     */
    public String setColor(){
        return "\033[31m";
    }

}
