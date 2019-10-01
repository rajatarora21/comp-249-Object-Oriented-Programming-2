// -----------------------------------------------------
 // Assignment (A2)
 // Question: (Part 1 and 2)
 // Written by: (Rajat Arora 40078146)
 // -----------------------------------------------------
package thirdPackage;

import secondPackage.VideoGame;
/**
 * 
 * @author Rajat ARORA
 * Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (2)
 *  Due Date (27th July) 
 *	This class is the child class of VideoGame class.The have 1 attributes along with getters ,setters ,equals and toString.The class have 3 constructors as well.
 */
public class RPGGame extends VideoGame{

	//the attributes of RPGGame class made private .
	private String gameWorld;
	
	public RPGGame() //default constructor 
	{
		super();
		this.gameWorld = null;
	}
	/**
	 * 
	 * @param name attribute of String type
	 * @param numPlayers attribute of integer type
	 * @param gameTime attribute of integer type
	 * @param gamePrice attribute of integer type
	 * @param gameStudio attribute of String  type
	 * @param gameWorld attribute of string  type
	 * @param gamingPlatform  attribute of GamingPlatform enum type
	 */
	public RPGGame(String name,int numPlayers,int gameTime,int gamePrice, String gameStudio,String gameWorld,GamingPlatform gamingPlatform)
	{
		super(name,numPlayers,gameTime,gamePrice,gameStudio,gamingPlatform);
		this.gameWorld=gameWorld;
		
	}
	/**
	 * 
	 * @param rpgGame a reference of RPGGame type
	 */
	public RPGGame(RPGGame rpgGame) //copy constructor
	{
		super(rpgGame.getName(),rpgGame.getNumPlayers(),rpgGame.getGameTime(),rpgGame.getGamePrice(),rpgGame.getGameStudio(),rpgGame.getGamingPlatform());
		this.gameWorld=rpgGame.gameWorld;
	}
	/**
	 * 
	 * @return gameWorld a String type
	 */
	public String getGameWorld() 
	{
		return gameWorld;
	}
	/**
	 * 
	 * @param gameWorld a variable of type String
	 */
	public void setGameWorld(String gameWorld) {
		this.gameWorld = gameWorld;
	}
	
	public String toString() //override the toString method to print the details of RPGGame class
	{
		String value=this.getName()+" is a RPG game.\nIt is developed by(Game studio):"+this.getGameStudio()+
				" and is priced at "+this.getGamePrice()+".\nTime of the game in minutes "+this.getGameTime()+".\nNumber of players for the game: "+this.getNumPlayers()+".\nGame World: "+gameWorld+".\nGaming Platform: "+this.getGamingPlatform();
		return value;
	}
	@Override
	public boolean equals(Object obj) //override the equals method
	{
		//checking if the obj is not null and is an instance of RPGGame class.If we do not check the instance of obj .It can lead to ClassCastException at runtime during casting.
		if((obj==null)||(obj instanceof RPGGame==false))
		{
			return false;
		}
		RPGGame game=(RPGGame)obj;//Casting the obj to RPGGame class.It can give a ClassCastException if we do not check the instance of obj.
		//if the 2 objects have same name,gameTime and numPLayers , it will return true.The value of name,gameTime and numPlayers have been taken from getters of Game class .As they are marked private , they can only be accessed from the setters.
			if(this.getName().equals(game.getName())&&(this.getGameTime()==game.getGameTime())&&(this.getNumPlayers()==game.getNumPlayers()))
				return true;
		return false;
		
	}
}
