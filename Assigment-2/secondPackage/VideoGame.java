// -----------------------------------------------------
 // Assignment (A2)
 // Question: (Part 1 and 2)
 // Written by: (Rajat Arora 40078146)
 // -----------------------------------------------------
package secondPackage;

import firstPackage.Game;
/**
 * 
 * @author Rajat Arora
 * Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (2)
 *  Due Date (27th July) 
 *	This class is the child class of Game.The have 2 attributes along with getters ,setters ,equals and toString.The class have 3 constructors as well.
 */
public class VideoGame extends Game 
{
	//the attributes of VideoGame class made private .
	private int gamePrice;
	private String gameStudio;
	private GamingPlatform gamingPlatform;
	
	public VideoGame() //default constructor  
	{
		super();
		this.gamePrice=0;
		this.gameStudio=null;
		this.gamingPlatform=GamingPlatform.XBOXOne;
	}
	/**
	 * 
	 * @param name attribute of String type
	 * @param numPlayers attribute of integer type
	 * @param gameTime attribute of integer type
	 * @param gamePrice attribute of integer type
	 * @param gameStudio attribute of String type
	 * @param gamingPlatform attribute of GamingPlatform enum type
	 */
	public VideoGame(String name,int numPlayers,int gameTime,int gamePrice, String gameStudio,GamingPlatform gamingPlatform) {
		super(name,numPlayers,gameTime);
		this.gamePrice = gamePrice;
		this.gameStudio = gameStudio;
		this.gamingPlatform=gamingPlatform;
		
	}
	/**
	 * 
	 * @param videoGame a reference of type VideoGame
	 */
	public VideoGame(VideoGame videoGame) //copy constructor
	{
		super(videoGame.getName(),videoGame.getNumPlayers(),videoGame.getGameTime());
		this.gamePrice=videoGame.gamePrice;
		this.gameStudio=videoGame.gameStudio;
		this.gamingPlatform=videoGame.gamingPlatform;
	}
	/**
	 * 
	 * @return an Enum type
	 */
	public GamingPlatform getGamingPlatform() {
		return gamingPlatform;
	}
	/**
	 * 
	 * @param gamingPlatform A variable of type GamingPlatform
	 */
	public void setGamingPlatform(GamingPlatform gamingPlatform) {
		this.gamingPlatform = gamingPlatform;
	}
	public enum GamingPlatform{XBOXOne,PS4,IOS,ANDROID} //enum having 4 constants.
	public int getGamePrice() {
		return gamePrice;
	}
	/**
	 * 
	 * @param gamePrice a variable of type integer
	 */
	public void setGamePrice(int gamePrice)
	{
		this.gamePrice = gamePrice;
	}
	/**
	 * 
	 * @return a String type
	 */
	public String getGameStudio() {
		return gameStudio;
	}
	/**
	 * 
	 * @param gameStudio a variable of type String
	 */
	public void setGameStudio(String gameStudio) {
		this.gameStudio = gameStudio;
	}
	
	
	public String toString() //override the toString method to print the details of VideoGame class
	{
		String value=this.getName()+" is a videogame"+".Number of players: "+this.getNumPlayers()+"\nGame time in minutes: "+this.getGameTime()+"\nPrice of the game: "+gamePrice+"\nGame studio: "+gameStudio+"\nGame platform: "+gamingPlatform;
		return value;
	}
	@Override
	public boolean equals(Object obj) //override the equals method
	{
		//checking if the obj is not null and is an instance of VideoGame class.If we do not check the instance of obj .It can lead to ClassCastException at runtime during casting.
		if((obj==null)||(obj instanceof VideoGame==false))
		{
			return false;
		}
		VideoGame game=(VideoGame)obj; //Casting the obj to VideoGame class.It can give a ClassCastException if we do not check the instance of obj.
		//if the 2 objects have same name,gameTime and numPLayers , it will return true.The value of name,gameTime and numPlayers have been taken from getters of Game class .As they are marked private , they can only be accessed from the setters.
			if(this.getName().equals(game.getName())&&(this.getGameTime()==game.getGameTime())&&(this.getNumPlayers()==game.getNumPlayers()))
				return true;
		return false;
		
	}
	
	 
}
