package IPD;

import strategies.*;
import graphic.*;

public class Prisoners_dilemma {

	public static void main(String[] args) {
		Player p = new AllCCheck();
		new MainFrame(p);
	}
}