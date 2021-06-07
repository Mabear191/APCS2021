package mod;

public class Minotaur {
	// a simple class made for the Minotaur object in the game
	private int _row, _col;
	private boolean _isAlive;
	
	
	//gets mino's positions 
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	public Minotaur(int r, int c) {
		_row = r;
		_col = c;
		_isAlive = true;
	}
	
	//checks mino's states
	public boolean isAlive() { return _isAlive; }
	//alters mino's states
	public void kill() {_isAlive = false; }
}
