package com.company;

public class Warrior extends Characters {
    private int shield;


    //#######################################################################################
    //##########################    Warrior constructor    ##################################
    //#######################################################################################
    /**
     * user's constructor of Warriors
     * @param name          Warrior's name
     * @param hp            Warrior's hp
     * @param power         Warrior's power
     * @param initiative    Warrior's initiative
     * @param shield        Warrior's shield
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
     * @return int shield
     */
    public int getShield(){
        return this.shield;
    }




    //#######################################################################################
    //##############################    fight Area    #######################################
    //#######################################################################################
    /**
     * calculate Warrior's damage taken with his shield
     * @param damageDone    opponent's damage
     * @return              int damage taken
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
     * @return   String containing his stats
     */
    public String toString(){
        return super.toString() +" |  shield: " + this.shield +"\n";
    }


    /**
     * display the fight conduct
     * @param C1    character who inflict damage
     * @param C2    character who received damage
     * @return      String containing the fight conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone = C2.hurt(C2.calculateDamage(C1.totalDamage(turn)));
        return C1.getName() + " inflict only " + damageDone + " damage to " +C2.getName() + " thanks to his shield. he have "  + C2.getHp() + " hp remaining";
    }


    /**
     * display character's class
     * @return String containing " the Warrior"
     */
    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }


}
