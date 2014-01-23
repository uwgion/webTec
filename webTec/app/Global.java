
import models.FixedPoint;
import models.Marker;
import play.Application;
import play.GlobalSettings;
import db.AngeboteSuchenDB;
import db.DBConnect;
import db.FixedPointDB;
import db.MarkerDB;
import db.RouteDB;
import db.UserDB;

public class Global extends GlobalSettings {

	public void onStart(Application app) {
		UserDB.init();
		MarkerDB.init();
		RouteDB.init();	
		FixedPointDB.init();
        AngeboteSuchenDB.init();
		//create some test markers, aaaaaw yeeeeaaaah
		Marker tempMarker = MarkerDB.getInstance().create(new Marker("fixedPoint", "Radolfzell Bahnhof", 47.7242629,8.9349472));
		FixedPointDB fixedpoints = FixedPointDB.getInstance();
		FixedPoint fixed = new FixedPoint();
		fixed.markerId = tempMarker._id;
		fixedpoints.create(fixed);
		
		tempMarker = MarkerDB.getInstance().create(new Marker("fixedPoint", "Weiler Flughafen", 47.7173253, 8.937094199999999));
		fixed = new FixedPoint();
		fixed.markerId = tempMarker._id;
		fixedpoints.create(fixed);
		
	}

	public void onStop(Application app) {
		DBConnect.dispose();
		super.onStop(app);
	}

}
