package com.company;

public class Wizard extends Characters{
    private int intelligence;
    private int maxIntelligence;



    public Wizard(String name, int hp, int power, int initiative , int intelligence){
        super(name, hp, power, initiative);
        this.intelligence=intelligence;
        this.maxIntelligence=intelligence;
    }

    public int getIntelligence(){
        return this.intelligence;
    }

    public String toString(){
        return super.toString() +" |  intelligence: " + this.intelligence +"\n";
    }

    public int totalDamage(int tour){
        return (int)(this.getPower()+this.intelligence/(Math.pow(2, tour)));
    }


    public String displayFight(Characters C1, Characters C2, int turn){
        int damageDone =C2.hurt(C2.calculateDamage(C1.totalDamage(turn)));
        return C1.getName() + " inflict " + damageDone + " damage to " +C2.getName() + ". he have "  + C2.getHp() + " hp remaining";

    }


    /**
     *
     * @return
     */
    public String displayClass(){
        return " the " + this.getClass().getSimpleName();
    }

}
