package main;

public class Game {
	Dice player;
	Dice computer;
	private int longStreak = 0;
	private int currStreak = 0;
	private int oppCurr = 0;
	private int oppLong = 0;
	private int points = 0;
	private int oppPoints = 0;
	private int Wins = 0;
	private int Loses = 0;
	private boolean running = true;
	
	public Game() {
		while(running) {
			gameStart();
		}
	}
	
	//stating game rules and getting dice sides along with 
	public void gameStart() {
		JOP.msg(
				"Rules:"
				+ "\n This is a dice rolling game, you can earn points by rolling dice and accumalting streaks, the higher the streak the higher your score"
				+ "\n\n Your score is calculated by taking the length of your streak and then multiplying it by the number you rolled"
				+ "\n Your goal is to get a higher score than the computer");
		int sides = getSides();
		player = new Dice(sides);
		computer = new Dice(sides);
		int rounds = getRounds();
		boolean playing = true;
		while(playing) {
			points = 0;
			oppPoints = 0;
			int prevRoll = 0;
			int prevOppRoll = 0;
			player.Roll();
			int tempcurr = currStreak;
			int templong = longStreak;
			int rerolls = 3;
			//beginning of every round
			for(int i = 0; i < rounds; i++) {
				player.Roll();
				computer.Roll();
				//set player streak statistic up
				if(player.getRoll() == prevRoll) {
					 tempcurr++;
				}
				else if(player.getRoll() != prevRoll) {
					tempcurr = 0;
				}
				if(tempcurr > longStreak) {
					templong = tempcurr;
				}
				
				
				//set the computer streaks up
				if(computer.getRoll() == prevOppRoll) {
					 oppCurr++;
				}
				else if(computer.getRoll() != prevOppRoll) {
					oppCurr = 0;
				}
				if(oppCurr > oppLong) {
					oppLong = oppCurr;
				}
				
				
				//beginning of the turn
				boolean state = true;
				while(state) {
					String input = JOP.in("You rolled:" + player.getRoll() 
					+ "\nCurrent Streak:" + tempcurr 
					+ "\nLongest Streak:" + templong
					+ "\n\n your opponent rolled:" + computer.getRoll()
					+ "\n\n you have " + rerolls + " rerolls left"
					+ "\n type 'r' to reroll"
					+ "\n\n type'n' to go to the next round"
					);					
					//rerolls	
					if(input.equalsIgnoreCase("r") && rerolls != 0) {
						player.Roll();
						rerolls--;
						
					}
					else if (rerolls == 0) {
						JOP.msg("you have no more rerolls");
					}
					//goes to next turn by setting variables and ending while loop
					if(input.equalsIgnoreCase("n")) {
						currStreak = tempcurr;
						longStreak = templong;
						prevOppRoll = computer.getRoll();
						prevRoll = player.getRoll();
						points += currStreak * player.getRoll();
						oppPoints += oppCurr * computer.getRoll();
						state = false;
					}
				}
			}
			
			//checks winner
			if (points>oppPoints) {
				Wins++;
				JOP.msg("you won"
						+"\nyour score: " + points
						+"\ncomputer score: " + oppPoints);
			}
			else if(points < oppPoints){
				Loses++;
				JOP.msg("you lost"
						+"\nyour score: " + points
						+"\ncomputer score: " + oppPoints);
			}
			else {
				JOP.msg("tie"
						+"\nyour score: " + points
						+"\ncomputer score: " + oppPoints);
			}
		}
	}
	
	//asks for input on the amount of sides the player wants
	private int getSides() {
		int sides;
		sides = Integer.parseInt(JOP.in(
				"Choose your dice type by typing the number of sides you want:"
				+ "\n4 sided"
				+ "\n6 sided"
				+ "\n8 sided"
				+ "\n10 sided"
				+ "\n12 sided"
				+ "\n20 sided"
				));
		if(!(sides == 4 || sides == 6 || sides == 8 || sides == 10 || sides == 12 || sides == 20)) {
			JOP.msg("That is not a valid dice option, try again.");
			sides = getSides();
		}
		return sides;
	}
	
	//ask for input on number of rounds wanted
	private int getRounds() {
		int rounds;
		rounds = Integer.parseInt(JOP.in(
				"Type any number between 3 and 10 to select the number of rounds"
				));
		if(!(rounds == (int)rounds && rounds <= 10 && rounds >= 3)) {
			JOP.msg("That is not a valid round number selection, try again.");
			rounds = getRounds();
		}
		return rounds;
	}
}
