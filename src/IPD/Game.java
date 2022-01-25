package IPD;

public class Game {
	private Prisoner player1, player2;
	private int rounds;
	private int[][] score;
	private int[] finalScore;
	private boolean[] memory;
	private boolean[] choices;
	
	public Game() 
	{ 
		rounds = 10;
		score = new int[2][rounds]; 
		finalScore = new int[2];
		finalScore[0] = finalScore[1] = 0;
		memory = new boolean[2];
		choices = new boolean[2];
	}
	
	public Game(int round) 
	{ 
		rounds = round;
		score = new int[2][rounds];
		finalScore = new int[2];
		finalScore[0] = finalScore[1] = 0;
		memory = new boolean[2];
		choices = new boolean[2];
	}
	
	//-------SETTERS-------
	public void setPlayers(int strategy1, int strategy2)
	{ 
		player1 = new Prisoner(strategy1); 
		player2 = new Prisoner(strategy2); 
		finalScore[0] = finalScore[1] = 0;
	}
	
	public void setPlayer1(int strategy) 
	{ 
		player1 = new Prisoner(strategy);
		finalScore[0] = finalScore[1] = 0;
	}
	
	public void setPlayer2(int strategy) 
	{ 
		player2 = new Prisoner(strategy); 
		finalScore[0] = finalScore[1] = 0;
	}
	
	public void setPlayer1(Prisoner p) 
	{ 
		player1 = p;
		finalScore[0] = finalScore[1] = 0;
	}
	
	public void setPlayer2(Prisoner p) 
	{ 
		player2 = p; 
		finalScore[0] = finalScore[1] = 0;
	}
	
	//--------END SETTERS--------
	
	//--------GETTERS----------
	public int getRounds() { return rounds; }
	public int getPalyer1FScore() { return finalScore[0]; }
	public int getPalyer2FScore() { return finalScore[1]; }
	public int[] getPalyersFScore() { return finalScore; }
	public String getPlayer1Name() { return player1.getName(); }
	public String getPlayer2Name() { return player2.getName(); }
	public boolean getPlayer1Choice() { return choices[0]; }
	public boolean getPlayer2Choice() { return choices[1]; }
	public boolean[] getPlayersChoices() { return choices; }
	//--------END GETTERS---------
	
	public int[] play()
	{
		for(int i=0; i<rounds; i++)
		{
			choices[0] = player1.choice(memory[0], memory[1]);
			choices[1] = player2.choice(memory[1], memory[0]);
			memory[0] = choices[0];
			memory[1] = choices[1];
			score[0][i] = verdict(choices[0], choices[1]);
			score[1][i] = verdict(choices[1], choices[0]);
			finalScore[0] = finalScore[0] + score[0][i];
			finalScore[1] = finalScore[1] + score[1][i];
		}
		return finalScore;
	}
	
	int verdict(boolean p, boolean o)
	{
		if(p && o)
			return 2;
		if(!p && o)
			return 0;
		if(p && !o)
			return 10;
		if(!p && !o)
			return 5;
		return 0;
	}
}
