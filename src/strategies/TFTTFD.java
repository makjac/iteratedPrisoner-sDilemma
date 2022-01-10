package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"tit for tat"</b> tactics.</br></br>
 * First cooperate, then tat for double tit.
 */
public class TFTTFD extends Player{
	
	public TFTTFD() { super.setName("Tit for two tats, first defect"); }
	
	/**
	 * First defect, then copy the opponent's choice.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			if(!super.getLastOponentChoice() && !super.getChoice(1, 1))
				return false;
			else
				return true;
		return false;
	}
}