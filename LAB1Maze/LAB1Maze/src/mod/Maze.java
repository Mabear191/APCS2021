package mod;

public class Maze {

	//differnt 2d arrays that are supposed to represent mazes mapped with true and false 
	private boolean [][] _mazeOne =
		{
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false}
		};
	
	private boolean [][] _mazeTwo = 
		{
		{false,		false, 	true, 	true, 	false, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	false},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	true, 	false},
		{true,		true, 	true, 	true, 	false, 	false, 	false, 	false, 	true, 	false},
		{true,		true, 	false, 	true, 	false, 	false, 	false, 	false, 	true, 	false},
		{true,		true, 	false, 	true, 	true, 	false, 	true, 	false, 	true, 	false},
		{true,		true, 	false, 	false, 	true, 	false, 	true, 	false, 	true, 	false},
		{true,		true, 	false, 	false, 	true, 	false, 	true, 	false, 	true, 	false},
		{true,		false, 	false, 	false, 	true, 	false, 	true, 	true, 	true, 	false},
		{false,		false, 	false, 	false, 	true, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		};
	
	private boolean [][] _mazeThree = 
		{
		{false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		{false,		false, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	false},
		{false,		false, 	true, 	false, 	true, 	false, 	false, 	true, 	false, 	false},
		{false,		false, 	true, 	false, 	true, 	false, 	false, 	true, 	false, 	false},
		{false,		false, 	true, 	false, 	true, 	false, 	false, 	true, 	false, 	false},
		{true,		true, 	true, 	false, 	true, 	false, 	false, 	true, 	false, 	false},
		{true,		false, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	false},
		{true,		false, 	true, 	false, 	true, 	false, 	true, 	true, 	false, 	false},
		{true,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	false},
		{true,		false, 	false, 	false, 	true, 	false, 	false, 	false, 	true, 	false},
		{true,		false, 	false, 	false, 	true, 	true, 	true, 	false, 	true, 	false},
		{true,		false, 	false, 	false, 	false, 	false, 	true, 	true, 	true, 	false},
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	false},
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		};
	
	// private boolean[][][] _mazeList;
	// private int[][] _plyStartLocations;
	// private int[][] _minStartLocations;
	// private int[][] _exit;
	// private int[][] _sword;
	
	// currentLocations
	private int _currMaze = 0;
	private boolean[][][] _mazeList = {_mazeOne, _mazeTwo, _mazeThree};
	private int[][] _plyStartLocations = {{0,2}, {0,3}, {1,7}};
	private int[][] _minStartLocations = {{5,9}, {11,4}, {7,0}};
	private int[][] _exit = {{5,0}, {7,6}, {9,4}};
	private int[][] _sword = {{8,2}, {10,0}, {7,4}};
	//get methods for the positions of every important entity
	public boolean[][] getMaze() { return _mazeList[_currMaze]; }
	public int[] getPlyStart() { return _plyStartLocations[_currMaze]; }
	public int[] getMinStart() { return _minStartLocations[_currMaze]; }
	public int[] getExit() { return _exit[_currMaze]; }
	public int[] getSword() { return _sword[_currMaze]; }
	//a modifier method designed to select the mazes
	public void setCurMaze(int mazeNum) {
		if(mazeNum == 1) {
			_currMaze = 0;
		}
		else if (mazeNum == 2) {
			_currMaze = 1;
		}
		else if (mazeNum == 3) {
			_currMaze = 2;
		}
	}
}
