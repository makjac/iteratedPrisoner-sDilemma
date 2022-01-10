package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"swindler"</b> tactics.</br></br>
 * First cooperate; then always defect expect in a |DC| situation.
 */
public class Swindler extends Player{
	
	public Swindler() { super.setName("Swindler"); }
	
	/**
	 * First cooperate; then always defect expect in a |DC| situation.
	 */
	public boolean choice() 
	{ 
		if(super.length() > 1)
		{
			if(!super.getChoice(1, 1) && super.getLastOponentChoice())
				return false;
		}
		return true;
	}
	
}