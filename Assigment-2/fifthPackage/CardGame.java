// -----------------------------------------------------
 // Assignment (A2)
 // Question: (Part 1 and 2)
 // Written by: (Rajat Arora 40078146)
 // -----------------------------------------------------
package fifthPackage;

import firstPackage.Game;

/**
 * 
 * @author Rajat ARORA
 *	This class is the child class of Game.The have 2 attributes along with getters ,setters ,equals and toString.The class have 3 constructors as well.
 */
public class CardGame extends Game 
{
	//the attributes of CardGame class made private .
	protected int numberOfCards;
	protected int numCardTypes;
	public CardGame() //default constructor
	{
		super();
	}
	/**
	 * 
	 * @param name attribute of String type
	 * @param numPlayers attribute of integer type
	 * @param gameTime attribute of integer type
	 * @param numberOfCards attribute of integer type
	 * @param numCardTypes attribute of integer type
	 */
	public CardGame(String name, int numPlayers, int gameTime,int numberOfCards,int numCardTypes)
	{
		super(name,numPlayers,gameTime);
		this.numberOfCards=numberOfCards;
		this.numCardTypes=numCardTypes;
	}
	/**
	 * 
	 * @param cardGame a reference of type CardGame
	 */
	public CardGame(CardGame cardGame)
	{
		super(cardGame.getName(),cardGame.getNumPlayers(),cardGame.getGameTime());
		this.numberOfCards=cardGame.numberOfCards;
		this.numCardTypes=cardGame.numCardTypes;
	}
	/**
	 * 
	 * @return numberOfCards an integer type
	 */
	public int getNumberOfCards() {
		return numberOfCards;
	}
	/**
	 * 
	 * @param numberOfCards a variable of type integer
	 */
	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}
	/**
	 * 
	 * @return numCardTypes an integer type
	 */
	public int getNumCardTypes() {
		return numCardTypes;
	}
	/**
	 * 
	 * @param numCardTypes a variable of type integer
	 */
	public void setNumCardTypes(int numCardTypes) {
		this.numCardTypes = numCardTypes;
	}
	public String toString()  //override the toString method to print the details of CardGame class
	{
		String value=this.getName()+" is the name of the CardGame"+".\nNumber of players: "+this.getNumPlayers()+".\ngameTime in minutes: "+this.getGameTime()+".\nNumber of cards: "+numberOfCards+".\nTypes of number card: "+numCardTypes;
		return value;
	}
	@Override
	public boolean equals(Object obj) //override the equals method 
	{
		//checking if the obj is not null and is an instance of CardGame class.If we do not check the instance of obj .It can lead to ClassCastException at runtime during casting.
		if((obj==null)||(obj instanceof CardGame==false))
		{
			return false;
		}
		CardGame game=(CardGame)obj; //Casting the obj to CardGame class.It can give a ClassCastException if we do not check the instance of obj.
		//if the 2 objects have same name,gameTime and numPLayers , it will return true.The value of name,gameTime and numPlayers have been taken from getters of Game class .As they are marked private , they can only be accessed from the setters.
			if(this.getName().equals(game.getName())&&(this.getGameTime()==game.getGameTime())&&(this.getNumPlayers()==game.getNumPlayers()))
				return true;
		return false;
		
	}
}
