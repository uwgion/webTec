package models;

import org.mongojack.DBRef;

public class Anfrage extends Entity{

	DBRef<Route, String> route;
	DBRef<User, String> requestingUser;
}
