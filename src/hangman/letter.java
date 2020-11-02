package hangman;

public class letter {
    private String letter;
    private Boolean guessed;

    public letter() {}

    // a letter is not guessed by default, unless its a blank space
    public letter(String letter) {
        this.letter = letter;
        if (letter.equals(" ")) {
            this.guessed = true;
        } else {
            this.guessed = false;
        }
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setGuessed() {
        this.guessed = true;
    }

    public String getLetter() {
        return letter;
    }

    public Boolean isGuessed() {
        return guessed;
    }

    public String getPrintLetter() {
        if (this.guessed) {
            return letter;
        } else {
            return "-";
        }
    }
}
