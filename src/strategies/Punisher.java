package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"punisher"</b> tactics.</br></br>
 * First cooperate; defect only for |CD| situation.
 */
public class Punisher extends Player{
	
	public Punisher() { super.setName("Punisher"); }
	
	/**
	 * First cooperate; defect only for |CD| situation.
	 */
	public boolean choice() 
	{ 
		if(super.length() > 2)
			if(!super.getLastOponentChoice() && super.getChoice(1, 1))
				return false;
		return true;
	}
	
}
