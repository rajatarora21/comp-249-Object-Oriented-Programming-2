// -----------------------------------------------------
 // Assignment (A3)
 // Question: (Part 1)
 // Written by: (Rajat Arora 40078146)
 // ----------------------------------------------------- 
/**
 *  Name(s) and ID(s) (Rajat Arora 40078146)
 * COMP249
 * Assignment # (3)
 * Due Date (4th August)
 * @author Rajat ARORA
 *	This class is responsible for throwing exception if	the directory is empty
 */
public class EmptyFolderException extends Exception {

	public EmptyFolderException()
	{
		super();
	}
	public EmptyFolderException(String msg)
	{
		super(msg);
	}
}
