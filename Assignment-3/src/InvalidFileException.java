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
 * @author Rajat Arora
 *	This class is responsible for throwing exception if its an invalid file path.
 */
public class InvalidFileException extends Exception {

		public InvalidFileException()
		{
			super();
		}
		public InvalidFileException(String s)
		{
			super(s);
		}
}
