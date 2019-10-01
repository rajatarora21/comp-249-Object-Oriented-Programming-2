// -----------------------------------------------------
 // Assignment (A2)
 // Question: (Part 1 and 2)
 // Written by: (Rajat Arora 40078146)
 // -----------------------------------------------------
package firstPackage;

import fifthPackage.CardGame;
import fourthPackage.BoardGame;
import secondPackage.VideoGame;
import secondPackage.VideoGame.GamingPlatform;
import thirdPackage.EducationalGame;
import thirdPackage.RPGGame;

/**
 *Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (2)
 *  Due Date (27th July) 
 * @author Rajat ARORA
 *	This is the driver class .All the implementations are done within this class.
 */
public class Driver {

	public static void main(String[] args)
	{
		System.out.println("*****************Welcome to Rajat Arora game program******************** ");
		System.out.println("\n\n");
		Game gameObject=new Game("Mario",1,20); //object creation of Game class using the parameterized constructor.
		VideoGame videoGameObject=new VideoGame("Fifi 19",2,60,400,"EA",GamingPlatform.PS4); //object creation of VideoGame class using the parameterized constructor.
		RPGGame rpgGameObject=new RPGGame("Call of duty",2,40,300,"COD","hit",GamingPlatform.PS4);//object creation of RPGGame class using the parameterized constructor.
		EducationalGame educationalGameObject=new EducationalGame("Assasins creed",2,60,400,"Ea","history",GamingPlatform.XBOXOne);//object creation of EducationalGame class using the parameterized constructor.
		BoardGame boardGameObject=new BoardGame("chess",2,60,true);//object creation of BoardGame class using the parameterized constructor.
		CardGame cardGameObject=new CardGame("UNO",4,60,60,5); //object creation of Card7Game class using the parameterized constructor.
		System.out.println(gameObject); //printing the details of the object using toString 
		System.out.println();
		System.out.println(videoGameObject); //printing the details of the object using toString 
		System.out.println();
		System.out.println(rpgGameObject); //printing the details of the object using toString 
		System.out.println();
		System.out.println(educationalGameObject); //printing the details of the object using toString 
		System.out.println();
		System.out.println(boardGameObject); //printing the details of the object using toString 
		System.out.println();
		System.out.println(cardGameObject); //printing the details of the object using toString 
		System.out.println();
		
		Game[] game=new Game[14]; //array of Game of size 14.
		game[0]=new Game("Halo",3,2); //storing the object of Game class.
		game[1]=new VideoGame("fifa 18",2,30,300,"EA",GamingPlatform.XBOXOne); //storing the object of VideoGame class.
		game[2]=new RPGGame("Counter Strike",10,30,300,"EA","EA",GamingPlatform.XBOXOne); //storing the object of RPGGame class.
		game[3]=new EducationalGame("Sudoku",1,30,300,"yo games","gaming World",GamingPlatform.IOS); //storing the object of EducationalGame class.
		game[4]=new BoardGame("Ludo",4,40,true); //storing the object of BoardGame class.
		game[5]=new CardGame("Call break",4,30,60,4); //storing the object of CardGame class.
		game[6]=new Game("Minecraft",3,2); //storing the object of Game class.
		game[7]=new VideoGame("Pacman",2,30,300,"Namco",GamingPlatform.ANDROID); //storing the object of VideoGame class.
		game[8]=new RPGGame("PUB-G",10,30,300,"Steam","Steam",GamingPlatform.ANDROID); //storing the object of RPGGame class.
		game[9]=new EducationalGame("Tronix",2,80,300,"ducksters.com","ducksters.com",GamingPlatform.IOS);//storing the object of EducationalGame class.
		game[10]=new BoardGame("Business Links",4,40,true); //storing the object of BoardGame class.
		game[11]=new CardGame("Bluff",4,30,60,6); //storing the object of CardGame class.
		game[12]=new Game("Football",11,90); //storing the object of Game class.
		game[13]=new VideoGame("fifa 18",2,30,300,"EA",GamingPlatform.XBOXOne); //storing the object of VideoGame class.
		System.out.println("Are the two objects equal:"+game[13].equals(game[1]));//using the equals method
		System.out.println("Are the two objects equal:"+game[0].equals(game[12]));//using the equals method
		System.out.println("\n\n************************Printing of the original array**************************");
		for(int i=0;i<game.length;i++) //for loop used to print the details of all the objects inside the game array.
		{ 
			if(game[i]==null) //if the reference is null , break the loop.
			{
				break;
			}
			else
			{
				System.out.println(game[i]); //printing the details of object using toString 
				System.out.println();
			}
		}
		int maxPlayers=game[0].getNumPlayers(); //storing the maximum value of number of Players
		int maxPlayerLocation=0; //location of the maximum number players
		for(int i=0;i<game.length;i++)
		{
			if(game[i]==null)
			{
				break;
			}
			if(game[i].getNumPlayers()>maxPlayers) //if the number of players at index i is greater than maxPlayers,then the value of maxPlayers is changed to number of players at index i.
			{
				maxPlayers=game[i].getNumPlayers();
				maxPlayerLocation=i;
			}
		}
		System.out.println("\n\n**********************Details of the game with the maximum number of players is given below*******************");
		System.out.println();
		System.out.println("Game with maximum players is at location:"+maxPlayerLocation);
		System.out.println(game[maxPlayerLocation]); //printing the details using toString 
		int leastGameTime=game[0].getGameTime(); //storing the value of minimum game time.
		int leastGameTimeLocation=0; //storing the location of minimum game time. 
		for(int i=0;i<game.length;i++)
		{
			if(game[i]==null)
				break;
			if(game[i].getGameTime()<leastGameTime) //if the game time at index i is less than leastGameTime,then the value of leastGameTime is changed to game time at index i.
			{
				leastGameTime=game[i].getGameTime();
				leastGameTimeLocation=i;
			}
		}
		
		System.out.println("\n\n**************************Details of the game with the least amount of time is given below:****************************");
		System.out.println();
		System.out.println("Game with least time of minutes is at location:"+leastGameTimeLocation);
		System.out.println(game[leastGameTimeLocation]);
		int count=0; //count variable to check if at-least any of the game have same game Studio
		System.out.println("\n\n*********** The objects with same game studio are given below ************************");
		for(int i=0;i<game.length;i++) //loop that will check each object with all the other objects present in the array.
		{
			for(int j=0;j<game.length;j++) //object at index i is checking all the objects in the array
			{
				if(i==j)
					continue;
				else
				{
					//as the game studio attribute is in VideoGameclass we need to cast the game reference to videoGame by first checking the instance , otherwise might give ClassCastException at runtime.
					if(game[i] instanceof VideoGame==true&&game[j] instanceof VideoGame==true) 
					{
						VideoGame obj1=(VideoGame)game[i];
						VideoGame obj2=(VideoGame)game[j];
						if(obj1.getGameStudio().equals(obj2.getGameStudio())) //check if both the arrays have same game studio
						{
							
							System.out.println("\nGame at index:"+i+" and Game at index:"+j+" have the same Game studio.The details of the both games are as under\n\n");
							System.out.println();
							System.out.println(obj1);
							System.out.println();
							System.out.println(obj2);
							count=1;
						}
					}
				}
					
			}
		}
		if(count==0) //if the count is 0 then there are no 2 games with same game studio.
		{
			System.out.println("No game have the same game studio");
		}
		System.out.println("\n\n*************************** Display of the copied Array ********************************");
		Game[] gameCopy=gameSimilarTo(game); //Copy of the game array.
		System.out.println("The copy of the given game array is given below:");
		System.out.println();
		 //printing the copied game array.The printing will be correct as the object is copied with the help of instanceof .The explanation is given in gameSimilarTo method  
		for(int x=0;x<gameCopy.length;x++)
		{
			System.out.println(gameCopy[x]);
			System.out.println();
		}
		System.out.println("**********************Ending of program****************");
	}
	
