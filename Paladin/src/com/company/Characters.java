package com.company;

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
     * @return these damages value
     */
    public int hurt(int damageDone){
        return this.hp -= damageDone ;
    }


    /**
     * constructor of Characters
     */
    public Characters(String name, int power, int hp, int initiative){
        this.name=name;
        this.hp=hp;
        this.power=power;
        this.initiative=initiative;
    }

    public static void toString(String nameChar, int hpChar, int powerChar, int initiativeChar){

        System.out.println("Name Character = "+nameChar + "\nHP Character = "+hpChar + "\nPower Character = "+powerChar + "\nInitiative Character = c"+initiativeChar);
    }

    public static ListCharacter() {
        
    }


}
