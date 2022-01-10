package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"rebel"</b> tactics.</br></br>
 * First cooperate, then defect only for the |CC| situation.
 */
public class Rebel extends Player{
	
	public Rebel() { super.setName("Rebel"); }
	
	/**
	 * First cooperate, then defect only for the |CC| situation.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			if(super.getLastOponentChoice() && super.getChoice(1, 1))
				return false;
		return true;
	}
	
}
