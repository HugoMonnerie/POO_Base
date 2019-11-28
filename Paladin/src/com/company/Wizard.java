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
     * @param hp            int : Wizard's hp
     * @param power         int : Wizard's power
     * @param initiative    int : Wizard's initiative
     * @param intelligence  int : Wizard's intelligence
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
     * calculate the total damage done by a Wizard
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
     *
     * display the fight conduct
     * @param C1    Characters : character who inflict damage
     * @param C2    Characters : character who received damage
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
