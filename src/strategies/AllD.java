package strategies;
import IPD.Player;

/**
 * A player class that takes the <b>"always defect"</b> tactics.</br></br>
 * The player always defect no matter what happens.
 */
public class AllD extends Player{
	
	public AllD() { super.setName("Always defect"); }
	
	/**
	 * Always defect.
	 */
	public boolean choice() { return false; }
	
}
