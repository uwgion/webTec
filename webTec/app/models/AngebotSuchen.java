package models;

import play.data.validation.Constraints.Required;

public class AngebotSuchen {

	@Required
	public String startAdresse;

	@Required
	public String zielAdresse;
}
