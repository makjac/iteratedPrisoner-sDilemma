package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"tree frog, first defect"</b> tactics.</br></br>
 * first cooperate, then choose choice opposite your opponent's.
 */
public class TreeFrogFD extends Player{
	
	public TreeFrogFD() { super.setName("Tree frog, first defect"); }
	
	/**
	 * first defect, then choose choice opposite your opponent's.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return !super.getLastOponentChoice();
		return false;
	}
	
}