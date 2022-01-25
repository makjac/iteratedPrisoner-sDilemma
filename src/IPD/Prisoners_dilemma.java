package IPD;

import strategies.*;
import graphic.*;

public class Prisoners_dilemma {

	static String connectStrings(String base, String Sin)
	{
		return base.substring(0, 5-Sin.length()) + Sin;
	}
	
	public static void main(String[] args) {
		Player p = new LTFT();
		new MainFrame(p);
		//new RandomFrame();
	}
}
