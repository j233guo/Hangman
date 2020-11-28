package hangman;

import java.util.ArrayList;

public class movieWordBank extends wordBank{

    public movieWordBank() {}

    final String[] wb = {"THE GODFATHER", "STAR WARS", "IRON MAN", "AVATAR", "IP MAN"};

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
