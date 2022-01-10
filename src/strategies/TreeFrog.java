package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"tree frog"</b> tactics.</br></br>
 * first cooperate, then choose choice opposite your opponent's.
 */
public class TreeFrog extends Player{
	
	public TreeFrog() { super.setName("Tree frog"); }
	
	/**
	 * first cooperate, then choose choice opposite your opponent's.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return !super.getLastOponentChoice();
		return true;
	}
	
}