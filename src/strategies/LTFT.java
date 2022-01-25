package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"Late tit for tat"</b> tactics.</br></br>
 * First cooperate, if opponent defect, then player defect 2 turns later.
 */
public class LTFT extends Player{
	
	public LTFT() { super.setName("Late tit for tat"); }
	
	/**
	 * First cooperate, if opponent defect, then player defect 2 turns later.
	 */
	public boolean choice() 
	{ 
		if(super.length() > 2)
			return super.getChoice(1, 1);
		return true;
	}
}