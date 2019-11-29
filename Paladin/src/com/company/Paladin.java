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
     * @param hp            int : Paladin's hp, when they pass trough 0, the character die
     * @param power         int : Paladin's power, representing the damage done by the character
     * @param initiative    int : Paladin's initiative, determinate which character attack in first place
     * @param shield        int : Paladin's shield, that reduce damage received by the chosen value
     * @param mana          int : Paladin's mana, more he have, more he could use heal
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
     * get the Paladin's mana value, representing how much time paladin could heal himself
     * @return int : mana
     */
    public int getMana(){
        return this.mana;
    }




    //#######################################################################################
    //##############################    fight Area    #######################################
    //#######################################################################################
    /**
     * calculate Paladin's damage taken with his shield, the possibility to heal and how much hp he can restore
     * @param damageDone    int : opponent's damage
     * @return              int : damage taken
     */
    public int calculateDamage(int damageDone){
        Random rand = new Random();
        damageDone =super.calculateDamage(damageDone);

        if (rand.nextInt(4)==1 && this.mana>0) {
            if(super.getHp()<=super.getMaxHp()/2) {
                this.healValue = 2 * (this.maxMana - this.mana) + rand.nextInt(4 * this.mana) % this.maxMana * 3;

                if (this.getHp() <= this.getMaxHp()) {

                    if (this.healValue + this.getHp() > this.getMaxHp()) {
                        this.healValue = this.getMaxHp() - this.getHp();
                    }
                    super.hpVar(-this.healValue);
                    if (this.getHp() != this.getMaxHp()) {
                        this.mana--;
                        this.isHealing = true;
                    }

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
     * display Paladin's stats
     * @return   String : containing his stats
     */
    public String toString(){
        return  super.toString() + super.setColor() + " |  mana: " + this.mana + " \033[0m\n";
    }


    /**
     * display the fight conduct. special message when Paladin is healing
     * @param C1    Characters : character who inflict damage
     * @param C2    Characters : character who received damage
     * @param turn  int : current turn
     * @return      String : containing the conduct
     */
    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone =C2.hpVar(C2.calculateDamage(C1.totalDamage(turn)));

        if (this.isHealing){
            System.out.println(C2.setColor() + C2.getName() + "\033[0m heal himself " + this.healValue + " hp.");
        }
        if (C1.doACritical){
            return C1.setColor() +C1.getName() + "\033[0m inflict only " + damageDone + " critical damage to " + C2.setColor() +C2.getName() + "\033[0m thanks to his shield. he have "  + C2.getHp() + " hp remaining";
        }
        return C1.setColor() +C1.getName() + "\033[0m inflict only " + damageDone + " damage to " + C2.setColor() +C2.getName() + "\033[0m thanks to his shield. he have "  +C2.getHp() + " hp remaining";
    }

}
