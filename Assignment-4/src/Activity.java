// -----------------------------------------------------
 // Assignment (A4)
 // Question: (2)
 // Written by: (Rajat Arora 40078146)
 // ----------------------------------------------------- 

import java.util.ArrayList;
import java.util.Scanner;
/**
 * * Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (A4)
 * Due Date (11th August 2019)
 
 * @author Rajat Arora
 *
 *This is the activity class.This class contains all the data attributes required.The class have constructors,accessors,mutators,equals,toString and overridden method from Commitable interface.
 *
 */
class Activity implements Commitable
{
	//data attributes.
	private String activityID;
	private String activityName;
	private double startTime;
	private double endTime;
	private static ArrayList<String> uniqueId=new ArrayList<String>(); //a static Arraylist object used to check if activityID is unique or not.
	
	/**
	 *  default constructor
	 */
	public Activity()
	{
		this(null,null,0,0);
	}
	/**
	 * 
	 * @param activityID a String type
	 * @param activityName a String type
	 * @param startTime a double type
	 * @param endTime a double type
	 */
	public Activity(String activityID, String activityName, double startTime, double endTime) 
	{
		if(!uniqueId.contains(activityID)) //if the activity id doesn't exist in the list then assign the object with desired attribute.
		{
			uniqueId.add(activityID);
			this.activityID = activityID;
			this.activityName = activityName;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
	}
	/**
	 * copy constructor
	 * @param activity a reference of type Activity
	 * @param activityID a String type
	 */
	public Activity(Activity activity,String activityID)
	{
		if(!uniqueId.contains(activityID)) //if the activity id doesn't exist in the list then assign the object with desired attribute.
		{
			this.activityID=activityID;
			this.activityName=activity.activityName;
			this.endTime=activity.endTime;
			this.startTime=activity.startTime;
			uniqueId.add(activityID);
		}
		
	}
	/**
	 * 
	 * @return uniqueId a Arraylist type
	 */
	public static ArrayList<String> getUniqueId() 
	{
		return uniqueId;
	}
	/**
	 * 
	 * @param uniqueId a Arraylist type
	 */
	public static void setUniqueId(ArrayList<String> uniqueId) {
		Activity.uniqueId = uniqueId;
	}
	/**
	 * 
	 * @return activityID a String type
	 */
	public String getActivityID() {
		return activityID;
	}
	/**
	 * 
	 * @param activityID a String type
	 */
	public void setActivityID(String activityID) 
	{
		if(!uniqueId.contains(activityID)) //if the id doesn't exist in the arraylist then assign the id to the attribute 
		{
			this.activityID=activityID;
			uniqueId.add(activityID);
		}
	}
	/**
	 * 
	 * @return activityName a String type
	 */
	public String getActivityName() {
		return activityName;
	}
	/**
	 * 
	 * @param activityName A String type
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	/**
	 * 
	 * @return startTime a double type
	 */
	public double getStartTime() {
		return startTime;
	}
	/**
	 * 
	 * @param startTime a double type
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	/**
	 * 
	 * @return endTime a double type
	 */
	public double getEndTime() {
		return endTime;
	}
	/**
	 * 
	 * @param endTime a double type
	 */
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	/**
	 *  toString() method Override from Object class
	 */
	@Override
	public String toString() 
	{
		return "Activity [activityID=" + activityID + ", activityName=" + activityName + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	/**
	 * isOnSameTime() Override from the Commitable interface
	 */
	@Override
	public String isOnSameTime(Activity S) 
	{
		double newStart=this.getStartTime();
		double newEnd=this.getEndTime();
		double start=S.getStartTime();
		double end=S.getEndTime();
		if(newStart==start&&newEnd==end) //if both activities have same start and end time then it will return same time.
		{
			return "Same time";
		}
		else if((newStart<start&&newEnd<start)||(newStart>end&&newEnd>end)) //if both activities have no overlap with each other then it will return different time.
		{
			return "Different Time";
		}
		else if(newStart>start&&newStart<end&&newEnd>end) //condition to check the overlap.if there is an overlap it will return some overlap. 
		{
			return "Some Overlap";
		}
		else if(newStart<start&&newEnd>start&&newEnd<end) //condition to check the overlap.if there is an overlap it will return some overlap.
		{
			return "Some Overlap";
		}
		else if(newStart>start&&newEnd<end) //condition to check the overlap.if there is an overlap it will return some overlap.
		{
			return "Some Overlap";
		}
		return null;
	
}
	/**
	 * equals() method Override from the Object class.Check if both the activities are equal or not.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		Activity temp=(Activity)obj;
		if(this.activityName==null||temp.activityName==null) //if the name is null , return false
			return false;
		else if(this.activityName.equals(temp.activityName)&&this.getEndTime()==temp.getEndTime()&&this.getStartTime()==temp.getStartTime()) //if they have same name,start and end it will return true.Id will be different , no need to check.
			return true;
		return false;
	}
	/**
	 * clone() method that will return the clone of the activity object.It creates a deep copy.
	 */
	public Activity clone()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the new ActivityId:"); //enter a new id for the cloning object as id can't be the same.
		String id=input.next();
		return new Activity(this,id); //creating a new Activity object ad returning a deep copy.
		
	}
	
	
}
