package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SportWordBank extends WordBank {

    public SportWordBank() {}

    @Override
    public void init() {
        ArrayList<Word> w = new ArrayList<>();
        try {
            BufferedReader readWordBank = new BufferedReader(new FileReader("sportswordbank.txt"));
            String line = readWordBank.readLine();
            while (line != null) {
                Word curr = new Word();
                curr.parseWord(line);
                w.add(curr);
                line = readWordBank.readLine();
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        this.words = w;
    }
}
