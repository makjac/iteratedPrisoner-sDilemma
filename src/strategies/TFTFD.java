package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"tit for tat, first defect"</b> tactics.</br></br>
 * First defect, then copy the opponent's choice.
 */

public class TFTFD extends Player{
	
	public TFTFD() { super.setName("Tit for tat, first defect"); }
	
	/**
	 * First defect, then copy the opponent's choice.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return super.getLastOponentChoice();
		return false;
	}
}