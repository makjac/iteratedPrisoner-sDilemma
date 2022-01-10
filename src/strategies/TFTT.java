package strategies;

import IPD.Player;

public class TFTT extends Player{
	
	public TFTT() { super.setName("Tit for two tats"); }
	
	/**
	 * First cooperate, then copy the opponent's choice.
	 */
	public boolean choice() 
	{ 
		if(super.length() > 2)
			if(!super.getLastOponentChoice() && !super.getChoice(1, 1))
				return false;
		return true;
	}
}