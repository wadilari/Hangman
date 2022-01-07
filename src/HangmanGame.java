import java.util.Scanner;

public class HangmanGame {
    private Scanner sc = new Scanner(System.in);

    private String word;
    private String used = "";
    private int mistakes = 0;

    private String[] solutionArray;
    private String[] discoveredArray;

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

        boolean running = true;
        while (running) {
            this.round();
            System.out.println("Möchtest du noch eine Runde spielen? [Ja/Nein]:");
            if (sc.next().toLowerCase().equals("nein")) {
                running = false;
            }
        }
    }

    /**
     *
     */
    public void round() {
        this.used = "";
        this.mistakes = 0;
        boolean finished = false;
        this.insertWord();

        for (int i = 0; i <12; i++) {
            System.out.println();
        }

        while(!finished){
            this.printDiscoveryState();
            String guess = this.insertGuess();
            if(this.checkGuessUsed(guess)){
                mistakes++;
                System.out.println("Du hast diesen Buchstaben schon benutzt.");
            } else {
                used += guess;
                if(!this.checkGuessWord(guess)){
                    mistakes++;
                    System.out.println("Falscher Buchstabe!");
                }
            }
            this.draw();
            finished = this.checkFinished();
        }
    }

    public void insertWord() {
        boolean isValid = false;
        System.out.println("Bitte gebe das Wort ein:");
        String word = "";
        while(!isValid) {
            word = sc.next();
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
        this.word = word;

        this.solutionArray = new String[word.length()];
        this.discoveredArray = new String[word.length()];

        int i = 0;
        for (char c :
                word.toCharArray()) {
            solutionArray[i] = String.valueOf(c);
            discoveredArray[i] = "_";
            i++;
        }
    }

    public String insertGuess() {
        boolean isValid = false;
        System.out.println("Bitte gebe einen Buchstaben ein:");
        String guess = "";
        while(!isValid){
            guess = sc.next();
            if(guess.length() ==1){
                isValid = true;
            }
            else{
                System.out.println("Bitte gebe nur EINEN Buchstaben ein.");
            }
        }
        return guess.toLowerCase();
    }

    public boolean checkGuessUsed(String guess){
        return this.used.contains(guess);
    }

    public boolean checkGuessWord(String guess){
        if (this.word.contains(guess)) {
            for (int i = 0; i < solutionArray.length; i++) {
                if (solutionArray[i].equals(guess)) {
                    discoveredArray[i] = guess;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void draw() {
        if (this.mistakes == 1) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (this.mistakes == 2) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (this.mistakes == 3) {
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
        if (this.mistakes == 4) {
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
        if (this.mistakes == 5) {
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
        if (this.mistakes == 6) {
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
        if (this.mistakes == 7) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
    }

    public void printDiscoveryState() {
        System.out.println();
        for (String s :
                discoveredArray) {
            System.out.print(s);
            System.out.print(" ");
        }
        System.out.println();
    }

    public boolean checkFinished() {
        if (mistakes >= 7) {
            System.out.println("Du hast verloren!");
            return true;
        }
        for (String s :
                discoveredArray) {
            if (s.equals("_")) {
                return false;
            }
        }
        System.out.println("Du hast gewonnen!");
        this.printDiscoveryState();
        return true;
    }
}
