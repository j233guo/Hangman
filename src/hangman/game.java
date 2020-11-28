package hangman;

import java.util.ArrayList;
import java.util.Arrays;

public class game {
    private int numGuess = 10;
    private int currentLevel = 1;
    private wordBank words;
    private word chosenWord;
    private ArrayList<String> letterBank = new ArrayList<>();
    private ArrayList<String> incorrectLetter = new ArrayList<>();

    final String[] graphics = {"=========",
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "=========",};

    final String[] allLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private void initLetterBank() {
        letterBank = new ArrayList<>();
        letterBank.addAll(Arrays.asList(allLetters).subList(0, 26));
    }

    public game(String category) {
        if (category.equals("1")) {
            System.out.println("You have chosen sports category!");
            this.words = new sportWordBank();
        } else {
            System.out.println("You have chosen movie category!");
            this.words = new movieWordBank();
        }
        words.init();
        initLetterBank();
        this.chosenWord = words.getRandomWord();
        System.out.println("Pass 5 levels to win the game!");
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getNumGuess() {
        return numGuess;
    }

    public word getChosenWord() {
        return chosenWord;
    }

    public void nextLevel() {
        this.currentLevel += 1;
        if (this.currentLevel <= 5) {
            this.chosenWord = this.words.getRandomWord();
            this.numGuess = 10;
            initLetterBank();
            incorrectLetter = new ArrayList<>();
        }
    }

    public void printLetterBank() {
        System.out.print("Available letters: ");
        for (String s : letterBank) {
            System.out.print(s + " ");
        }
        System.out.print("\nIncorrect letters: ");
        for (String s : incorrectLetter) {
            System.out.print(s + " ");
        }
        System.out.print("\n");
    }

    public void takeGuess(String l) {

        String upperL = l.toUpperCase();

        if (letterBank.contains(upperL)) {

            letterBank.remove(upperL);

            if (chosenWord.inWord(upperL)) {
                chosenWord.setGuess(upperL);
                System.out.println("\nCorrect!");
            } else {
                numGuess -= 1;
                incorrectLetter.add(upperL);

                if (numGuess == 0) {
                    System.out.println("\n" + graphics[9]);
                } else {
                    System.out.println("\n" + graphics[9 - numGuess]);
                    System.out.println("You have " + numGuess + " chances left");
                }
            }
        } else {
            System.out.println("You cannot choose " + upperL + ", try again");
        }
    }
}
