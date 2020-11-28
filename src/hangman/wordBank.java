package hangman;

import java.util.Random;
import java.util.ArrayList;

public abstract class wordBank {

    protected ArrayList<word> words;

    public wordBank() {}

    public void init() {}

    // get a random word from word bank, and remove it from the word bank
    public word getRandomWord() {
        Random randomNum = new Random();
        int index = randomNum.nextInt(words.size());
        word w = words.get(index);
        words.remove(index);
        return w;
    }
}
