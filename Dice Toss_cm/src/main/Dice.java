package main;

public class Dice {
	
	private int sides;
	private int roll;
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	//set the roll value to a random value depending on the sides
	public void Roll() {
		roll = (int)((Math.random()*sides) + 1);
	}
	
	//returns random roll
	public int getRoll() {
		return roll;
	}

}
