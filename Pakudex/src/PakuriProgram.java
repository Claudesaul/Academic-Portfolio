//This project  will  provide  students  with  practice  building  and  working  with object-oriented  programming
//  constructs including classes and objects by building classes to represent creatures and a cataloguing system
//Claude Saul Belizaire


import java.util.*;

public class PakuriProgram {
    //Create menu method
    public static void menu() {
        System.out.println("\nPakudex Main Menu");
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit\n");
        System.out.print("What would you like to do? ");


    }
    public static void main(String[] args) {
        //Declare and initialize variables
        Scanner input = new Scanner(System.in);
        int numPak = 0, option = 0;
        String show, add, evolve;

        //Welcome user and prompt for input
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

        //Loop to check for input validity
        while (true) {
            System.out.print("Enter max capacity of the Pakudex: ");
            try{
                Object ob = input.next();
                numPak = Integer.parseInt(ob.toString());

                if (numPak  < 0) {
                    System.out.println("Please enter a valid size.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
            }
        }


        System.out.println("The Pakudex can hold " + numPak + " species of Pakuri.");
        Pakudex pakudex = new Pakudex(numPak);

        //Create a loop to only exit when the user selects option 6
        while(option != 6) {

            //Present the menu to the user and prompt them for their choice
            try {
                menu();
                option = input.nextInt();
                if (option < 1 || option > 6) {
                    System.out.println("Unrecognized menu selection!");
                    menu();
                    option = input.nextInt();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Unrecognized menu selection!");
                input.next();
            }

            switch (option) {
                //Case to show Pakuris
                case 1:
                    String[] listP = pakudex.getSpeciesArray();
                    if (pakudex.getSpeciesArray() != null) {
                        System.out.println("Pakuri In Pakudex:");
                        for (int i = 0; i < listP.length; i++) {
                            System.out.println((i + 1) + ". " + listP[i]);
                        }
                    } else {
                        System.out.println("No Pakuri in Pakudex yet!");
                    }
                    break;

                //Case to display pakuri and stats
                case 2:
                    System.out.print("Enter the name of the species to display: ");
                    show = input.next();
                    int[] stats = pakudex.getStats(show);
                    if (stats == null) {
                        System.out.println("Error: No such Pakuri!");
                    } else {
                        System.out.println("\nSpecies: " + show);
                        System.out.println("Attack: " + stats[0]);
                        System.out.println("Defense: " + stats[1]);
                        System.out.println("Speed: " + stats[2]);
                    }
                    break;

                //Case to add Pakuri
                case 3:
                    if (pakudex.getCapacity() == pakudex.getSize()) {
                        System.out.println("Error: Pakudex is full!");
                    }
                    else {
                        System.out.print("Enter the name of the species to add: ");
                        add = input.next();
                        pakudex.addPakuri(add);
                    }
                    break;

                //Case to evolve Pakuri
                case 4:
                    System.out.print("Enter the name of the species to evolve: ");
                    evolve = input.next();
                    if (pakudex.evolveSpecies(evolve)) {
                        System.out.println(evolve + " has evolved!");
                    }
                    else {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;

                //Case to sort Pakuri
                case 5:
                    pakudex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;
            }

        }
        System.out.println("Thanks for using Pakudex! Bye!");


    }
}
