package hangman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f1 = new File("moviewordbank.txt");
        File f2 = new File("sportswordbank.txt");
        File f3 = new File("canadiancities.txt");
        if(!(f1.exists() && !f1.isDirectory()) ||
                !(f2.exists() && !f2.isDirectory()) ||
                !(f3.exists() && !f3.isDirectory())) {
            System.out.println("File missing, cannot start the application");
            return;
        }

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
                                    " 1. Sports\n 2. Movies \n 3. Canadian Cities");
                String categoryResponse;
                while(true) {
                    categoryResponse = input.nextLine();
                    if (categoryResponse.equals("1") ||
                            categoryResponse.equals("2") ||
                            categoryResponse.equals("3")) {
                        break;
                    } else {
                        System.out.println("That isn't an available category, please try again");
                    }
                }

                game currentGame = new game(categoryResponse);
                currentGame.startGame();

            } else if (response.equals("2")){ // read rules
                try {
                    BufferedReader rules = new BufferedReader(new FileReader("rules.txt"));
                    String line = rules.readLine();
                    while (line != null) {
                        System.out.println(line);
                        line = rules.readLine();
                    }
                } catch(Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }

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
