package main;

import java.awt.*;

public class Controller {
    String playerOrComputer;
    boolean running = true;
    Player Player1 = new Player();
    Player Player2 = new Player();
    Player Computer = new Player();

    public Controller() {
        while (true){
            playerOrComputer = JOP.in("Enter pvp to play player vs or pvc to play against the computer" +
            		"\nPlayer One Highscore:"+ Player1.getHighScore() + 
            		"\nPlayer Two Highscore: " + Player2.getHighScore() +
            		"\nComputer Highscore: " + Computer.getHighScore());
            update();
        }
    }
    public void update(){
    	//this is essentially takes the input from earlier and then depending on it, selects the game mode
        running = true;
        if(playerOrComputer.equalsIgnoreCase("pvp")){
            playerVsPlayer();
        } else if(playerOrComputer.equalsIgnoreCase("pvc")){
            playerVsComputer();
        } else{
            playerOrComputer = "";
            JOP.msg("Enter either pvp or pvc or click cancel to quit.");
        }

    }
    //show's scores and then requests a guess for both player1 and player2 objects
    public void playerVsPlayer(){
        while(running){
            JOP.msg("Player one has " + Player1.getScore() + 
            		"\nPlayer two has " + Player2.getScore());
            JOP.msg("It's player one's turn!");
            Player1.inputGuess();
            JOP.msg("It's player two's turn!");
            Player2.inputGuess();
            getWinnerPVP();
            playerOrComputer = "";
        }
    }
    //show's scores and then gets the player object guess and compares it with the output of the computer guess method which would be random
    public void playerVsComputer(){
        while(running){
            JOP.msg("The current score for Player One is: " + Player1.getScore() + "." +
            		"\nThe current score for the Computer is: " + Computer.getScore() + ".");
            JOP.msg("It's your turn player one!");
            Player1.inputGuess();
            JOP.msg("It's the computer's turn!");
            Computer.computerGuess();
            getWinnerPVC();
            playerOrComputer = "";
        }
    }

    //gets winner in case of player versus player
    public void getWinnerPVP(){
        if(Player1.getGuess().equalsIgnoreCase("rock") && Player2.getGuess().equalsIgnoreCase("paper")){
            Player2.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and player two guessed " + Player2.getGuess() + "." +
            		"\nPlayer two wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("paper") && Player2.getGuess().equalsIgnoreCase("scissors")){
            Player2.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and player two guessed " + Player2.getGuess() + "." + 
            		"\nPlayer two wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Player2.getGuess().equalsIgnoreCase("rock")){
            Player2.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and player two guessed " + Player2.getGuess() + "." + 
            		"\nPlayer two wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("paper") && Player2.getGuess().equalsIgnoreCase("rock")){
            Player1.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and player two guessed " + Player2.getGuess() + "." + 
            		"\nPlayer one wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Player2.getGuess().equalsIgnoreCase("paper")){
            Player1.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and player two guessed " + Player2.getGuess() + "." +
            		"\nPlayer one wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("rock") && Player2.getGuess().equalsIgnoreCase("scissors")){
            Player1.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and player two guessed " + Player2.getGuess() + "." +
            		"\nPlayer one wins the round!");
        } else{
            JOP.msg("It's a tie! On to the next round.");
        }
        if(Player1.getScore() >= 2){
            Player2.resetHighScore();
            Player2.resetRoundScore();
            Player1.resetRoundScore();
            Player1.incrementHighScore();
            JOP.msg("Player one wins the game!");
            running = false;
        }
        if(Player2.getScore() >= 2){
            Player1.resetHighScore();
            Player1.resetRoundScore();
            Player2.resetRoundScore();
            Player2.incrementHighScore();
            JOP.msg("Player two wins the game!");
            running = false;
        }
    }
    //does a series of checks to get the winner in a player versus computer scenario
    public void getWinnerPVC(){
        if(Player1.getGuess().equalsIgnoreCase("rock") && Computer.getGuess().equalsIgnoreCase("paper")){
            Computer.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and computer guessed " + Computer.getGuess() + "." + 
            		"\nComputer wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("paper") && Computer.getGuess().equalsIgnoreCase("scissors")){
            Computer.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and computer guessed " + Computer.getGuess() + "." + 
            		"\nComputer wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Computer.getGuess().equalsIgnoreCase("rock")){
            Computer.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and computer guessed " + Computer.getGuess() + "." + 
            		"\nComputer wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("paper") && Computer.getGuess().equalsIgnoreCase("rock")){
            Player1.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and computer guessed " + Computer.getGuess() + "." + 
            		"\nPlayer one wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Computer.getGuess().equalsIgnoreCase("paper")){
            Player1.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and computer guessed " + Computer.getGuess() + "." + 
            		"\nPlayer one wins the round!");
        } else if(Player1.getGuess().equalsIgnoreCase("rock") && Computer.getGuess().equalsIgnoreCase("scissors")){
            Player1.increment();
            JOP.msg("Player one guessed " + Player1.getGuess() + " and computer guessed " + Computer.getGuess() + "." +
            		"\nPlayer one wins the round!");
        } else{
            JOP.msg("It's a tie! On to the next round.");
        }
        if(Computer.getScore() >= 2){
            Player1.resetHighScore();
            Player1.resetRoundScore();
            Computer.resetRoundScore();
            Computer.incrementHighScore();
            JOP.msg("Computer wins the game!");
            running = false;
        }
        if(Player1.getScore() >= 2){
            Computer.resetHighScore();
            Computer.resetRoundScore();
            Player1.resetRoundScore();
            Player1.incrementHighScore();
            JOP.msg("Player one wins the game!");
            running = false;
        }
    }
}