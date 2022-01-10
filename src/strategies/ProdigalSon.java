package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"prodigal son"</b> tactics.</br></br>
 * First defect; if once punished, always cooperate.
 */
public class ProdigalSon extends Player{
	
	boolean trigger = false;
	
	public ProdigalSon() { super.setName("Prodigal son"); }
	
	/**
	 * First defect; if once punished, always cooperate.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
		{
			if(!super.getLastOponentChoice() && !trigger)
				trigger =true;
			if(trigger)
				return true;
		}
		return false;
	}
	
}
