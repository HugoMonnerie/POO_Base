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

            if (action.equals("exit")){
                isExit = Commands.exit();
            }
            else if (action.equals("help")){
                Commands.help();
            }
            else if (action.equals("create")){
                System.out.println("What is his class ?");
                System.out.println("0 : caca\n1 : Warrior\n2 : Wizzard\n3 : Rogue");

                if (action.equals("0")){
                    Commands.create(listCharacters);
                }
                else if (action.equals("1")){
                    Commands.warrior(listCharacters);
                }
                else if (action.equals("2")){
                    Commands.wizard(listCharacters);
                }
                else if (action.equals("3")){
                    Commands.rogue(listCharacters);
                }
                else {
                    System.out.println("This class don't exist");
                }

            }
            else if (action.equals("stat")){
                System.out.println("enter character's id:");
                id =sc.nextInt();
                Commands.stat(listCharacters, id);
                action=sc.nextLine();
            }
            else if (action.equals("giveAll")) {
                Commands.giveAll(listCharacters);
            }
            else if (action.equals("delete"))
            {
                System.out.println("enter character's id you want to delete:");
                id =sc.nextInt();
                Commands.delete(listCharacters, id);
                action=sc.nextLine();
            }
            else if (action.equals("fight")){

                System.out.println("enter first character's id");
                int id1 =sc.nextInt();

                System.out.println("enter secondary character's id");
                int id2 =sc.nextInt();

                System.out.println("Let the battle begin");
                Commands.fight(listCharacters, id1, id2);

            }
            else{
                System.out.println("this command doesn't exit, these commands are available:");
                Commands.help();
            }

        } while (!isExit);

        System.exit(0);

    }



}
