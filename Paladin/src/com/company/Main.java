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


        System.out.println("Application has started");
        Scanner sc = new Scanner(System.in);

        /**
         * while we don't want to quit, we check the action wanted by the user
         * @param actions           String : stock the action wanted by the user
         * @param isExit            boolean : check if the user want to quit
         * @param id                int : character's id , use to show his stat
         * @param listCharacters    ArrayList : usable characters list
         */
        do {
            System.out.println("\nwhat do you want to do now?\n(help to have the commands list)");
            action=sc.nextLine().toLowerCase();

            if (action.equals("exit") || action.equals("0")){
                isExit = Commands.exit();
            }
            else if (action.equals("help") || action.equals("1")){
                Commands.help();
            }

            else if (action.equals("create") || action.equals("2")){
                listCharacters.add(Commands.create());
            }
            else if (action.equals("createwarrior") || action.equals("3"))
            {
                listCharacters.add(Commands.createWarrior());
            }

            else if (action.equals("createwizard") || action.equals("4"))
            {
                listCharacters.add(Commands.createWizard());
            }
            else if (action.equals("createwogue") || action.equals("5"))
            {
                listCharacters.add(Commands.createRogue());
            }

            else if (action.equals("stat") || action.equals("6")){
                System.out.println("enter character's id:");
                try{
                    id =sc.nextInt();
                    Commands.stat(listCharacters, id);

                }catch (Exception e){
                    System.out.println("you don't have entered a valid id");
                }
                action=sc.nextLine();
            }
            else if (action.equals("giveall") || action.equals("7")) {
                Commands.giveAll(listCharacters);
            }

            else if (action.equals("delete") || action.equals("8"))
            {
                if (!listCharacters.isEmpty()) {

                    System.out.println("enter character's id you want to delete:");
                    try {
                        id = sc.nextInt();
                        if (listCharacters.size() > id - 1) {
                            Commands.delete(listCharacters, id);

                        } else {
                            System.out.println("there is nobody with this id");

                        }
                    }catch (Exception e){
                        System.out.println("you don't have entered a valid id");
                    }
                    action=sc.nextLine();
                }
                else
                {
                    System.out.println("there is nobody to fire");
                }
            }

            else if(action.equals("fight") || action.equals("9"))
            {
                if (listCharacters.size()>=2) {
                    System.out.println("enter fighter's id \nfighter's id 1:");
                    try {

                        id1 = sc.nextInt();
                        if (listCharacters.size() > id1 - 1) {

                            try {
                                System.out.println("fighter's id 2:");
                                id2 = sc.nextInt();
                                while (id1 == id2) {
                                    System.out.println(listCharacters.get(id1).getName() + " can't fight himself. enter an other id:");
                                    id2 = sc.nextInt();
                                }
                                Commands.fight(listCharacters, id1, id2);
                            } catch (Exception e) {
                                System.out.println("you don't have entered a valid id");
                            }
                        } else {
                            System.out.println("there is nobody with this id");
                        }
                    } catch (Exception e) {
                        System.out.println("you don't have entered a valid id");
                    }
                    action=sc.nextLine();
                }
                else {
                    System.out.println("not enough fighters for a fight");
                }
            }

            else{
                System.out.println("this command doesn't exit, these commands are available:");
                Commands.help();
            }

        } while (!isExit);

        System.exit(0);

    }

}
