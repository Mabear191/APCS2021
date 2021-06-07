package view;

import mod.Maze;
import mod.Minotaur;
import mod.Player;

public class StringMap {

	//set characters for all the elements on the board to appear as 
	private final String _wall = "■";
	private final String _path = "□";
	private final String _ply = "P";
	private final String _min = "M";
	private final String _sword = "S";
	private final String _exit = "O";
	private final String _space = "     ";
	private Maze _maze;
	private Player _plyr;
	private Minotaur _mint;
	
	//gets maze, player and minotaur objects to use for the game
	public StringMap(Maze m, Player p, Minotaur t) {
		_maze = m;
		_plyr = p;
		_mint = t;
	}
	
	//map generation based on true and false 2d array in Maze.java
	public String generateMap() {
		 String map = "";
		 for(int r = 0; r < _maze.getMaze().length; r++) {
			 for(int c = 0; c < _maze.getMaze()[0].length; c++) {
				 if(_plyr.getRow() == r && _plyr.getCol() == c) {
					 map += _ply + _space;
				 }
				 else if(_mint.getRow() == r && _mint.getCol() == c) {
					 if(!_mint.isAlive()) {
						 map += _path + _space;
					 }
					 else
						 map += _min + _space; 
				 }
				 else if(_maze.getSword()[0] == r && _maze.getSword()[1] ==c) {
					 if(!_plyr.hasSword()) {
						 map += _sword + _space;
					 }
					 else
						 map += _path + _space; 

				 }
				 else if(_maze.getExit()[0] == r && _maze.getExit()[1] == c) {
					 map += _exit + _space; 
				 }
				 else if(_maze.getMaze()[r][c]) {
					 map += _path + _space;
				 }
				 else {
					map += _wall + _space; 
				 }
			 }
			 map += "\n";
		 }
		 map += "\n";
		
		 
		 
		 
		 //returns it to the call in string form
		 return map;
	}
	
}