	/**
	 * 
	 * @param game an array of type Game
	 * @return gameArray an array of type Game
	 */
	static Game[] gameSimilarTo(Game[] game)
	{
		//This method is used to copy the objects of game array.This array first check the instance of object.If the instance is true then it will create new object of the instance type.
		//The order of conditions in conditional statements is important as it will first check the instances of child classes then the parent class.Otherwise all the objects will be created of Parent type.
		Game[] gameArray=new Game[game.length];
		for(int i=0;i<game.length;i++)
		{
			if(game[i] instanceof CardGame) //if the instance is of type CardGame then reference at index i will create a new CardGame object and will copy the details of original array using copy constructor .
			{
				gameArray[i]=new CardGame((CardGame)game[i]);
			}
			else if(game[i] instanceof BoardGame)//if the instance is of type BoardGame then reference at index i will create a new BoardGame object and will copy the details of original array using copy constructor .
			{
				gameArray[i]=new BoardGame((BoardGame)game[i]);
			}
			else if(game[i] instanceof RPGGame) //if the instance is of type RPGGame then reference at index i will create a new RPGGame object and will copy the details of original array using copy constructor .
			{
				gameArray[i]=new RPGGame((RPGGame)game[i]);
			}
			else if(game[i] instanceof EducationalGame)
			{
				gameArray[i]=new EducationalGame((EducationalGame)game[i]); //if the instance is of type EducationalGame then reference at index i will create a new EducationalGame object and will copy the details of original array using copy constructor .
			}
			else if(game[i] instanceof VideoGame)
			{
				gameArray[i]=new VideoGame((VideoGame)game[i]); //if the instance is of type VideoGame then reference at index i will create a new VideoGame object and will copy the details of original array using copy constructor .
			}
			else if(game[i] instanceof Game) //if the instance is of type Game then reference at index i will create a new Game object and will copy the details of original array using copy constructor .
			{
				gameArray[i]=new Game((Game)game[i]);
			}
			
		}
		return gameArray;
	}
}
