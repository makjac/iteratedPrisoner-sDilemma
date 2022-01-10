package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"rebel"</b> tactics.</br></br>
 * First defect, then defect only for the |CC| situation.
 */
public class RebelFD extends Player{
	
	public RebelFD() { super.setName("Rebel, first defect"); }
	
	/**
	 * First defect, then defect only for the |CC| situation.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			if(super.getLastOponentChoice() && super.getChoice(1, 1))
				return false;
			else
				return true;
		return false;
	}
	
}
