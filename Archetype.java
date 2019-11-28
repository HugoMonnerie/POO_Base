import java.util.ArrayList;

public class Archetype {
    private String name ;
    private int damagesGivenToTheOpponent  ;
    private int lifePoints ;
    private int initiative ;

    private int numberOfCreation ;    //number of creation



    public Archetype(){
        this.name = "xxx" ;
        this.damagesGivenToTheOpponent = 1 ;
        this.lifePoints = 1 ;
        this.initiative = 1 ;
        this.numberOfCreation = -1 ;
        }


    public Archetype(String name , int damagesGivenToTheOpponent , int lifePoints , int initiative , int numberOfCreation){
        this.name = name ;
        this.damagesGivenToTheOpponent = damagesGivenToTheOpponent ;
        this.lifePoints = lifePoints ;
        this.initiative = initiative ;
        this.numberOfCreation = numberOfCreation ;
        }

    public String getName(){
        return this.name ;
    }

    public int getDamagesGivenToTheOpponent(){
        return this.damagesGivenToTheOpponent ;
    }

    public int getLifePoints(){
        return this.lifePoints ;
    }

    public int getInitiative() {
        return this.initiative;
    }

      public int getNumber(){return this.numberOfCreation ; }

    public String toString(){
        String a = " " + this.name  + " " + this.damagesGivenToTheOpponent + " " + this.lifePoints + " " + this.initiative + this.numberOfCreation ;
        return a ;

        }



        public static void attack(Archetype e38 , Archetype e39){
            e39.lifePoints = e39.lifePoints - e38.damagesGivenToTheOpponent ;
        }







}
