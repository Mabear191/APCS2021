package mod;

import cont.JOP;
import view.StringMap;

public class World {

	private Player _p;
	private Minotaur _t;
	private Maze _m;
	private StringMap _s;
	private int stepCnt = 0;

	public World() {
		_m = new Maze();
		// startROW startCOL
		_p = new Player(_m.getPlyStart()[0], _m.getPlyStart()[1]);
		_t = new Minotaur(_m.getMinStart()[0], _m.getMinStart()[1]);
		_s = new StringMap(_m, _p, _t);
		JOP.msg("The goal of the game is to try and reach the exit to all three maps without dying" + "\n" + "\n" + "Tutorial" + "\n" + "in order to move type W, A, S or D " + "\n" + "The minotaur (M) will kill you if it reaches you" + "\n" + "If you reach the sword (S) you will be able to kill the minotaur by being in the same grid as him" + "\n" + "You can change maps at any time by typing: change map or changemap" + "\n" + "every step you take is counted and you can display it at any time by typing: steps" + "\n" + "\n" + "you can type stop at any time to stop the program");
		update();
	}

	public void update() {
		boolean isPlaying = true;
		while (isPlaying) {
			boolean on = true;
			// Get the Map
			String map = _s.generateMap();
			String msg = "WASD to move. What direction do you want to move?";

			while (on) {
				// Get the player move
				String move = JOP.in(map + msg);

				// move the player
				if(move == null) {
					
				}
				else if (getPlayerMove(move)) {
					stepCnt++;
					on = false;
				}
				else if (mapChange(move)) {
					on = false;
				}
				else if (showSteps(move)) {
					on = false;
				}
				else if (stop(move)) {
					isPlaying = false;
					on = false;
				}
			}

			// check for victory
			if (victory()) {
				isPlaying = false;
				JOP.msg("Congrats victory!");
			}
			// check to give sword
			if(onSword()) {
				_p.giveSword();
			}
			// move the minotaur
			if(_t.isAlive()) {
				moveMinotaur();
			}
			
			// check for death
			if(onMint()) {
				if(_p.hasSword()) {
					_t.kill();
				}
				else {
					_p.kill();
					isPlaying = false;
				}
			}
		}
	
		
	}

	// change to getPlayerMove(String s) change to private.
	private boolean getPlayerMove(String s) {

		// Moving North
		if (s.equalsIgnoreCase("W")) {
			if ((_p.getRow() - 1) >= 0 && _m.getMaze()[_p.getRow() - 1][_p.getCol()]) {
				_p.setPos(_p.getRow() - 1, _p.getCol());
				return true;
			} else {
				return false;
			}
		}
		// Moving South
		if (s.equalsIgnoreCase("S")) {
			if ((_p.getRow() + 1) < _m.getMaze().length && _m.getMaze()[_p.getRow() + 1][_p.getCol()]) {
				_p.setPos(_p.getRow() + 1, _p.getCol());
				return true;
			} else {
				return false;
			}
		}
		// Moving East
		if (s.equalsIgnoreCase("D")) {
			if ((_p.getCol() + 1) < _m.getMaze()[0].length && _m.getMaze()[_p.getRow()][_p.getCol() + 1]) {
				_p.setPos(_p.getRow(), _p.getCol() + 1);
				return true;
			} else {
				return false;
			}
		}
		// Moving West
		if (s.equalsIgnoreCase("A")) {
			if ((_p.getCol() - 1) >= 0 && _m.getMaze()[_p.getRow()][_p.getCol() - 1]) {
				_p.setPos(_p.getRow(), _p.getCol() - 1);
				return true;
			} else {
				return false;
			}
		}

		return false;
	}
	
	private void moveMinotaur() {
		int rDist = _p.getRow() - _t.getRow();
		int cDist = _p.getCol() - _t.getCol();
		int r = _t.getRow();
		int c = _t.getCol();
		
		// Minotaur moving North
		if(rDist < 0 && _m.getMaze()[r - 1][c]) {
			_t.setPos(r - 1, c);
		}

		// Minotaur moving South.
		if(rDist > 0 && _m.getMaze()[r +1][c]) {
			_t.setPos(r + 1, c);
		}
		// Minotaur moving East
		if(cDist > 0 && _m.getMaze()[r][c + 1]) {
			_t.setPos(r, c + 1);
		}
		// Minotuar moving west
		if(cDist < 0 && _m.getMaze()[r][c - 1]) {
			_t.setPos(r, c - 1);
		}
	}
	
	private boolean mapChange(String s) {
		if(s.equalsIgnoreCase("CHANGE MAP") || s.equalsIgnoreCase("CHANGEMAP")) {
			String mapChoice = JOP.in("choose a map: 1 2 3");
			if(mapChoice.equalsIgnoreCase("1")) {
				_m.setCurMaze(1);
				_p.setPos(_m.getPlyStart()[0], _m.getPlyStart()[1]);
				_t.setPos(_m.getMinStart()[0], _m.getMinStart()[1]);
				return true;
			}
			else if(mapChoice.equalsIgnoreCase("2")) {
				_m.setCurMaze(2);
				_p.setPos(_m.getPlyStart()[0], _m.getPlyStart()[1]);
				_t.setPos(_m.getMinStart()[0], _m.getMinStart()[1]);
				return true;
			}
			else if(mapChoice.equalsIgnoreCase("3")) {
				_m.setCurMaze(3);
				_p.setPos(_m.getPlyStart()[0], _m.getPlyStart()[1]);
				_t.setPos(_m.getMinStart()[0], _m.getMinStart()[1]);
				return true;
			}
			else
				JOP.msg("no map change: invalid choice");
		}
		return false;
	}
	
	private boolean showSteps(String s) {
		String count = "" + stepCnt;
		if(s.equalsIgnoreCase("steps")) {
			JOP.msg("you have taken " +  count + " steps.s");
		}
		return false;
	}
	public boolean onSword() {
		if(_p.getRow() == _m.getSword()[0] &&
				_p.getCol() == _m.getSword()[1]) {
			if(!_p.hasSword()) {
				return true;
			}
		}
		return false; 
	}
	
	public boolean onMint() {
		if(_t.getRow() == _p.getRow() &&
				_t.getCol() == _p.getCol()) {
			return true;
		}
		return false;
	}

	public boolean victory() {
		if (_p.getRow() == _m.getExit()[0] && _p.getCol() == _m.getExit()[1])
			return true;
		return false;
	}
	
	public boolean stop(String s) {
		if(s.equalsIgnoreCase("stop")) {
			return true;
		}
		return false;
	}
}
