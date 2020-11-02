package hangman;

public class word {
    private letter[] letters;

    public word() {}

    public word(letter[] letters) {
        this.letters = letters;
    }

    // Create a word from an existing array of letters
    public void setWord(letter[] letters) {
        this.letters = letters;
    }

    // Create a word object from a string
    public void parseWord(String word) {
        String [] chars = word.split("");
        letter [] letters = new letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letter l = new letter(chars[i]);
            letters[i] = l;
        }
        this.letters = letters;
    }

    // return the word literally, as a string
    public String getWord() {
        StringBuilder result = new StringBuilder();
        for (hangman.letter letter : letters) {
            result.append(letter.getLetter());
        }
        return result.toString();
    }

    public letter[] getLetters () {
        return letters;
    }

    public boolean inWord(String letter) {
        boolean result = false;
        for (hangman.letter value : letters) {
            if (value.getLetter().equals(letter)) {
                result = true;
                break;
            }
        }
        return result;
    }

    // set a letter in the word as guessed
    public void setGuess(String letter) {
        for (hangman.letter value : letters) {
            if (value.getLetter().equals(letter)) {
                value.setGuessed();
            }
        }
    }

    public boolean fullyGuessed() {
        boolean result = true;
        for (hangman.letter letter : letters) {
            if (!letter.isGuessed()) {
                result = false;
            }
        }
        return result;
    }

    public void printWord () {
        StringBuilder result = new StringBuilder();
        for (hangman.letter letter : letters) {
            result.append(letter.getPrintLetter());
        }
        System.out.println(result.toString());
    }
}
