package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"grim trigger"</b> tactics.</br></br>
 * First cooperate, then if the opponent defects once, player never forgives.
 */
public class GT extends Player{
	
	private boolean trigger = false;
	
	public GT() { super.setName("Grim trigger"); }
	
	/**
	 * First cooperate, then if the opponent defects once, player never forgives.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
		{
			if(!super.getLastOponentChoice())
				trigger = true;
			if(trigger)
				return false;
		}
		return true;
	}
	
}
