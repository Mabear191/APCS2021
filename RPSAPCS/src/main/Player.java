package main;

import java.util.Random;
public class Player {
    private String guess;
    private int roundScore;	
    private int highScore;

    public Player() {
        roundScore = 0;
        highScore = 0;
    }

    //getter methods to display roundScore and highScore
    public int getScore() {return roundScore;}
    public int getHighScore() {return highScore;}

    //easier methods to modify scores
    public void increment() { roundScore++; }

    public void incrementHighScore(){ highScore += 1; }

    public void resetRoundScore(){ roundScore = 0; }

    public void resetHighScore(){
        highScore = 0;
    }

    Random random = new Random();
    //getting the player guess
    public void inputGuess(){
        boolean valid = false; //Variable that becomes true if the string input is correct
        while(!valid) {
            guess = JOP.in("Pick rock, paper or scissors.");
            if (!guess.equalsIgnoreCase("rock") && !guess.equalsIgnoreCase("paper") && !guess.equalsIgnoreCase("scissors")) {
                JOP.msg("Enter a valid input.");
            } else {
                valid = true;
            }
        }
    }
    //gets the computer guess
    public void computerGuess(){
        //0 is rock, 1 is paper, 2 is scissors
        int computerNum = random.nextInt(2);
        if(computerNum == 0){ guess = "rock"; }
        else if(computerNum == 1){ guess = "paper"; }
        else { guess = "scissors"; }
    }
    
    //returns guess
    public String getGuess(){
        return this.guess;
    }

}