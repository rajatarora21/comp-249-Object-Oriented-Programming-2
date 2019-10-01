// -----------------------------------------------------
 // Assignment (A3)
 // Question: (Part 1)
 // Written by: (Rajat Arora 40078146)
 // ----------------------------------------------------- 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;
/**
 * Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (3)
 * Due Date (4th August)
 * @author Rajat Arora
 *	This is the Driver class.This class is responsible to list the directories of all the text files ,process them and finally display them.
 */
public class Driver 
{
	
	public static void main(String[] args) 
	{
		System.out.println("**************** Welcome to Rajat's Program *****************************");
		System.out.println("\n");
		int check=0;
		while(true) //infinite loop that input the choice of the user .It exits only when users enters 3. 
		{ 
			System.out.println("\n\n1.List Files"); 
			System.out.println("2.Process Files");
			System.out.println("3.Exit");
			System.out.println("\nEnter your choice:");
			Scanner input =new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice)
			{
				case 1:
						File file =new File("Data"); //The file object opens the Data folder.
						if(file.listFiles().length==0) //if nothing is inside the data folder then EmptyFolderException is thrown.
						{
							try
							{
								throw new EmptyFolderException("The directory is empty");
							}
							catch(EmptyFolderException e)
							{
								e.printStackTrace();
							}
						}
						PrintWriter pw = null;
						try 
						{
							pw = new PrintWriter("log.txt"); //printwriter used to write the directories in the log file.
						} 
						catch (FileNotFoundException e) 
						{
							e.printStackTrace();
						}
						File arr[]=file.listFiles(); //list files method used to list all the files inside the data folder.
						recursiveFile(arr,0,pw); //calling the recursive method to print the files and directories inside the log file.The starting index is 0.
						System.out.println("The files have been processed"); //printing the message that files have been successfully processed.
						pw.close(); //closing the printwriter
						check=1;
						break;
				case 2:
						if(check==0) //if the value of check is still 0 then the user first list the files first.
						{
							System.out.println("Please list the files first!!");
							break;
						}
						else
						{
							processFile();	//calling the method to process files.
							break;
						}
				case 3:
						System.out.println("Thank you for using our services .Have a nice day!!");
						input.close();
						System.exit(0); //exiting the program.
				default:
						System.out.println("Oops! Wrong choice .Please enter again."); 
			}
		}
		
	}	
	/**
	 * processFile method used to process the files listed in the log file.
	 */
	public static void processFile() 
	{
		Scanner log = null;
		File file=new File("log.txt"); //File object for log file.
		if(file.exists()==false) //if the log file doesn't exist then throw InvalidFileException.
		{
			try
			{
				throw new InvalidFileException("The log file doesn't exist");
			}
			catch(InvalidFileException e)
			{
				e.printStackTrace();
			}
		}
		try 
		{
			log = new Scanner(file); //scanner object to read the log file.
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		File fileInput;
		Scanner inputScanner = null; //scanner object used to read the text files with data.
		String[] name=new String[50]; //name array to store the name of the car
		int[] value=new int[50]; //value array to store the number of cars of a specific CarMake.
		double[] price=new double[50]; //price array to store the total price of the car.
		int[] key=new int[50]; //key array that maps to the car.
		int keyvalue=1; //initial value of key is 1.
		int index=0; //starting index is 0.
		while(log.hasNextLine())
		{
			fileInput=new File(log.nextLine()); //File object that takes the path of the text file inside the log file.
			if(fileInput.isFile()) //is the path is a file path
			{
				int count=0;
				try 
				{
					inputScanner=new Scanner(fileInput); //to read the data inside the text file with car data.
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
				String temp=inputScanner.nextLine(); //reading the name of the car.
				inputScanner.nextLine();  //skipping the line.
				inputScanner.nextLine();  //skipping the line.
				inputScanner.nextLine();  //skipping the line.
				double priceTemp=Double.parseDouble(inputScanner.nextLine().substring(1)); //price of the car , separating the $ from the price and parsing the value in double.
				for(int i=0;i<name.length;i++)//iterating through the name array.
				{
					if(temp.equals(name[i])) //if a car already exists
					{
						count=1; 
						value[i]++; //increase the number of cars by 1.
						price[i]=price[i]+priceTemp; //increase the total price of the car.
					}
				}
				if(count==0) //if the car doesn't exist
				{
					value[index]++; //increase the value by 1.
					name[index]=temp; //new name of the car at last index.
					price[index]=priceTemp; //price of the car
					key[index]=keyvalue; //mapping the key with car.
					keyvalue++; //increasing the key value.
					index++; //increasing the index value.
				}
				
			}
			else if(fileInput.isDirectory()) //if the path is a directory inside the log file
			{
				File[] checkFile=fileInput.listFiles();
				if(checkFile.length==0) //if the directory is empty then throw EmptyFolderException.
				{
					try 
					{
						throw new EmptyFolderException("Empty directory");
					} 
					catch (EmptyFolderException e) 
					{
						e.printStackTrace();
					}
				}
				
			}
			else //if its neither a path nor a directory then throw InvalidFileException 
			{
				try 
				{
					throw new InvalidFileException("Input file named  "+fileInput.getAbsolutePath()+" cannot be found");
				} 
				catch (InvalidFileException e) 
				{
					e.printStackTrace();
				}
			}
		}
		File data2=new File("processedData.txt"); //File object that will store the processed data in a text file.
		try 
		{
			data2.createNewFile(); //creating the file if it doesn't exist
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		RandomAccessFile fileWrite = null; //RandomAccessFile to write the processed data in the file
		try 
		{
			fileWrite = new RandomAccessFile(data2,"rw"); //creating RandomAccessFile in both read and write mode.
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			fileWrite.write("SRNo\t\t\tCarMake\t\t\tNumberOfCars\t\t\tTotalCost".getBytes()); //writing the header
			fileWrite.write("\r\n---------------------------------------------------------------------------------------".getBytes());
			String dataValue="\r\n"; //dataValue object that will store all the value of the processed data.
			for(int i=0;i<name.length;i++) //loop that will iterate till its null.
			{
				if(name[i]==null) 
					break;
				if(name[i].length()>=8) //for better formatting of the data , providing necessary tabs.
				{
					dataValue=dataValue+"\r\n"+key[i]+"\t\t\t"+name[i]+"\t\t"+value[i]+"\t\t\t$"+price[i]; //Concatenate the data with dataValue object.
				}
				else
				{
					dataValue=dataValue+"\r\n"+key[i]+"\t\t\t"+name[i]+"\t\t\t"+value[i]+"\t\t\t$"+price[i];
				}
				
			}
			fileWrite.write(dataValue.getBytes()); //writing the processed data in the file.
			fileWrite.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			RandomAccessFile fileRead=new RandomAccessFile(data2,"r"); //RandomAccessFile to read the processed data.Open in read mode.
			int i=fileRead.read(); //reading the file bit-by-bit.
			while(i!=-1) //reading the file till EOF
			{
				System.out.print((char)i);  //printing the data bit-by-bit
				i=fileRead.read();
			}
			fileRead.close(); //closing the RandomAccessFile object.
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 
	 * @param arr an array of File type
	 * @param index an index of the file array 
	 * @param pw a reference of type Printwriter 
	 */
	public static void recursiveFile(File[] arr,int index,PrintWriter pw)
	{
			if(index==arr.length) //if the value of index is equal to array length then return (this is the exit condition).
				return;
			File[] tempArr; //temporary array that will list the files if its a directory.
			if(arr[index].isDirectory()) //if its a directory at the index 
			{
					if(arr[index].listFiles().length==0) //if nothing is inside the directory folder then EmptyFolderException is thrown.
					{
						try
						{
							throw new EmptyFolderException("The directory is empty");
						}
						catch(EmptyFolderException e)
						{
							e.printStackTrace();
						}
					}
					if(index!=0) //just to print an extra line.
					{
						pw.println();
					}
					pw.println("\nDirectory:\n"); 
					pw.println(arr[index].getAbsolutePath()); //writing the absolute path of the directory
					tempArr=arr[index].listFiles(); //listing all the files inside the directory
					recursiveFile(tempArr,0,pw); //calling the recursive method.
			}
			else if(arr[index].isFile()) //if its a file at the index then print the absolute path of file
			{
				if(index==0) //if the index is 0, then give the heading Files.
				{
					pw.println("Files:");
				}
				pw.println(arr[index].getAbsolutePath()); //writing the absolute path of the file.
			}
			index=index+1; //increasing the value of index by 1.
			recursiveFile(arr,index,pw); //calling the recursive method.
				
	}
}
