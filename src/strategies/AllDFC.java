package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"always defect, first cooperate"</b> tactics.</br></br>
 * The player cooperates at first and then always defect no matter what happens.
 */
public class AllDFC extends Player{
	
	public AllDFC() { super.setName("Always defect, first cooperate"); }
	
	/**
	 * First cooperates, then always defect.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return false; 
		return true;
	}
	
}
