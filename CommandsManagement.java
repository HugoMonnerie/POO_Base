package com.company;

import java.util.ArrayList;

public class CommandsManagement {

    public static void help(){
        System.out.println("afficher les détails d'un personnage en entrant son numéro - A");
        System.out.println("supprimer un personnage de la liste - B");
        System.out.println("faire combattre 2 personnages en entrant les 2 numéros correspondants - C");
        System.out.println("Leave application - D");
        System.out.println("Create a character by default - E");
        System.out.println("Show all created characters since the beginning - F ");
        System.out.println("Create a real character - G");

    }

    public static void leave(){
        System.exit(0);
    }







    public static void addArchetypeToList(Archetype e1 , ArrayList<Archetype> e2){
        e2.add(e1) ;
        // To add a created character into the list
    }

    public static void showCreatedArchetypes(ArrayList<Archetype> e3){
        System.out.println(e3);
        //To show all created characters since the beginning (avec le numéro des personnages affichés aussi)
    }



    public static void Start_A_Fight(ArrayList<Archetype> e4 ,int a1 , int a2){
        Archetype j100 = e4.get(a1) ;
        Archetype j101 = e4.get(a2) ;
        int auTourDeQui = -2 ;
        /*if (j100.getInitiative() > j101.getInitiative()
         * {
         * archetype j = j101;
         * j101 = j100
         * j100 = jj101
         * }
         * J100 est le premier a attaquer
         *
         * */
        for(int i = 1 ; j100.getLifePoints() > 0 && j101.getLifePoints() > 0/*j100.getLifePoints() != 0 || j101.getLifePoints() != 0*/; i++){
            System.out.println("Round number " + i);
            if(i == 1) {

                if (j100.getInitiative() > j101.getInitiative()) {
                    Archetype.attack(j100, j101);
                    System.out.println(j100.getName() + " attacks " + j101.getName() + " ! " + " he gives " + j100.getDamagesGivenToTheOpponent() + " points of damages") ;
                    System.out.println(j101.getLifePoints() + " life points left for " + j101.getName());
                    auTourDeQui = 1 ;
                } else if (j101.getInitiative() > j100.getInitiative()) {
                    Archetype.attack(j101, j100);
                    System.out.println(j101.getName() + " attacks " + j100.getName() +  " ! "  + " he gives " + j101.getDamagesGivenToTheOpponent() + " points of damages") ;

                    System.out.println(j100.getLifePoints() + " life points left for " + j100.getName());
                    auTourDeQui = 2 ;
                } else {
                    double a = Math.random();
                    if (a >= 0.5) {
                        Archetype.attack(j100, j101);
                        System.out.println(j100.getName() + " attacks " + j101.getName() + " ! "  + " he gives " + j100.getDamagesGivenToTheOpponent() + " points of damages") ;
                        System.out.println(j101.getLifePoints() + " life points left for " + j101.getName());
                        auTourDeQui = 1 ;
                    } else {
                        Archetype.attack(j101, j100);
                        System.out.println(j101.getName() + " attacks" + j100.getName() + " ! "  + " he gives " + j101.getDamagesGivenToTheOpponent() + " points of damages") ;
                        System.out.println(j100.getLifePoints() + " life points left for " + j100.getName());
                        auTourDeQui = 2 ;
                    }
                }

            }

            else{
                if(auTourDeQui == 1){
                    Archetype.attack(j101,j100);
                    System.out.println(j101.getName() + " attacks " + j100.getName() + " ! "  + " he gives " + j101.getDamagesGivenToTheOpponent() + " points of damages") ;
                }
                if(auTourDeQui == 2){
                    Archetype.attack(j100,j101) ;
                    System.out.println(j100.getName() + " attacks " + j101.getName() + " ! "  + " he gives " + j100.getDamagesGivenToTheOpponent() + " points of damages") ;}

            }



            if(j100.getLifePoints() <= 0 ){
                System.out.println(j101.getName() + " a gagné ");
            }

            if(j101.getLifePoints() <= 0){
                System.out.println(j100.getName() + " a gagné ");
            }

        }
    }








}
