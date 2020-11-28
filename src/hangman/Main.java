package hangman;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("********** HANGMAN by Jiaming Guo **********");

        while(true) {
            System.out.println("\nMENU\n" +
                    " 1. Start the game\n" +
                    " 2. View the rules of the game\n" +
                    " 3. Quit\n" +
                    "Please select an option (enter 1, 2 or 3)");
            String response = input.nextLine();

            if (response.equals("1")) { // game execution
                System.out.println("\nPlease select a word category (enter 1 or 2)\n" +
                                    " 1. Sports\n 2. Movies");
                String categoryResponse;
                while(true) {
                    categoryResponse = input.nextLine();
                    if (categoryResponse.equals("1") || categoryResponse.equals("2")) {
                        break;
                    } else {
                        System.out.println("That isn't an available category, please try again");
                    }
                }

                game currentGame = new game(categoryResponse);
                currentGame.startGame();

            } else if (response.equals("2")){ // read rules
                System.out.println("There should be a file here, I will change this later.");
                System.out.println("Enter 0 to return to main menu");
                while (true) {
                    String ruleResponse = input.nextLine();
                    if (ruleResponse.equals("0")) {
                        break;
                    } else {
                        System.out.println("Enter 0 to return to main menu");
                    }
                }
            } else if (response.equals("3")) { // quit game
                System.out.println("Quitting..");
                return;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
    }
}
