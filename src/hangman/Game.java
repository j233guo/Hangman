package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Game {
    private int numGuess = 10;
    private int currentLevel = 1;
    private WordBank words;
    private Word chosenWord;
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

    public Game(String category) {
        if (category.equals("1")) {
            System.out.println("You have chosen sports category!");
            this.words = new SportWordBank();
        } else if (category.equals("2")) {
            System.out.println("You have chosen movie category!");
            this.words = new MovieWordBank();
        } else if (category.equals("3")) {
            System.out.println("You have chosen Canadian Cities category!");
            this.words = new CanadianCityWordBank();
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

    public Word getChosenWord() {
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

    public void startGame() {
        Scanner input = new Scanner(System.in);
        while(true) {
            if (this.getCurrentLevel() == 6) {
                System.out.println("\nYOU WIN");
                break;
            } else if (this.getNumGuess() == 0) {
                System.out.println("\nYOU LOSE");
                break;
            } else {
                System.out.println("\nLevel " + this.getCurrentLevel());
                while (true) {
                    if (this.getChosenWord().fullyGuessed()) {
                        System.out.println(" ");
                        this.getChosenWord().printWord();
                        System.out.println("You passed level " + this.getCurrentLevel() + "!");
                        this.nextLevel();
                        break;
                    } else if (this.getNumGuess() > 0) {
                        System.out.println(" ");
                        this.getChosenWord().printWord();
                        this.printLetterBank();
                        System.out.println("Guess a character");
                        String guess = input.nextLine();
                        this.takeGuess(guess);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
