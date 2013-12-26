import play.Application;
import play.GlobalSettings;
import db.DBConnect;
import db.MarkerDB;
import db.RouteDB;
import db.UserDB;

public class Global extends GlobalSettings{
	
	  public void onStart(Application app) {
		  UserDB.init();
		  MarkerDB.init();
          RouteDB.init();
	  }
      
      public void onStop(Application app) {
              DBConnect.dispose();
              super.onStop(app);
      }

}
