package com.company;

import java.util.ArrayList;

public class Characters {
    private String name;
    private int hp;
    private int power;
    private int initiative;

    /**
     * get the name of the character
     * @return character's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * get the hearth points of the character
     * @return character's hp
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * get the power of the character
     * @return character's power
     */
    public int getPower(){
        return this.power;
    }

    /**
     * get the initiative of the character
     * @return character's initiative
     */
    public int getInitiative(){
        return this.initiative;
    }

    /**
     * calcul of damages inflict by the character
     * @return hp remaining after applying damage value
     */
    public int hurt(int damageDone){
        return this.hp = this.hp-damageDone ;
    }

    /**
     * constructor of character
     * @param name          character's name
     * @param hp            character's hp
     * @param power         character's power
     * @param initiative    character's initiative
     */
    public Characters(String name, int hp, int power, int initiative){
        this.name=name;
        this.hp=hp;
        this.power=power;
        this.initiative=initiative;

    }

    /**
     * display character's information
     */
    public String toString(){
        return "name: " + this.getName() + " |  hp: " + this.getHp() + " |  power: " + this.getPower() + " |  initiative: " + this.getInitiative();
    }

}
