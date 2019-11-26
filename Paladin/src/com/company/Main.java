package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isExit = false;
        String action;
        List<Characters> listCharacters = new ArrayList<>();
        int id;
        int id1;
        int id2;


        System.out.println("Application has started");          //story #1
        Scanner sc = new Scanner(System.in);

        /**
         * while we don't want to quit, we check the action wanted by the user
         * @param actions           stock the action wanted by the user
         * @param isExit            check if the user want to quit
         * @param id                character's id , use to show his stat
         * @param listCharacters    usable characters list
         */
        do {
            System.out.println("what do you want to do now?\n(help to have the commands list)");
            action=sc.nextLine();

            if (action.equals("exit") || action.equals("0")){
                isExit = Commands.exit();
            }
            else if (action.equals("help") || action.equals("1")){
                Commands.help();
            }
            else if (action.equals("create") || action.equals("2")){
                Commands.addToList(Commands.create(), listCharacters);
            }
            else if (action.equals("createWarior") || action.equals("3"))
            {
                Commands.addToList(Commands.createWarrior(), listCharacters);
            }
            else if (action.equals("createWizard") || action.equals("4"))
            {
                Commands.addToList(Commands.createWizard(), listCharacters);
            }
            else if (action.equals("stat") || action.equals("5")){
                System.out.println("enter character's id:");
                id =sc.nextInt();
                Commands.stat(listCharacters, id);
                action=sc.nextLine();
            }
            else if (action.equals("giveAll") || action.equals("6")) {
                Commands.giveAll(listCharacters);
            }
            else if (action.equals("delete") || action.equals("7"))
            {
                System.out.println("enter character's id you want to delete:");
                id =sc.nextInt();
                Commands.delete(listCharacters, id);
                action=sc.nextLine();
            }
            else if(action.equals("fight") || action.equals("8"))
            {
                System.out.println("enter fighter's id ");
                id1 =sc.nextInt();
                id2 =sc.nextInt();
                Commands.fight(listCharacters, id1, id2);
                action=sc.nextLine();
            }
            else{
                System.out.println("this command doesn't exit, these commands are available:");
                Commands.help();
            }

        } while (!isExit);

        System.exit(0);

    }



}
