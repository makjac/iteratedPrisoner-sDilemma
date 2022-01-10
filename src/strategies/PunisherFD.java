package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"punisher"</b> tactics.</br></br>
 * First defect; defect only for |CD| situation.
 */
public class PunisherFD extends Player{
	
	public PunisherFD() { super.setName("Punisher, first defect"); }
	
	/**
	 * First defect; defect only for |CD| situation.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
		{
			if(super.length() > 2)
				if(!super.getLastOponentChoice() && super.getChoice(1, 1))
					return false;
			return true;
		}
		return false;
	}
	
}
