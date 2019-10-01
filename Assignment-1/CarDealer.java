// -----------------------------------------------------
 // Assignment (A1)
 // Question: (Part-2)
 // Written by: (RAJAT ARORA 40078146)
 // ----------------------------------------------------- 
import java.util.Scanner;
/**
 * @author Rajat Arora 40078146
 * Assignment A1
 * Due Date 17th July 2019
 * 
 * This is CarDealer class.This class have a static attribute carDatabase that is an array of Car.This class is responsible for all functionality on Car object that is done according to the user requirements.
 */
public class CarDealer {

	static Car carDatabase[]; //static attribute carDatabase[] that stores the object of Car.
	static private int countPassword=0;//static private attribute that is used for password check in Option1.
	public CarDealer(int size) //parameterized constructor that creates the Car array .The size of the array is passed in the parameter.
	{
		carDatabase=new Car[size];
	}
	@Override
	public String toString() //override the toString method of this class that will return all the cars with there information that are in the carDatabase array.
	{		
		String value="";
		for(int i=0;i<carDatabase.length;i++) //the loop that will iterate through every object in the till the reference is null.
		{
			if(carDatabase[i]==null) //if the reference if null then break the loop.
			{
				break;
			}
			else 
			{
				value=value+carDatabase[i]+"\n\n";
			}
		}
		return value;
		
	}
	
