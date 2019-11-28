package com.company;

public class Wizard extends Characters{
    private int intelligence;
    private int maxIntelligence;

    //#######################################################################################
    //###########################    Wizard constructor    ##################################
    //#######################################################################################
    /**
     * user's constructor of Wizards
     * @param name          String : Wizard's name
     * @param hp            int : Wizard's hp, when they pass trough 0, the character die
     * @param power         int : Wizard's power, representing the damage done by the character
     * @param initiative    int : Wizard's initiative, determinate which character attack in first place
     * @param intelligence  int : Wizard's intelligence, representing a bonus damage reducing when turn value increased
     */
    public Wizard(String name, int hp, int power, int initiative , int intelligence){
        super(name, hp, power, initiative);
        this.intelligence=intelligence;
        this.maxIntelligence=intelligence;
    }


    //#######################################################################################
    //#############################    Wizard getter    #####################################
    //#######################################################################################
    /**
     * get the Wizard's intelligence
     * @return int : intelligence
     */
    public int getIntelligence(){
        return this.intelligence;
    }


    //#######################################################################################
    //##############################    fight Area    #######################################
    //#######################################################################################
    /**
     * calculate the total damage done by a Wizard, with his bonus magic damage
     * @param turn  int : number of the current turn
     * @return      int : the damageDone
     */
    public int totalDamage(int turn){
        return (int)(this.getPower()+this.intelligence/(Math.pow(2, turn-1)));
    }




    //#######################################################################################
    //#############################    display Area    ######################################
    //#######################################################################################
    /**
     * display Wizard's stats
     * @return String : containing his stats
     */
    public String toString(){
        return setColor() +this.getClass().getSimpleName() + " |  " + super.toString() +" |  intelligence: " + this.intelligence + super.setColor();
    }


    /**
     * display the fight conduct
     * @param C1    Characters : character who inflict damage
     * @param C2    Characters : character who received damage
     * @param turn  int : current turn
     * @return      String : containing the fight conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        return super.displayFight(C1, C2, turn);
    }


    /**
     * display character's class
     * @return String : containing " the Wizard"
     */
    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }


    /**
     * using to set text color
     * @return String : containing the color wanted
     */
    public String setColor(){
        return "\033[34m";
    }

}
