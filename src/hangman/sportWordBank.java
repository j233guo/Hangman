package hangman;

import java.util.ArrayList;

public class sportWordBank extends wordBank{

    public sportWordBank() {}

    final String[] wb = {"TENNIS", "SOCCER", "SWIMMING", "BASKETBALL", "SHOOTING"};

    @Override
    public void init() {
        ArrayList<word> w = new ArrayList<>();
        for (String s : wb) {
            word curr = new word();
            curr.parseWord(s);
            w.add(curr);
        }
        this.words = w;
    }
}