	/**
	 * 
	 * @param input A variable of type Scanner
	 * @return a boolean type
	 */
	static private boolean passwordCheck(Scanner input) //private static method to check if the password is correct or not.Made it private so that Driver class cannot access this method.
	{
		String password="comp249S19"; //the required password.
		int count=0;
		String pass="";
		System.out.println("Please enter the password:");
		do 
		{
			pass=input.next(); 
			if(pass.equals(password)) //if the password is correct , it will return true.
			{
				return true; 
			}
			else //if the password is wrong , it will repeat the loop 3 times , after that it will return false.
			{
				System.out.println("!!Wrong password!!.Please enter again");
				count=count+1;
				if(count==3)
				{
					return false; //if count is 3 return false.
				}
			}
		}while(true);
		
	}
	/**
	 * 
	 * @param input A variable of type Scanner
	 */
	static void optionEnter(Scanner input) //This is the static method providing all the functionality for option 1,that is entering the data and providing data validations.
	{
		
		if(passwordCheck(input)==false) //checking if password is false.
		{
			countPassword=countPassword+1; //if the password is false , it will increment the countPassword by 1.
			if(countPassword==4)//if the value of countPassword is 4 then it will terminate the program.
			{
				System.out.println("Program detected suspicious activity and is terminating!");
				System.exit(0); //terminating the program.
			}
		}
		else
		{
			int remainingCars=carDatabase.length-Car.findNumberOfCreatedCars(); //calculating the remaining cars in carDatabase array by the (total length of array)-(total number of cars created). 
			System.out.println("Please enter how many cars you want to enter"); 
			do 
			{
				int noOfCars=input.nextInt();
				if(noOfCars>remainingCars) //if number of cars user wants to enter is greater than remaining cars then it will prompt the user the remaining number of cars . 
				{
					System.out.println("You have only "+remainingCars+" cars left!!");
					System.out.println("Please enter again how many cars you want ");
				}
				else
				{
					int start=Car.findNumberOfCreatedCars(); //the start value of the loop will be the total number of cars created .
					int end=Car.findNumberOfCreatedCars()+noOfCars;//the end value of the loop will be total number of cars created + the number of cars the user wants to enter.
					for(int i=start;i<end;i++)
					{
						carDatabase[i]=new Car(); //creating the new Car object and asking user for all the desired inputs.
						System.out.println("Please enter the name of the car "+i+":");
						input.nextLine(); //invoked a nextLine() method that will consume the nextLine , if removed then it will skip the next line.
						String name=input.nextLine();
						System.out.println("Please enter the model of the car"+i+":");
						String model=input.nextLine();
						System.out.println("Please enter the year of the car"+i+":");
						int year=input.nextInt();
						System.out.println("Please enter the price of the car"+i+":");
						int price=input.nextInt();
						carDatabase[i].setPrice(price); //using the setters to store the data.
						carDatabase[i].setMake(name);
						carDatabase[i].setModel(model);
						carDatabase[i].setYear(year);
						carDatabase[i].setPrice(price);
					}
					break;
				}
				
			}while(true); //an infinite loop that will only break once all the objects are created.
			
		}
		
		
	}
	/**
	 * 
	 * @param input a variable of type Scanner
	 */
	static void optionUpdate(Scanner input) //This is the static method providing all the functionality for Option-2.This method have all the functionality to update the data. 
	{
		
		if(passwordCheck(input)==false) //if the password is incorrect for 3 times then it will return to the main menu.
		{
			return;
		}
		else
		{
			do
			{
				System.out.println("Please enter the car number you want to update");
				int carUpdate=input.nextInt();
				if(carUpdate>=carDatabase.length) //if the car number user wants to update is greater than the carDatabase length then it will prompt the user to enter a number between 0 and carDatabase.length-1(inclusive).
				{
					System.out.println("Sorry you have only "+carDatabase.length+" in total.Please enter a number between 0 and "+(carDatabase.length-1)+"(inclusive)");
					continue;
				}
				if(carDatabase[carUpdate]!=null) //if the object if found 
				{
					
					do  //an infinite loop that will continue to iterate till the user chooses to quit.
					{ 
						//displaying the data of the Car object using toString method of Car class.
						System.out.println("Car:#"+carUpdate);
						System.out.println(carDatabase[carUpdate]);
						System.out.println("\nWhat information would you like to change?");
						System.out.println();
						//Menu of the things the user wants to update.
						System.out.println("\t1. Car make");
						System.out.println("\t2. Car model");
						System.out.println("\t3. Car year");
						System.out.println("\t4. Car price");
						System.out.println("\t5. Quit");
						System.out.println("\nPlease enter your choice>");
						int updateChoice=input.nextInt();
						
						
							if(updateChoice==1) //If the user wants to update the make of the Car.
							{
									System.out.println("Please enter the updated make of the Car");
									input.nextLine(); //invoked a nextLine() method that will consume the nextLine , if removed then it will skip the next line.
									String newMake=input.nextLine();
									carDatabase[carUpdate].setMake(newMake); //updating the make of the Car object using setter.
							}
							else if(updateChoice==2) //If the user wants to update the model of the Car.
							{
								System.out.println("Please enter the updated model of the Car:");
								input.nextLine(); //invoked a nextLine() method that will consume the nextLine , if removed then it will skip the next line.
								String newModel=input.nextLine();
								carDatabase[carUpdate].setModel(newModel); //updating the model of the Car object using setter.
							}
							else if(updateChoice==3) //If the user wants to update the year of the Car.
							{
								System.out.println("Please enter the updated year of the Car:");
								int newYear=input.nextInt();
								carDatabase[carUpdate].setYear(newYear); //updating the year of the Car object using setter.
							}
							else if(updateChoice==4) //If the user wants to update the price of the Car.
							{
								System.out.println("Please enter the updated price of the Car:");
								int newPrice=input.nextInt();
								carDatabase[carUpdate].setPrice(newPrice); //updating the price of the Car object using setter.
							}
							else if(updateChoice==5) //If the user wants to quit and go back to main menu.
									break;
							else //if the user inputs anything apart from options 1-5.
							{
								System.out.println("Wrong choice!.Please enter the choice again."); 
							}
		
						
					}while(true);
					break; //breaking the outer loop and going to main menu once the update is complete
				}
				else if(carDatabase[carUpdate]==null) //if the there is no car at the specified index then it will prompt the user to go back to main menu or re-enter the choice again.
				{
					System.out.println("Oops! There is no car.Please enter 1 to re-enter the car number or enter 0 to go back to main menu.");
					int reChoice=input.nextInt();
					if(reChoice==1)
					{
						continue; //continue the loop if the user wants to re-enter the value.
					}
					else
					{
						break; //break the loop and go back main menu .
					}
				}
				
			}while(true);
			
		}
		
		
	}
	/**
	 * 
	 * @param searchMake A variable of type String
	 * @param searchModel A variable of type String
	 */
	static void findCarBy(String searchMake,String searchModel) //static method that is used to display all the Cars with the specific make and model.
	{
	
		int count=0;
	 	for(int i=0;i<carDatabase.length;i++) //the loop that will iterate through every object in the till the reference is null.
		{
			if(carDatabase[i]==null) //if the reference if null then break the loop.
			{
				break;
			}
			else
			{
				//checking if the object have the same make and model , if found display the details of the object.
				if((carDatabase[i].getMake().equals(searchMake))&&(carDatabase[i].getModel().equals(searchModel)))
				{
					System.out.println("Car#"+i);
					System.out.println(carDatabase[i]); //calling the toString() method of Car class to display the data.
					System.out.println();
					count=1; //if any one record is found the value of count will be assigned as 1.
				}
			}
		}
		if(count==0) //if the value of count is 0 , then there is no record .
		{
			System.out.println("Sorry no car found !");
		}
		
	}
	/**
	 * 
	 * @param searchMin A variable of type integer
	 * @param searchMax A variable of type integer
	 */
	static void findCarsWithinPriceRange(int searchMin,int searchMax) //static method that is used to display all the Cars whose price range is between minimum and maximum price that is choosen by the user.
	{
		
		int count=0;
		for(int i=0;i<carDatabase.length;i++) //the loop that will iterate through every object in the till the reference is null. 
		{
			if(carDatabase[i]==null) //if the reference if null then break the loop.
			{
				break;
			}
			else
			{
				//Checking if the price of the object is greater than or equal to the minimum and the price of the car is less than or equal to the maximum.
				if((carDatabase[i].getPrice()>=searchMin)&&(carDatabase[i].getPrice()<=searchMax)) 
				{
					System.out.println("Car#"+i);
					System.out.println(carDatabase[i]); //calling the toString() method of Car class to display the data.
					System.out.println();
					count=1; //if any one record is found the value of count will be assigned as 1.
				}
			}
		}
		if(count==0) //if the value of count is 0 , then there is no record .
		{
			System.out.println("Sorry no car found !");
		}
		
	}
	
}
