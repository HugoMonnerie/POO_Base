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
        ArrayList listCommand = new ArrayList();

        //liste of commands
        listCommand.add("exit");
        listCommand.add("help");
        listCommand.add("create");
        listCommand.add("create_warrior");
        listCommand.add("create_wizard");
        listCommand.add("create_rogue");
        listCommand.add("create_paladin");
        listCommand.add("stat");
        listCommand.add("give_all");
        listCommand.add("delete");
        listCommand.add("fight");


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

            if (action.equals(listCommand.get(0)) || action.equals("0")){
                isExit = Commands.exit();
            }
            else if (action.equals(listCommand.get(1)) || action.equals("1")){
                Commands.help(listCommand);
            }

            else if (action.equals(listCommand.get(2)) || action.equals("2")){
                listCharacters.add(Commands.create());
            }
            else if (action.equals(listCommand.get(3)) || action.equals("3"))
            {
                listCharacters.add(Commands.createWarrior());
            }

            else if (action.equals(listCommand.get(4)) || action.equals("4"))
            {
                listCharacters.add(Commands.createWizard());
            }
            else if (action.equals(listCommand.get(5)) || action.equals("5"))
            {
                listCharacters.add(Commands.createRogue());
            }
            else if (action.equals(listCommand.get(6)) || action.equals("6"))
            {
                listCharacters.add(Commands.createPaladin());
            }

            else if (action.equals(listCommand.get(7)) || action.equals("7")){
                System.out.println("enter character's id:");
                try{
                    id =sc.nextInt();
                    Commands.stat(listCharacters, id);

                }catch (Exception e){
                    System.out.println("you don't have entered a valid id");
                }
                action=sc.nextLine();
            }
            else if (action.equals(listCommand.get(8)) || action.equals("8")) {
                Commands.giveAll(listCharacters);
            }

            else if (action.equals(listCommand.get(9)) || action.equals("9"))
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

            else if(action.equals(listCommand.get(10)) || action.equals("10"))
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
                Commands.help(listCommand);
            }

        } while (!isExit);

        System.exit(0);

    }

}
