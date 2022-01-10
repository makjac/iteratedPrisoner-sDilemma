package strategies;

import IPD.Player;

public class AllCCheck extends Player{
	
	public AllCCheck() { super.setName("Always cooperate"); }
	
	/**
	 * Always cooperate.
	 */
	public boolean choice() 
	{ 
		if(super.length() > 3)
			if(!super.getLastOponentChoice() && 
					!super.getChoice(1, 1) &&
					!super.getChoice(1, 2) &&
					!super.getChoice(1, 3))
				return false;
		return true; 	
	}
	
}