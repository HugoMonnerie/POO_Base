package com.company;

public class Characters {
    private String name;
    private int hp;
    private int maxHp;
    private int power;
    private int initiative;
    protected boolean doACritical;


    //#######################################################################################
    //########################    characters constructors    ################################
    //#######################################################################################
    /**
     * user's constructor of characters
     * @param name          String : character's name
     * @param hp            int : character's hp, when they pass trough 0, the character die
     * @param power         int : character's power, representing the damage done by the character
     * @param initiative    int : character's initiative, determinate which character attack in first place
     */
    public Characters(String name,  int hp, int power, int initiative){
        this.name=name;
        this.hp=hp;
        this.maxHp=hp;
        this.power=power;
        this.initiative=initiative;
        this.doACritical=false;
    }





    //#######################################################################################
    //###########################    character getters    ###################################
    //#######################################################################################
    /**
     * get the character's name
     * @return int : character's name
     */
    public String getName(){
        return this.name;
    }


    /**
     * get the character's hearth points
     * @return int : character's hp
     */
    public int getHp(){
        return this.hp;
    }


    /**
     * get the character's max hearth points
     * @return int : character's max hp
     */
    public int getMaxHp(){
        return this.maxHp;
    }


    /**
     * get the character's power
     * @return int : character's power
     */
    public int getPower(){
        return this.power;
    }


    /**
     * get the character's initiative
     * @return int : character's initiative
     */
    public int getInitiative(){
        return this.initiative;
    }




    //#######################################################################################
    //############################     fighting Area     ####################################
    //#######################################################################################
    /**
     * calculate hp remaining after an action (damage or heal)
     * @param hpVariation   int : hp variation for a character
     * @return              int : the hp variation
     */
    public int hpVar(int hpVariation){
        this.hp=this.hp-hpVariation;
        return hpVariation;
    }


    /**
     * restore the wounded character's hp
     */
    public void restore(){
        this.hp=this.maxHp;
    }


    /**
     * calculate damage received by a character
     * @param damageDone    int : damage done by a character
     * @return              int : the damage done
     */
    public int calculateDamage(int damageDone){
        return damageDone;
    }


    /**
     * calculate the total damage done by a character
     * @param turn  int : number of the current turn
     * @return      int : the damage done
     */
    public int totalDamage(int turn){
        return this.getPower();
    }


    /**
     * check if a character is dead, show the looser and the winner
     * @param C1        Characters : character which could be dead
     * @param C2        Characters : character which could win
     * @return          boolean : true if C1 is Alive
     */
    public boolean isDead(Characters C1, Characters C2){
        if (C1.getHp()<=0)
        {
            System.out.println( "\033[31m" + C1.getName() + " is down\n\033[36m" + C2.getName() + C2.displayClass() + " is victorious\n\033[0m");
            return false;
        }
        return true;
    }





    //#######################################################################################
    //############################    displaying area    ####################################
    //#######################################################################################
    /**
     * display character's stats
     * @return  String : containing his stats
     */
    public String toString(){
        return "name: " + this.name + " |  hp: " + this.hp + " |  power: " + this.power + " |  initiative: " + this.initiative ;
    }


    /**
     * display the fight conduct
     * @param C1    Characters : character which inflict damage
     * @param C2    Characters : character which received damage
     * @param turn  int : current turn
     * @return      String : containing the fight conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone =C2.hpVar(C2.calculateDamage(C1.totalDamage(turn)));

        if (C1.doACritical){
            return C1.setColor() +C1.getName() + "\033[0m inflict " + damageDone + " critical damage to " + C2.setColor() +C2.getName() + "\033[0m. he have "  + C2.getHp() + " hp remaining";
        }

        return C1.setColor() + C1.getName() + "\033[0m inflict " + damageDone + " damage to " + C2.setColor() +C2.getName() + "\033[0m. he have "  + C2.getHp() + " hp remaining";
    }


    /**
     * display the character's Class
     * @return String : containing nothing for a common Character
     */
    public String displayClass(){
        return "";
    }


    /**
     * using to set text color
     * @return String : containing the color wanted, white for a common character
     */
    public String setColor(){
        return"\033[0m";
    }

}
