package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class sportWordBank extends wordBank{

    public sportWordBank() {}

    @Override
    public void init() {
        ArrayList<word> w = new ArrayList<>();
        try {
            BufferedReader readWordBank = new BufferedReader(new FileReader("sportswordbank.txt"));
            String line = readWordBank.readLine();
            while (line != null) {
                word curr = new word();
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
