package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"tit for tat"</b> tactics.</br></br>
 * First cooperate, then double tat for one tit.
 */
public class TFTT extends Player{
	
	public TFTT() { super.setName("Tit for two tats"); }
	
	/**
	 * First cooperate, then double tat for one tit.
	 */
	public boolean choice() 
	{ 
		if(super.length() > 2)
			if(!super.getLastOponentChoice() && !super.getChoice(1, 1))
				return false;
		return true;
	}
}