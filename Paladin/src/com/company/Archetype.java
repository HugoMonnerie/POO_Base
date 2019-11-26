package com.company;

public class Archetype {

        private String name;
        private int dammage;
        private int  hP;
        private int lead;




        public String getname() {
            return this.name;
        }
        public int getdammage() {
            return this.dammage;
        }
         public int gethP() {
             return this.hP;
         }
         public int getLead() {
             return this.lead;
         }


    public String toString(){
                 return getname()  + this.name +
                           getdammage()  + this.dammage +
                           gethP() + this.hP +
                           getLead() + this.lead;
             }

}

