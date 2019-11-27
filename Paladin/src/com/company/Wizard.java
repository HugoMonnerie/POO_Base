package com.company;

public class Wizard extends Characters{
    private int intelligence;
    private int maxIntelligence;


    /**
     * user's constructor of Wizards
     * @param name          Wizard's name
     * @param hp            Wizard's hp
     * @param power         Wizard's power
     * @param initiative    Wizard's initiative
     * @param intelligence  Wizard's intelligence
     */
    public Wizard(String name, int hp, int power, int initiative , int intelligence){
        super(name, hp, power, initiative);
        this.intelligence=intelligence;
        this.maxIntelligence=intelligence;
    }


    /**
     * get the Wizard's intelligence
     * @return int intelligence
     */
    public int getIntelligence(){
        return this.intelligence;
    }


    /**
     * display Wizard's stats
     * @return String containing his stats
     */
    public String toString(){
        return super.toString() +" |  intelligence: " + this.intelligence +"\n";
    }


    /**
     * calculate the total damage done by a Wizard
     * @param turn  number of the current turn
     * @return      int the damageDone
     */
    public int totalDamage(int turn){
        return (int)(this.getPower()+this.intelligence/(Math.pow(2, turn)));
    }


    /**
     *
     * display the fight conduct
     * @param C1    character who inflict damage
     * @param C2    character who received damage
     * @return      String containing the fight conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone =C2.hurt(C2.calculateDamage(C1.totalDamage(turn)));
        return C1.getName() + " inflict " + damageDone + " damage to " +C2.getName() + ". he have "  + C2.getHp() + " hp remaining";

    }


    /**
     * display character's class
     * @return String containing " the Wizard"
     */
    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }

}
