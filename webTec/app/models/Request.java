package models;

import java.util.Date;

import org.mongojack.DBRef;
import org.mongojack.MongoCollection;

import play.data.validation.Constraints.Required;

@MongoCollection(name = "requests")
public class Request extends Entity{

	public DBRef<Route, String> route;
	public DBRef<User, String> requestingUser;
	
	@Required
	public int seats;
	
	@Required
	public String startAddressForm;
	public DBRef<Marker, String> startAddress;
	
	@Required
	public String destinationAddressForm;
	public DBRef<Marker, String> destinationAddress;
	
	public String status;
	public Date dateCreated;

}
