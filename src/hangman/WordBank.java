package hangman;

import java.util.Random;
import java.util.ArrayList;

public abstract class WordBank {

    protected ArrayList<Word> words;

    public WordBank() {}

    public void init() {}

    // get a random word from word bank, and remove it from the word bank
    public Word getRandomWord() {
        Random randomNum = new Random();
        int index = randomNum.nextInt(words.size());
        Word w = words.get(index);
        words.remove(index);
        return w;
    }
}
