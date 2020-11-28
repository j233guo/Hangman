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

            if (response.equals("1")) {

                // <----- Game Execution Starts ----->

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

                while(true) {
                    if (currentGame.getCurrentLevel() == 6) {
                        System.out.println("\nYOU WIN");
                        break;
                    } else if (currentGame.getNumGuess() == 0) {
                        System.out.println("\nYOU LOSE");
                        break;
                    } else {
                        System.out.println("\nLevel " + currentGame.getCurrentLevel());
                        while(true) {
                            if (currentGame.getChosenWord().fullyGuessed()) {
                                System.out.println(" ");
                                currentGame.getChosenWord().printWord();
                                System.out.println("You passed level " + currentGame.getCurrentLevel() + "!");
                                currentGame.nextLevel();
                                break;
                            } else if (currentGame.getNumGuess() > 0) {
                                System.out.println(" ");
                                currentGame.getChosenWord().printWord();
                                currentGame.printLetterBank();
                                System.out.println("Guess a character");
                                String guess = input.nextLine();
                                currentGame.takeGuess(guess);
                            } else {
                                break;
                            }
                        }
                    }
                }

                // <------ Game Execution Ends ------>

            } else if (response.equals("2")){
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
            } else if (response.equals("3")) {
                System.out.println("Quitting..");
                return;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
    }
}
