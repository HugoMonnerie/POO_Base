import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Application has started");

        ArrayList<Archetype> x0 = new ArrayList<Archetype>() ;

        Scanner sc1 = new Scanner(System.in);
        System.out.println("What do you want to do ? : ");
        String str1 = sc1.nextLine() ;


        if(!str1.equals("A") || !str1.equals("B") ||  !str1.equals("C") ||  !str1.equals("D") || !str1.equals("E") || !str1.equals("F") || !str1.equals("G")  ){
            System.out.println("Commande invalide , Rappel : ");
            CommandsManagement.help();

        }

        if(str1.equals("A") ){
            System.out.println("Numéro du personnage dont vous voulez obtenir les informations ?");
            Scanner sc2 = new Scanner(System.in);
            int y1 = sc2.nextInt() ;
            Archetype v1 = x0.get(y1) ;
            v1.toString();
        }

        if(str1.equals("D") ){
            CommandsManagement.leave();
        }

        if(str1.equals("E")){
            Archetype x1 = new Archetype();
            CommandsManagement.addArchetypeToList(x1,x0);

        }

        if(str1.equals("C")){
            System.out.println("a fight between two characters is going to start ");
            System.out.println("Enter the number of the two fighters");
            System.out.println("Fighter 1 : ");
            Scanner sc3 = new Scanner(System.in);
            int numeroPremiercombattant = sc3.nextInt() ;
            System.out.println("Fighter 2 : ");
            Scanner sc4 = new Scanner(System.in);
            int numeroDeuxiemeCombattant = sc4.nextInt();
            CommandsManagement.Start_A_Fight(x0,numeroPremiercombattant,numeroDeuxiemeCombattant) ;
        }

        if(str1.equals("F")){
            CommandsManagement.showCreatedArchetypes(x0);
        }

        if(str1.equals("G")){
            /* à faire un peu plus tard...  */
            System.out.println("name of the character ?");
            Scanner sc5 = new Scanner(System.in);
            String nameOfTheCharacter = sc5.nextLine();


            System.out.println("damages given to opponent ?");
            Scanner sc6 = new Scanner(System.in);
            int damagesGivenToOpponent = sc6.nextInt();
            System.out.println("Life Points of this new character ? ");
            Scanner sc7 = new Scanner(System.in);
            int lifePoints = sc7.nextInt();
            System.out.println("level of initiative of this new character ?");
            Scanner sc8 = new Scanner(System.in);
            int initiative = sc8.nextInt();
            System.out.println("number of creation of this new character ?");
            Scanner sc9 = new Scanner(System.in);
            int numberOfCreation = sc9.nextInt();

            Archetype x2 = new Archetype(nameOfTheCharacter,damagesGivenToOpponent,lifePoints,initiative,numberOfCreation);
            CommandsManagement.addArchetypeToList(x2,x0);




        }




    }
}