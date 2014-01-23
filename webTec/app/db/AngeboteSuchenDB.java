package db;

import models.AngebotSuchen;
import play.Logger;

import com.mongodb.DB;


public class AngeboteSuchenDB extends Finder<AngebotSuchen>{
        public static final String COLLECTION_ANGEBOTESUCHEN = "markers";
    private static AngeboteSuchenDB instance = new AngeboteSuchenDB(DBConnect.getDB());

        public AngeboteSuchenDB(DB db) {
                super(db, COLLECTION_ANGEBOTESUCHEN, AngebotSuchen.class);
        }

         public static void init() {
         Logger.info("Initializing DB. Ensuring indexes.");
                 //in case, then mongod --setParameter textSearchEnabled=true
                 //getInstance().db.getCollection(COLLECTION_ANGEBOTESUCHEN).ensureIndex(new BasicDBObject("email",1));
                 getInstance().db.getCollection(COLLECTION_ANGEBOTESUCHEN);

         }
    
        public static AngeboteSuchenDB getInstance(){
                return instance;
        }

}