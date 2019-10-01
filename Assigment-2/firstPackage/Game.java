// -----------------------------------------------------
 // Assignment (A2)
 // Question: (Part 1 and 2)
 // Written by: (Rajat Arora 40078146)
 // ----------------------------------------------------- 
package firstPackage;
/**
 * 
 * @author Rajat Arora
 * Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (2)
 * Due Date (27th July) 
 *This is the Game class.This class have 3 attributes name,numPlayers,gameTime.This class the parent of all the other classes.
 *This class have getters ,setters,constructors ,equals and toString method
 */
public class Game 
{
	/*the attributes in Part 1 are made protected and can be directly accessed by the child classes without the use of Getters.In part 2 the attributes are made private(most restricted one)
	By making the attributes most restrictive the child classes cannot access them directly but only through getters and setters.The only tradeOff of making them private 
	is the child classes cannot modify them directly it can only be done through setters*/  
	private String name; 
	private int numPlayers;
	private int gameTime;
	
	public Game() //default constructor
	{
		this(null,0,0);
	}
	/**
	 * 
	 * @param name A String type
	 * @param numPlayers An integer type
	 * @param gameTime An integer type
	 */
	public Game(String name, int numPlayers, int gameTime) //parameterized constructor setting up the values.
	{
		this.name = name;
		this.numPlayers = numPlayers;
		this.gameTime = gameTime;
	}
	/**
	 * 
	 * @return name A String type
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name A variable of type String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return numPlayers an integer type
	 */
	public int getNumPlayers() {
		return numPlayers;
	}
	/**
	 * 
	 * @param numPlayers A variable of type integer
	 */
	public void setNumPlayers(int numPlayers) 
	{
		this.numPlayers = numPlayers;
	}
	/**
	 * 
	 * @return gameTime an integer type
	 */
	
	public int getGameTime() {
		return gameTime;
	}
	/**
	 * 
	 * @param gameTime a variable of type integer
	 */
	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}
	/**
	 * 
	 * @param game a reference of game type
	 */
	public Game(Game game) //copy constructor 
	{
		this.name=game.name;
		this.numPlayers=game.numPlayers;
		this.gameTime=game.gameTime;
	}
	
	public String toString() //overriding the toString method .Printing the details of Game class
	{
		String value="Name of the game: "+name+"\nNumber of players: "+numPlayers+"\ngameTime in minutes : "+gameTime;
		return value;
	}
	
	@Override
	public boolean equals(Object obj) //override the equals method from Object Class
	{
		//checking if the obj is not null and is an instance of Game class.If we do not check the instance of obj .It can lead to ClassCastException at runtime during casting.
		if((obj==null)||(obj instanceof Game==false)) 
		{
			return false;
		}
		Game game=(Game)obj; //Casting the obj to Game class.It can give a ClassCastException if we do not check the instance of obj.
			if(this.name.equals(game.name)&&(this.gameTime==game.gameTime)&&(this.numPlayers==game.numPlayers)) //if the 2 objects have same name,gameTime and numPLayers , it will return true.
				return true;
		return false;
		
	}
	
	
}
