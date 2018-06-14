package assgn1;

public class ElementOutOfBoundsException extends RuntimeException{

	 public ElementOutOfBoundsException (float value)
	    {
		    super (String.format("%f%s", value, " exceeds range of -1.0 to 1.0; algorithm terminating...").toString());
	    }
}
