package com.company;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isExit = false;
        String action;

        System.out.println("Application has started");          //story #1
        Scanner sc = new Scanner(System.in);

        /**
         * while we don't want to quit, we check the action wanted by the user
         * @actions     stock the action wanted by the user
         * @isExit      check if the user want to quit
         */
        do {
            System.out.println("what do you want to do now?\n(help to have the commands liste)");
            action=sc.nextLine();

            if (action.equals("exit")){
                isExit = Commands.exit();
            }
            else if (action.equals("help")){
                Commands.help();
            }
            else{
                System.out.println("this command doesn't exit, these commands are available:");
                Commands.help();
            }

        } while (isExit==false);

        System.exit(0);

    }



}
