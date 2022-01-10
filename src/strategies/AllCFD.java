package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"always cooperate, first defect"</b> tactics.</br></br>
 * First defect, then always cooperate.
 */
public class AllCFD extends Player{
	
	public AllCFD() { super.setName("Always cooperate, first defect"); }
	
	/**
	 * First defect, then always cooperate.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return true; 
		return false;
	}
	
}