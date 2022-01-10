package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"win-stay lose-shift, first defect"</b> tactics.</br></br>
 * first defect, then choose choice opposite your opponent's.
 */
public class WSLSFD extends Player{
	
	boolean trigger = false;
	
	public WSLSFD() { super.setName("Win-stay lose-shift, first defect"); }
	
	/**
	 * First defect; if opponent defect, change choice
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
		{
			if(!super.getLastOponentChoice())
				trigger = !trigger;
			if(!trigger)
				return true;
		}
		return false;
	}
	
}