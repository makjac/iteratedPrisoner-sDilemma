package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"Changer, first defect"</b> tactics.</br></br>
 * First defect; with each step changes decision.
 */
public class ChangerFD extends Player{
	
	public ChangerFD() { super.setName("Changer, first defect"); }
	
	/**
	 * First defect; with each step changes decision.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return !super.getLastChoice();
		return false;
	}
	
}