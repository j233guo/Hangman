package hangman;

public class Word {
    private Letter[] letters;

    public Word() {}

    // Create a word from an existing array of letters
    public void setWord(Letter[] letters) {
        this.letters = letters;
    }

    // Create a word object from a string
    public void parseWord(String word) {
        String [] chars = word.split("");
        Letter[] letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            Letter l = new Letter(chars[i]);
            letters[i] = l;
        }
        this.letters = letters;
    }

    // return the word literally, as a string
    public String getWord() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.getLetter());
        }
        return result.toString();
    }

    public Letter[] getLetters () {
        return letters;
    }

    public boolean inWord(String letter) {
        boolean result = false;
        for (Letter value : letters) {
            if (value.getLetter().equals(letter)) {
                result = true;
                break;
            }
        }
        return result;
    }

    // set a letter in the word as guessed
    public void setGuess(String letter) {
        for (Letter value : letters) {
            if (value.getLetter().equals(letter)) {
                value.setGuessed();
            }
        }
    }

    public boolean fullyGuessed() {
        boolean result = true;
        for (Letter letter : letters) {
            if (!letter.isGuessed()) {
                result = false;
            }
        }
        return result;
    }

    public void printWord () {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.getPrintLetter());
        }
        System.out.println(result.toString());
    }
}
