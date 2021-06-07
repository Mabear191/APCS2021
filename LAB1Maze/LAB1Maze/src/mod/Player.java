package mod;

import cont.JOP;

public class Player {
	//player class
	private int _row, _col;
	private boolean _isAlive;
	private boolean _hasSword;
	//gets player position with option or row col or coordinate
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	
	public Player(int r, int c) {
		_row = r;
		_col = c;
		_isAlive = true;
		_hasSword = false;
	}
	//checks player states
	public boolean isAlive() { return _isAlive; }
	public boolean hasSword() {return _hasSword;}
	//alters player states
	public void kill() { _isAlive = false; }
	public void giveSword() { _hasSword = true; JOP.msg("you have the sword go kill him!!!");}
}
