package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"blinder"</b> tactics.</br></br>
 * always defect; when an opponent has cooperated once, the player will always cooperate.
 */
public class Blinder extends Player{
	
	boolean trigger = false;
	
	public Blinder() { super.setName("Blinder"); }
	
	/**
	 * Always defect, if the opponent cooperates once, always cooperate
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
		{
			if(!trigger && super.getLastOponentChoice())
				trigger = true;
			if(trigger)
				return true;
		}
		return false;
	}
	
}
