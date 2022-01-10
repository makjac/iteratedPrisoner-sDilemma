package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"Unceramic, always defect"</b> tactics.</br></br>
 * Always defect; however, if the opponent defect for too long, the player will respond with a single cooperate.
 */
public class AllDUnceramic extends Player{
	
	boolean trigger = false;
	int triggTime = 3;
	
	public AllDUnceramic() { super.setName("Unceramic, always defect"); }
	
	/**
	 * Always defect; however, if the opponent defect for too long, the player will respond with a single cooperate.
	 */
	public boolean choice() 
	{ 
		if(super.length() > 3)
			if(!super.getLastOponentChoice() && 
					!super.getChoice(1, 1) &&
					!super.getChoice(1, 2) &&
					!super.getChoice(1, 3) &&
					!trigger)
			{
				trigger = true;
				return true;
			}
		if(trigger)
		{
			if(triggTime == 0)
			{
				trigger = false;
				triggTime = 4;
			}
			triggTime--;
		}
		return false; 	
	}
	
}