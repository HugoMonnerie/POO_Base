package com.company;

import java.util.Random;

public class Paladin extends Warrior {
      private int mana;
      private int maxMana;
      private boolean isHealing =false;
      private int healValue;


    //#######################################################################################
    //##########################    Paladin constructor    ##################################
    //#######################################################################################
    /**
     * user's constructor of Paladin
     * @param name          String : Paladin's name
     * @param hp            int : Paladin's hp
     * @param power         int : Paladin's power
     * @param initiative    int : Paladin's initiative
     * @param shield        int : Paladin's shield
     * @param mana          int : Paladin's mana
     */
    public Paladin(String name, int hp, int power, int initiative , int shield, int mana){
        super(name, hp, power, initiative, shield);
        this.mana=mana;
        this.maxMana=mana;
    }




    //#######################################################################################
    //#############################    Paladin getter    ####################################
    //#######################################################################################
    /**
     * get the Paladin's shield value
     * @return int : shield
     */
    public int getMana(){
        return this.mana;
    }




    //#######################################################################################
    //##############################    fight Area    #######################################
    //#######################################################################################
    /**
     * calculate Paladin's damage taken with his shield, and the possibility to heal
     * @param damageDone    int : opponent's damage
     * @return              int : damage taken
     */
    public int calculateDamage(int damageDone){
        Random rand = new Random();
        damageDone =super.calculateDamage(damageDone);

        if (rand.nextInt(4)==1 && this.mana>=0) {
            this.healValue = 2*(this.maxMana-this.mana)+rand.nextInt(4*this.mana);

            if (this.getHp()<=this.getMaxHp()){

                if (this.healValue+this.getHp()>this.getMaxHp()){
                    this.healValue=this.getMaxHp()-this.getHp();
                }
                super.hurt(-this.healValue);
                this.isHealing=true;
                if (this.getHp()!=this.getMaxHp()) {
                    this.mana--;
                }

            }
        }

        else{
            this.isHealing=false;
        }
        return damageDone;
    }


    /**
     * restore all Paladin's stats
     */
    public void restore(){
        super.restore();
        this.mana=this.maxMana;
        this.isHealing=false;
    }




    //#######################################################################################
    //##############################    display Area    #####################################
    //#######################################################################################
    /**
     * display the fight conduct
     * @param C1    Characters : character who inflict damage
     * @param C2    Characters : character who received damage
     * @param turn  int : current turn
     * @return      String : containing the conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone =C2.hurt(C2.calculateDamage(C1.totalDamage(turn)));

        if (this.isHealing){
            System.out.println(C2.setColor() + C2.getName() + "\033[0m heal himself " + this.healValue + " hp.");
        }
        if (C1.doACritical){
            return C1.setColor() +C1.getName() + "\033[0m inflict only " + damageDone + " critical damage to " + C2.setColor() +C2.getName() + "\033[0m thanks to his shield. he have "  + C2.getHp() + " hp remaining";
        }
        return C1.setColor() +C1.getName() + "\033[0m inflict only " + damageDone + " damage to " + C2.setColor() +C2.getName() + "\033[0m thanks to his shield. he have "  +C2.getHp() + " hp remaining";
    }

}
