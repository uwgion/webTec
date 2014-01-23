package helpers;

/**
 * Exception to be thrown in case an address wasn't found.
 * @author Kazakor
 *
 */
public class AddressNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4126600231300360265L;
	  public AddressNotFoundException() { 
		  super(); 
	  }
	  
	  public AddressNotFoundException(String message) {
		  super(message); 
	  }

}
