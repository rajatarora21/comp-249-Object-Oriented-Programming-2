// -----------------------------------------------------
 // Assignment (A4)
 // Question: (1)
 // Written by: (Rajat Arora 40078146)
 // ----------------------------------------------------- 

/**
 * Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (A4)
 * Due Date (11th August 2019)
 * 
 * @author Rajat Arora
 *	This is a interface .It has one method that is required by the Activity class to check if 2 activities are on same time or not.
 */
public interface Commitable 
{
	/**
	 * 
	 * @param S an reference of type Activity
	 * @return a String value
	 */
	String isOnSameTime(Activity S);
}
