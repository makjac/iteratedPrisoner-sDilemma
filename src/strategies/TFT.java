package strategies;

import IPD.Player;

/**
 * A player class that takes the <b>"tit for tat"</b> tactics.</br></br>
 * First cooperate, then copy the opponent's choice.
 */
public class TFT extends Player{
	
	public TFT() { super.setName("Tit for tat"); }
	
	/**
	 * First cooperate, then copy the opponent's choice.
	 */
	public boolean choice() 
	{ 
		if(super.length() != 0)
			return super.getLastOponentChoice();
		return true;
	}
}