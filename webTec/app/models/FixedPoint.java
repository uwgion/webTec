package models;

import org.mongojack.DBRef;

public class FixedPoint extends Entity{

	public DBRef<Marker, String> marker;
	
}
