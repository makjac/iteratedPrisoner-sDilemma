package IPD;

/**
 * Main player class
 * @author Maksymilian Jackowski
 * @version 0.0.1
 */
public class Player {
	protected String name = "Player";											//Player Name
	private int points = 0;														//points scored in the game (years spent in prison)
	private int memlen = 5;														//memory array range 
	private int len = 0;														//current number of elements in the memory array
	boolean[][] memory = new boolean[2][5];										//array storing player choices; index 0 - player, index 1 - opponent
	
	/**
	 * Method returns which choice the player makes
	 * @return <b>true</b> if the player cooperates</br> <b>false</b> if the player defect
	 */
	public boolean choice() { return true; }
	
	//------SETTERS---------
	/**Sets the player name.
	 * @param Name player name*/
	public void setName(String Name) { name = Name; }
	
	/**adds the years spent in prison to the score
	 * @param n points
	 * */
	public void addPoints(int n) { points += n; }
	//------END SETTERS------
	
	//-------GETTERS---------
	/**returns the current number of elements in the memory array*/
	public int length() { return len; }
	
	/**returns the number of elements the player can store in the memory array*/
	public int lengthRange() { return memlen; }
	
	/**returns the player name*/
	public String getName() { return name; }
	
	/**returns the current number of player points*/
	public int getPoints() { return points; }
	
	/**returns the player's last choice*/
	public boolean getLastChoice() { return memory[0][memlen-1]; }
	
	/**Returns the opponent's last choice*/
	public boolean getLastOponentChoice() { return memory[1][memlen-1]; }
	
	/**
	 * Returns the player's selected choice.
	 * @param player  0 - player; 1 - opponent
	 * @param n - choice index counted from newest (0) to oldest (player memory range). 
	 */
	public boolean getChoice(int player, int n) { return memory[player][memlen-1-n]; }	//
	//-------END GETTERS---------
	
	/**
	 * Increases the number of current decisions by 1. </br>
	 * Makes sure the number does not exceed the player's available memory range.
	 */
	void incLen()
	{
		if(len < memlen-1)
			len++;
	}
	
	/**
	 * Adds the next player choice to the end of the memory array.
	 * @param p - player choice
	 * @param o - opponent choice
	 */
	public void newElement(boolean p, boolean o)
	{
		int length = memlen - 1;
		
		for(int i = 0; i < length; i++)
		{
			memory[0][i] = memory[0][i+1];
			memory[1][i] = memory[1][i+1];
		}
		memory[0][length] = p;
		memory[1][length] = o;
		incLen();
	}
	
	/**
	 * Method displays the player's choices selections.
	 * @param player 0 - player; 1 - opponent
	 * @return returns true if the method executes correctly.
	 */
	public boolean printPlayerChoices(int player)
	{
		if((player != 0) && (player != 1))
			return false;
		for(int i = 0; i < len; i++)
			System.out.print(memory[player][memlen-1-i] + " ");
		System.out.print("\n");
		return true;
	}
	
	
	public void printMemoryTable()
	{
		if(len > 0)
		{
			System.out.println(name + ": ");
			printPlayerChoices(0);
			System.out.println("\n" + "opponent: ");
			printPlayerChoices(1);
			System.out.print("\n" + "\n");
		}
		else
			System.out.println("Table is empty" + '\n');
	}
	
	public void printPlayer()
	{
		System.out.println("-------------------------");
		System.out.println("Name: " + name);
		System.out.println("Score: " + points);
		System.out.println("-------------------------");
	}
}
