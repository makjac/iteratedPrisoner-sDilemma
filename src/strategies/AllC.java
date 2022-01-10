package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"always cooperate"</b> tactics.</br></br>
 * The player always cooperates no matter what happens.
 */
public class AllC extends Player{
	
	public AllC() { super.setName("Always cooperate"); }
	
	/**
	 * Always cooperate.
	 */
	public boolean choice() { return true; }
	
}