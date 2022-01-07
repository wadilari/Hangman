import java.util.Scanner;

public class HangmanGame {

    private Scanner sc = new Scanner(System.in);
    private String word;
    private String used;

    public static void main(String[] args) {

        HangmanGame game = new HangmanGame();
        game.run();

    }

    /**
     * Hauptmethode, startet das Spiel und beendet es, wenn es keine weitere Runde geben soll.
     */
    public void run() {
        System.out.println("Willkommen bei Hangman!");
        System.out.println("");
        this.round();
    }

    /**
     *
     */
    public void round() {
        boolean finished = false;
        this.word = this.insertWord();
        while(!finished){
            String guess = this.insertGuess();
            if(this.checkGuessUsed(guess) == true){
                this.draw();
                System.out.println("Du hast diesen Buchstaben schon benutzt.");
                continue;
            }
            used = used + guess;
            if(this.checkGuessWord(guess) == true){

            }
        }

        return;
    }

    public String insertWord() {
        boolean isValid = false;
        System.out.println("Bitte gebe das Wort ein:");
        String word = sc.next();
        while(!isValid) {
            if (word.length() > 2 && word.length() <= 32) {
                isValid = true;
            } else {
                if(word.length() > 32){
                    System.out.println("Das Wort ist leider zu lang!");
                }
                else{
                    System.out.println("Das Word ist leider zu kurz!");
                }
            }
        }
        word = word.toLowerCase();
        return word;
    }

    public String insertGuess() {
        boolean isValid = false;
        System.out.println("Bitte gebe einen Buchstaben ein:");
        String guess = sc.next();
        while(!isValid){
            if(guess.length() ==1){
                isValid = true;
            }
            else{
                System.out.println("Bitte gebe nur EINEN Buchstaben ein.");
            }
        }
        return guess;
    }

    public boolean checkGuessUsed(String guess){
        return this.used.contains(guess);
    }

    public boolean checkGuessWord(String guess){
        return this.word.contains(guess);
    }

    public static void draw() {
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + word);
        }
    }
}
