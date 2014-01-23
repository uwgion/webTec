package models;

import org.mongojack.MongoCollection;

import play.data.validation.Constraints.Required;

@MongoCollection(name = "markers")
public class AngebotSuchen extends Entity{

	@Required
	public String startAdresse;

	@Required
	public String zielAdresse;
}
