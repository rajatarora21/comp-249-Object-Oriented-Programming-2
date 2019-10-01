// -----------------------------------------------------
 // Assignment (A2)
 // Question: (Part 1 and 2)
 // Written by: (Rajat Arora 40078146)
 // -----------------------------------------------------
package fourthPackage;

import firstPackage.Game;
/**
 * 
 * @author Rajat ARORA
 *  Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (2)
 *  Due Date (27th July) 
 *	This class is the child class of Game.The have 1 attributes along with getters ,setters ,equals and toString.The class have 3 constructors as well.
 */
public class BoardGame extends Game 
{
	//the attributes of BoardGame class made private 
	protected boolean timedTurns;

	public BoardGame() //default constructor
	{
		super();
		this.timedTurns =false;
	}
	/**
	 * 
	 * @param name attribute of String type
	 * @param numPlayers attribute of Integer type
	 * @param gameTime attribute of Integer type
	 * @param timedTurns attribute of boolean type
	 */
	public BoardGame(String name, int numPlayers, int gameTime,boolean timedTurns)
	{
		super(name,numPlayers,gameTime);
		this.timedTurns=timedTurns;
	}
	/**
	 * 
	 * @param boardGame a reference of type BoardGame
	 */
	public BoardGame(BoardGame boardGame)
	{
		super(boardGame.getName(),boardGame.getNumPlayers(),boardGame.getGameTime());
		this.timedTurns=boardGame.timedTurns;
		
	}
	/**
	 * 
	 * @return timedTurns a boolean type
	 */
	public boolean isTimedTurns() {
		return timedTurns;
	}
	/**
	 * 
	 * @param timedTurns a variable of type boolean
	 */
	public void setTimedTurns(boolean timedTurns) {
		this.timedTurns = timedTurns;
	}
	
	public String toString()//override the toString method to print the details of BoardGame class
	{
		String value=this.getName()+" is the name of the BoardGame"+" Number of players:"+this.getNumPlayers()+".\ngameTimen in minutes: "+this.getGameTime()+".\nTimed turns: "+timedTurns;
		return value;
	}
	@Override
	public boolean equals(Object obj) //override the equals method
	{
		//checking if the obj is not null and is an instance of BoardGame class.If we do not check the instance of obj .It can lead to ClassCastException at runtime during casting.
		if((obj==null)||(obj instanceof BoardGame==false))
		{
			return false;
		}
		BoardGame game=(BoardGame)obj;//Casting the obj to BoardGame class.It can give a ClassCastException if we do not check the instance of obj.
		//if the 2 objects have same name,gameTime and numPLayers , it will return true.The value of name,gameTime and numPlayers have been taken from getters of Game class .As they are marked private , they can only be accessed from the setters.
			if(this.getName().equals(game.getName())&&(this.getGameTime()==game.getGameTime())&&(this.getNumPlayers()==game.getNumPlayers()))
				return true;
		return false;
		
	}
	
	
	
	
}
