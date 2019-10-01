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
 *Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (2)
 *  Due Date (27th July) 
 *	This class is the child class of VideoGame class.The have 1 attributes along with getters ,setters ,equals and toString.The class have 3 constructors as well.
 */
public class EducationalGame extends VideoGame 
{
	//the attributes of EducationalGame class made private .
	protected String subjectLearnt;
	
	public EducationalGame() //default constructor
	{
		super();
		this.subjectLearnt = null;
	}
	/**
	 * 
	 * @param name attribute of String type
	 * @param numPlayers attribute of integer type
	 * @param gameTime attribute of integer type
	 * @param gamePrice attribute of integer type
	 * @param gameStudio attribute of String  type
	 * @param subjectLearnt attribute of string  type
	 * @param gamingPlatform  attribute of GamingPlatform enum type
	 */
	public EducationalGame(String name,int numPlayers,int gameTime,int gamePrice, String gameStudio,String subjectLearnt,GamingPlatform gamingPlatform)
	{
		super(name,numPlayers,gameTime,gamePrice,gameStudio,gamingPlatform);
		this.subjectLearnt=subjectLearnt;
	}
	/**
	 * 
	 * @param educationalGame a reference of type EducationalGame
	 */
	public EducationalGame(EducationalGame educationalGame)
	{
		super(educationalGame.getName(),educationalGame.getNumPlayers(),educationalGame.getGameTime(),educationalGame.getGamePrice(),educationalGame.getGameStudio(),educationalGame.getGamingPlatform());
		this.subjectLearnt=educationalGame.subjectLearnt;

	}
	/**
	 * 
	 * @return subjectLearnt a String type
	 */
	
	public String getSubjectLearnt() {
		return subjectLearnt;
	}
	/**
	 * 
	 * @param subjectLearnt a variable of type String 
	 */
	public void setSubjectLearnt(String subjectLearnt) {
		this.subjectLearnt = subjectLearnt;
	}
	
	public String toString() //override the toString method to print the details of EducationalGame class
	{
		String value=this.getName()+" is a Education game.It is developed by "+this.getGameStudio()+
				"and is priced at"+this.getGamePrice()+".\nTime of the game in minutes"+this.getGameTime()+".\nNumber of players for the game:"+this.getNumPlayers()+".\nsubject learnt"+subjectLearnt+".\nGaming Platform:"+this.getGamingPlatform();
		return value;
	}
	@Override
	public boolean equals(Object obj)
	{
		//checking if the obj is not null and is an instance of EducationalGame class.If we do not check the instance of obj .It can lead to ClassCastException at runtime during casting.
		if((obj==null)||(obj instanceof EducationalGame==false))
		{
			return false;
		}
		EducationalGame game=(EducationalGame)obj;//Casting the obj to EducationalGame class.It can give a ClassCastException if we do not check the instance of obj.
		//if the 2 objects have same name,gameTime and numPLayers , it will return true.The value of name,gameTime and numPlayers have been taken from getters of Game class .As they are marked private , they can only be accessed from the setters.
			if(this.getName().equals(game.getName())&&(this.getGameTime()==game.getGameTime())&&(this.getNumPlayers()==game.getNumPlayers()))
				return true;
		return false;
		
	}
	
	
	
	
}
