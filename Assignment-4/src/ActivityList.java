// -----------------------------------------------------
 // Assignment (A4)
 // Question: (3)
 // Written by: (Rajat Arora 40078146)
 // ----------------------------------------------------- 

/**
 * * Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (A4)
 * Due Date (11th August 2019)
 
 * @author Rajat Arora
 *	This is the ActivityList class.This class behaves as a linked list of activity objects.This class has a inner class that behaves as a node in the list.A node will contain the data and a reference to next node in the list.
 *	This class have attributes and methods to perform various actions on the list.The class have getters,setters and overridden methods.
 *
 */
class ActivityList 
{
	/**
	 * 
	 * @author Rajat Arora
	 *	This is the inner class .It acts a node in the list.
	 */
	class ActivityNode
	{
		//data attributes
		private Activity activity;
		private ActivityNode next;
		/**
		 * default constructor
		 */
		ActivityNode()
		{
			this.activity=null;
			this.next=null;
		}
		/**
		 * 
		 * @param activity a reference of Activity type
		 * @param node a reference of ActivityNode type
		 */
		ActivityNode(Activity activity,ActivityNode node)
		{
			this.activity=activity;
			this.next=node;
		}
		/**
		 * This is the copy constructor of the node.
		 * @param activityNode a reference of type ActivityNode
		 */
		ActivityNode(ActivityNode activityNode)
		{
			this.activity=activityNode.getActivity().clone(); //it will create a deep copy of the node.
			this.next=activityNode.next; //the next will point to the next of activityNode.
		}
		/**
		 * 
		 * @return activity a Activity type
		 */
		public Activity getActivity() {
			return activity;
		}
		/**
		 * 
		 * @param activity a Activity type
		 */
		public void setActivity(Activity activity) {
			this.activity = activity;
		}
		/**
		 * 
		 * @return next a ActivityNode type
		 */
		public ActivityNode getNode() {
			return next;
		}
		/**
		 * 
		 * @param node a ActivityNode type
		 */
		public void setNode(ActivityNode node) {
			this.next = node;
		}
		/**
		 * this is the clone method that will return the clone of ActivityNode object.
		 */
		public ActivityNode clone()
		{
			return new ActivityNode(this); //it will return the deep copy of ActivityNode.
		}
		
	}
	//data attributes
	private ActivityNode head;
	private int size=0;
	/**
	 * default constructor
	 */
	ActivityList()
	{
		this.head=null;
		this.size=0;
	}
	/**
	 * this is the copy constructor
	 * @param list a ActivityList type
	 */
	ActivityList(ActivityList list)
	{
		//this method will a deep copy of list.
		int index=0;
		ActivityNode temp=list.head; 
		while(temp!=null) //iterating till temp is null
		{
			this.insertAtIndex(index++,temp.getActivity().clone()); //it will create a new Activity object of the nodes in the list.Resulting in the deep copy of the list
			temp=temp.next;
		}
		
	}
	/**
	 * 
	 * @return head a ActivityNode type
	 * this will return the head of the list
	 */
	public ActivityNode getHead() {
		return head;
	}
	/**
	 * 
	 * @param head a ActivityNode type
	 * this will set the head of the list
	 */
	public void setHead(ActivityNode head) {
		this.head = head;
	}
	/**
	 * 
	 * @return size a integer type
	 * return the size of the list
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 	
	 * @param activity a Activity type
	 * this method will add the element at the starting of the list
	 */
	void addToStart(Activity activity)
	{
		size++; //increase the size by 1.
		ActivityNode nodeInsert=new ActivityNode(); //creating a new node.
		nodeInsert.activity=activity; //assigning the activity
		ActivityNode temp=head; //creating a temporary variable to store the head reference
		head=nodeInsert; //assigning head to the new object.
		nodeInsert.next=temp; //next of new object will point to the temp.
		
	}
	/**
	 * 
	 * @param index a integer type
	 * @param activity a Activity type.
	 * this method will add the node a particular index.
	 */
	void insertAtIndex(int index,Activity activity)
	{
		if(activity.getActivityID()!=null) //if the activity is not null then proceed.
		{
			if(index<0||index>=(size+1)) //if the user enters an invalid index .The program will terminate.
			{
				System.exit(0);
			}
			ActivityNode nodeInsert=new ActivityNode(); //creation of new Node.
			nodeInsert.activity=activity; //assigning the activity.
			if(head==null) //if the head is null, means no elements in the list then add the node to start. 
			{
				addToStart(activity);
			}
			else
			{
				ActivityNode temp=head;
				for(int i=0;i<index-1;i++) //the loop will iterate till the insert location-1.The previous node to the inserting location will point to the new new node and the new node will point to the next next.
				{
					temp=temp.next;
				}
				ActivityNode temp2=temp.next; //storing the reference in temporary variable.
				temp.next=nodeInsert; //assigning the previous element next to the new node.
				nodeInsert.next=temp2; //the new node next will point to the next element.
				size++; //increase the size.
			}
		}
		else
		{
			return;
		}
		
	}
	/**
	 * 
	 * @param index an integer type.
	 * this method will delete a node from a particular index.
	 */
	void deleteFromIndex(int index)
	{
		if(index==0) //if the user wants to delete from the 0 index then , call the deletefromstart method
		{
			deleteFromStart();
		}
		else
		{
			ActivityNode temp=head; //a temp variable that will iterate through the list.
			for(int i=0;i<index-1;i++) //iterating till previous node of the deleting element.just assigning the previous node next to the node after the deleting object.
			{
				temp=temp.next;
			}
			ActivityNode temp2=temp.next; //temp2 is the deleting node.
			temp.next=temp2.next; //assigning the previous node next to node after the deleting object.
			temp2.next=null; //deleting the object by refering it to null.
			Activity.getUniqueId().remove(temp2.activity.getActivityID()); //removing the uniqueId from the Arraylist .
			size--; //decrease the size.
		}
		
	}
	/**
	 * this method will delete the node from the start.
	 */
	void deleteFromStart()
	{
		Activity.getUniqueId().remove(head.activity.getActivityID()); //removing the id from the arraylist.
		ActivityNode temp=head; //temp that will point to head.
		head=temp.next; //head will point to  temp.next
		temp.next=null;//temp.next=null will delete the first element.
		size--; //reduce the size.
		
	}
	/**
	 * 
	 * @param index an integer type
	 * @param activity an Activity type
	 * this method will replace the activity at a particular index.
	 */
	void replaceAtIndex(int index,Activity activity)
	{
		ActivityNode temp=head; //iterating through the element.
		for(int i=0;i<index;i++)
		{
			temp=temp.next;
		}
		temp.activity=activity; //assigning the current Activity to the new Activity.
	}
	/**
	 * 
	 * @param activityID a String type
	 * @return a ActivityNode type
	 * this method will find if a node exists using the activityId .if exits then return the reference of the node.
	 */
	ActivityNode find(String activityID)
	{
		ActivityNode temp=head; //temp for iteration
		while(temp!=null)
		{
			if(temp.activity.getActivityID()==null) //if a null value occurred in the list , then continue. 
			{
				temp=temp.next;
				continue;
			}
			else if(temp.activity.getActivityID().equals(activityID)) //if the desired node is found , then return the location.
			{
				return temp;
			}	
			temp=temp.next;
		}
		return null;
	}
	/**
	 * 
	 * @param activityID A String type
	 * @return a boolean value
	 * this method checks if a node exists or not.
	 */
	boolean contains(String activityID)
	{
		ActivityNode check=find(activityID); //using the find method to check if the value is present in the list.
		if(check!=null) //if the reference id returned that is not null , then return true.
			return true;
		return false; //else return false
	}
	/**
	 * display method that will display the entire list
	 */
	void display()
	{
		ActivityNode temp=head; //temp variable starting from head ,as the starting position.
		while(temp!=null) //iterates till the value is not null.
		{
			
			if(temp.activity.getActivityID()==null) //if a null node occurrence is found then continue
			{
				temp=temp.next;
				continue;
			}
			else //print the data.
			{
				System.out.println(temp.activity);
				temp=temp.next; //traversal of temp from node to other.
			}
			
		}
	}
	/**
	 * equals() method overridden from the object class that will check if 2 list have similar elements or not.
	 */
	public boolean equals(Object obj) 
	{
		ActivityList list=(ActivityList)obj; 
		if(list.getSize()!=this.getSize()) //if both the list have different size then return false.
			return false;
		else
		{
			int count=0;
			ActivityNode temp1=list.head;
			
			 //each element of first list will check every element of second list , on whether the same element is present in the list or not.
			while(temp1!=null) //traversal of first list.
			{
				ActivityNode temp2=this.head;
				while(temp2!=null) //traversal of second list
				{
					if(temp1.getActivity().equals(temp2.getActivity())) //if the same activity is found then increment the value of count by 1.
					{
						count++;
						break;//exit the loop , once similar element is found.
					}
					temp2=temp2.next; //traversal on inner loop.
				}
				temp1=temp1.next; //traversal on outer loop.
			}
			if(count==list.getSize()) //if the final value of count is equal to the size of list , then return true , otherwise return false. 
				return true;
			return false;
		}
	}
	
	
}

