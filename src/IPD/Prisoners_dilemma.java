package IPD;

import graphic.*;

public class Prisoners_dilemma {

	static String connectStrings(String base, String Sin)
	{
		return base.substring(0, 5-Sin.length()) + Sin;
	}
	
	public static void main(String[] args) {
		new MainFrame();
		new RandomFrame();
	}
}
