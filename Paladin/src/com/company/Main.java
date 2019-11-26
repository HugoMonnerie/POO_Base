package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lire = new Scanner(System.in);
        String commands = lire.nextLine();

        while (!commands.equals("exit")) {

            if(!commands.equals("exit")) {

                Commands.help();

            }
            System.out.println("try again");
            commands = lire.nextLine();


        }
    }
}
