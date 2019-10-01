
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
 * This is Driver class that is responsible of invoking the CarDealership object and perform various functionality on the object.
 */
public class Driver {

	public static void main(String[] args)
	{
		System.out.println("************** Welcome to Rajat's Car dealership company ************"); //display message.
		System.out.println("\n\nPlease enter the maximum number of cars you want for your company.");
		Scanner input =new Scanner(System.in);
		int noOfCars=input.nextInt();
		new CarDealer(noOfCars); //invoking the constructor for Cardealer that will initialize the carDatabase array and pass the size of the array as the argument.
		while(true) //infinite loop that will terminate when the user chooses the option to quit. 
		{
			int choice=0;
			System.out.println("What do you want to do?");
			System.out.println("\t1. Enter a new Car to the inventory (password required)");
			System.out.println("\t2. Change information of an existing Car (password required)");
			System.out.println("\t3. Display all the Cars with the specified make and model");
			System.out.println("\t4. Display all the Cars within the given price range");
			System.out.println("\t5. Quit");
			System.out.println("Please enter your choice >");
			choice=input.nextInt();
			switch(choice)
			{
					case 1: //if the option is to enter a new Car then optionEnter method in CarDealer class will be invoked.
						CarDealer.optionEnter(input);
						break;
					case 2: //if the option is to change information of an existing Car then optionUpdate method in CarDealer class will be invoked.
						CarDealer.optionUpdate(input);
						break;
					case 3: //if the option is to display all the Cars with specified make and model  then findCarBy method in CarDealer class will be invoked.
						System.out.println("Please enter the make of the Car:");
						input.nextLine();
						String searchMake=input.nextLine();
						System.out.println("Please enter the model of the Car:");
						String searchModel=input.nextLine();
						CarDealer.findCarBy(searchMake,searchModel);
						break;
					case 4: //if the option is to display all the Cars within the given price range then findCarsWithinPriceRange method in CarDealer class will be invoked.
						System.out.println("Please enter the minimum value of the Car price ");
						int searchMin=input.nextInt();
						System.out.println("Please enter the maximum value of the Car price");
						int searchMax=input.nextInt();
						CarDealer.findCarsWithinPriceRange(searchMin,searchMax);
						break;
					case 5: //if the option is to exit , then it will terminate the program.
						System.out.println("Exiting the program!.Have a nice day");
						System.exit(0);
					default: //if any other value is given , it will ask the user to enter again.
						System.out.println("Wrong choice!.Please enter again");
						break;
			}			
		}
	}
}
