package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"win-stay lose-shift"</b> tactics.</br></br>
 * first cooperate, then choose choice opposite your opponent's.
 */
public class WSLS extends Player{
	
	boolean trigger = false;
	
	public WSLS() { super.setName("Win-stay lose-shift"); }
	
	/**
	 * First cooperate; if opponent defect, change choice
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
		{
			if(!super.getLastOponentChoice())
				trigger = !trigger;
			if(trigger)
				return false;
		}
		return true;
	}
	
}