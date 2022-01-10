package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"Changer"</b> tactics.</br></br>
 * First cooperate; with each step changes decision.
 */
public class Changer extends Player{
	
	public Changer() { super.setName("Changer"); }
	
	/**
	 * First cooperate; with each step changes decision.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return !super.getLastChoice();
		return true;
	}
	
}