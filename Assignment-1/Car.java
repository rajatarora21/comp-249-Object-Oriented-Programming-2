// -----------------------------------------------------
 // Assignment (A1)
 // Question: (Part-1)
 // Written by: (RAJAT ARORA 40078146)
 // -----------------------------------------------------

/**
 * @author Rajat Arora 40078146
 * Assignment A1
 * Due Date 17th July 2019
 * 
 * This is the Car class which have 5 attributes make,model,year,price and noOfCars.This class is responsible for creating object of every new car and and assigns there necessary details.
 * For accessing and updating the data , this class have accessors and mutators.This class override the toString() method from Object class to display the all the data of the object of Car class.
 * This class override equals() method to check if 2 objects of Car class are equal or not.
 */

public class Car 
{
	private String make;  //private attribute make of the class Car.
	private String model;	//private attribute model of the class Car.
	private int year;	//private attribute year of the class Car.
	private int price;	//private attribute price of the class Car.
	private static int noOfCars=0; //this attribute keeps a track on how many cars are there in total.
	
	public Car() //default constructor
	{
		this(null,null,0,0); //calling the parameterized constructor using this() and giving the default values to the attributes..
	}
	/**
	 * 
	 * @param make attribute of the class
	 * @param model attribute of the class
	 * @param year attribute of the class
	 * @param price attribute of the class
	 */
	public Car(String make,String model,int year,int price) //parameterized constructor to initialize the instance variables.
	{
		this.make=make;
		this.model=model;
		this.year=year;
		this.price=price;
		noOfCars=noOfCars+1; //As soon as a new Car is instantiated ,total number of cars get increased by 1. 
	}
	/**
	 * @param car this is of type Car
	 */
	public Car(Car car) //Copy constructor
	{
		this.make=car.make;
		this.model=car.model;
		this.year=car.year;
		this.price=car.price;
	}
	/**
	 * @return A String type
	 */
	public String getMake() //getter for attribute make 
	{
		return make;
	}

	/**
	 * @param make A variable of type String 
	 */
	public void setMake(String make) //setter for attribute make 
	{
		this.make = make;
	}

/**
 * @return A String type
 */
	public String getModel() //getter for attribute model 
	{
		return model;
	}

/**
 * @param model A variable of type String 
 */
	public void setModel(String model) //setter for attribute model 
	{
		this.model = model;
	}

	/**
	 * 
	 * @return an integer type
	 */
	public int getYear() //getter for attribute year 
	{
		return year;
	}

	/**
	 * 
	 * @param year A variable of type integer
	 */
	public void setYear(int year) //setter for attribute year
	{
		this.year = year;
	}

	/**
	 * 
	 * @return an integer type
	 */
	public int getPrice() //getter for attribute price 
	{
		return price;
	}

	/**
	 * 
	 * @param price A variable of type integer
	 */
	public void setPrice(int price) //setter for attribute make 
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		String value="Make:Make of the Car: "+this.make+"\nModel:Model of the Car: "+this.model+"\nYear:Year of the Car: "+this.year+"\nPrice:Price of the Car: "+this.price;
		return value;
	}
	/**
	 * 
	 * @return noOfCars an integer type
	 */
	public static int findNumberOfCreatedCars() //static method that returns the total number of Cars created.
	{
		return noOfCars;
	}
	
	@Override
	public boolean equals(Object obj) //equals method that check if 2 Cars are equal by checking if both of them have same make and model.
	{
		Car c=(Car)obj;
		if((this.make.equals(c.make))&&(this.model.equals(c.model)))
		{
			return true; //return true if they are equal.
		}
		return false; //return false if not.
	
	}
	
	
	
	
	
	
	
}
