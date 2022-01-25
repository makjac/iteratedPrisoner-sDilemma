package IPD;

public class RandomPrisoner extends Prisoner{
	
	double chance;
	
	public RandomPrisoner(int n)
	{
		super();
		chance = 0.5;
		String num = Integer.toBinaryString(n);
		String strategies = connectStrings("000000000", num);
		
		name = new String();
		answers = new boolean[9];
		
		
		for(int i = 0; i<9; i++)
		{
			answers[i] = !(strategies.charAt(i) == '1');
			if(answers[i])
				name = name + "c";
			else
				name = name + "d";
		}
	}
	
	public RandomPrisoner(int n, double Chance)
	{
		super();
		chance = Chance;
		String num = Integer.toBinaryString(n);
		String strategies = connectStrings("000000000", num);
		
		name = new String();
		answers = new boolean[9];
		
		
		for(int i = 0; i<9; i++)
		{
			answers[i] = !(strategies.charAt(i) == '1');
			if(answers[i])
				name = name + "c";
			else
				name = name + "d";
		}
	}
	
	double getChance() { return chance; }
	void setChance(double Chance) { chance = Chance; }
	
	String connectStrings(String base, String Sin)
	{
		return base.substring(0, 9-Sin.length()) + Sin;
	}
	
	public boolean choice(boolean p, boolean o)
	{
		if(notFirst)
		{
			double x = Math.random();
			boolean r = (x<chance);
			if(!p && !o && !r)
				return answers[1];
			if(!p && !o && r)
				return answers[2];
			if(!p && o && !r)
				return answers[3];
			if(!p && o && r)
				return answers[4];
			if(p && !o && !r)
				return answers[5];
			if(p && !o && r)
				return answers[6];
			if(p && o && !r)
				return answers[7];
			if(p && o && r)
				return answers[8];
		}
		notFirst = true;
		return answers[0];
	}

}
