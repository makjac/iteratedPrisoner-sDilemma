package IPD;

public class Prisoner {
	
	String name = "";
	boolean[] answers;
	boolean notFirst;
	
	Prisoner(){}
	Prisoner(int n)
	{
		answers = new boolean[5];
		notFirst = false;
		String num = Integer.toBinaryString(n);
		String strategies = connectStrings("00000", num);
		
		for(int i = 0; i<5; i++)
		{
			answers[i] = !(strategies.charAt(i) == '1');
			if(answers[i])
				name = name + "c";
			else
				name = name + "d";
		}
	}
	
	//-------GETTERS---------
	/**returns the player name*/
	String getName() { return name; }
	//-------END GETTERS---------
	
	//------SETTERS---------
	/**Sets the player name.
	 * @param Name player name*/
	void setName(String Name) { name = Name; }
	//------END SETTERS------
	
	String connectStrings(String base, String Sin)
	{
		return base.substring(0, 5-Sin.length()) + Sin;
	}
	
	/**
	 * Method returns which choice the player makes
	 * @param p - previous player selection
	 * @param o - previous opponent selection
	 * @return <b>true</b> if the player cooperates</br> <b>false</b> if the player defect
	 */
	boolean choice(boolean p, boolean o)
	{
		if(notFirst)
		{
			if(!p && !o)
				return answers[1];
			if(!p && o)
				return answers[2];
			if(p && !o)
				return answers[3];
			if(p && o)
				return answers[4];
		}
		notFirst = true;
		return answers[0];
	}
}
