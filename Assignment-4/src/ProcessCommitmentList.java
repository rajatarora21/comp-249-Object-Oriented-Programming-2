// -----------------------------------------------------
 // Assignment (A4)
 // Question: (4)
 // Written by: (Rajat Arora 40078146)
 // ----------------------------------------------------- 

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *  Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (A4)
 * Due Date (11th August 2019)
 
 * @author Rajat Arora
 * This is a driver class.Reading the data from the file and processing it .Sample tests are also done in this class.
 *
 */
public class ProcessCommitmentList {

	public static void main(String[] args) throws IOException 
	{
		System.out.println("***********Welcome to Rajat's Program******************");
		System.out.println("\n\nProcessed data from the file:");
		ActivityList list=new ActivityList(); //ActivityList object that will read all the activities from the MSchedule.txt
		File schedule =new File("MSchedule.txt"); //opening the file for MSchedule
		File commit=new File("MCommitments.txt"); //opening the file for MCommitments
		Scanner readSchedule=new Scanner(schedule);
		Scanner readCommit=new Scanner(commit);
		ArrayList<String> current=new ArrayList<String>(); //Arraylist that will store the current commitments
		ArrayList<String> newCommit=new ArrayList<String>(); //Arraylist that will store the new commitments.
		while(readCommit.hasNextLine()) //reading the MSchedule file
		{
			try
			{
				String activityID=readSchedule.next(); //assigning the activity id
				String activityName=readSchedule.next();//assigning the activity name
				readSchedule.nextLine();
				double startTime=Double.parseDouble(readSchedule.nextLine().substring(1)); //assigning the start time
				double endTime=Double.parseDouble(readSchedule.nextLine().substring(1)); //assigning the end time
				if(list.contains(activityID)) //if a duplicate id occurs , then continue
				{
					continue;
				}
				else
				{
					list.addToStart(new Activity(activityID,activityName,startTime,endTime)); //adding the node in the list using addToStart method.
				}
			}
			catch(Exception e)
			{
				break;
			}
		}
		//reading the commitments
		while(readCommit.hasNextLine())
		{
			String value=readCommit.nextLine();
			if(value.equals("New")) //once the line hits new then break.
			{
				break;
			}
			else if(value.equals("Current")) //if a header occurs to be current
			{
				continue;
			}
			else
			{
				current.add(value); //adding the current commitments to the list
			}		
		}
		while(readCommit.hasNextLine()) //adding the new commitments to the list
		{
			String value=readCommit.nextLine();
			newCommit.add(value);
		}
		//processing if the user can make new commitments or not.
		for(String newCom:newCommit) //iterating through new commits
		{
			int flag=0;
			for(String com:current) //iterating through current commits
			{
				//using the isOnSameTime method to check if the user can make new commitments.
				String value=list.find(newCom).getActivity().isOnSameTime(list.find(com).getActivity());
				if(value.equals("Same time")) //if both activities occur on same time.
				{
					System.out.println("User can't commit to "+newCom+" as he/she has another commitment at the exact same time.");
				}
				else if(value.equals("Some Overlap")) //if there is some overlap.
				{
					System.out.println("User can't commit to "+newCom+" as he/she is not finished with his/her prior commitment.");
				}
				else if(value.equals("Different Time")) //if both activities occur on different time.
				{
					flag++; //increase the value of flag
				}
			}
			if(flag==current.size()) //if the value of flag is equal to current commitments size , then the user can make that commitment
			{
				System.out.println("User can commit to "+newCom+" as he/she is free during that time.");
			}
		}
		System.out.println("\n\n********************** The following activities are in total in the List***************************\n\n");
		list.display(); //display the original list
		System.out.println("\n\nFor copying the list enter new activity id , as they cannot be the same.\n");
		ActivityList list2=new ActivityList(list); //2nd list using copy constructor
		System.out.println();
		System.out.println("Are the two lists equal:"+list.equals(list2)); //check if both of them are equal or not
		System.out.println();
		System.out.println("\n\nCopied List:");
		list2.display(); //display the copied list
		System.out.println("size:"+list2.getSize());
		System.out.println("\n\n************A Sample list**************");
		ActivityList list3=new ActivityList(); //creating a sample list for tests
		//Adding the elements to the list
		list3.addToStart(new Activity("comp335","Data Structure",12.00,2.00));
		list3.insertAtIndex(1,new Activity("comp335","Data Structure",12.00,2.00));
		list3.insertAtIndex(1,new Activity("comp375","Compiler Design",2.00,4.00));
		list3.insertAtIndex(2,new Activity("comp665","Discrete Math",4.00,9.00));
		list3.insertAtIndex(3,new Activity("comp101","Prog Intro",12.00,2.00));
		list3.display(); //display the list
		System.out.println("size:"+list3.getSize()); //display the size of the list
		System.out.println("\n\nDeletion operation"); //deleting from the list
		list3.deleteFromIndex(3); //delete from the index method.
		//list3.deleteFromStart();
		System.out.println("\n\n");
		list3.display(); //display list after deletion
		System.out.println("size:"+list3.getSize()); //display size after deletion
		System.out.println("\n\nReplace operation");
		list3.replaceAtIndex(0,new Activity("soen331","Architecture",12.00,2.00)); //replacing at index.
		System.out.println("\n\n");
		list3.display(); //display the list after replacing 
		System.out.println("size:"+list3.getSize()); //display the size after replacing.
		System.out.println("\n\nContains operation");
		System.out.println("Does the list contains comp352:"+list3.contains("comp352")); //if the list contains the activityID
		System.out.println("Does the list contains soen331:"+list3.contains("soen331"));
		System.out.println("\n\nequals method check on original list");
		System.out.println("\nAre the two lists equal:"+list.equals(list3)); //check if two lists are equal.
		System.out.println("******** End of Program ***********");
		readSchedule.close();
		readCommit.close();

		
	}

}
