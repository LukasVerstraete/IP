/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.player.LocalPlayerDatabase;
import db.room.LocalRoomDatabase;
import domain.Player;
import domain.Room;
import util.DatabaseException;
import util.MemoryLocation;

public class DatabaseFactory {
    
    public DatabaseFactory() {}
    
    public Database getDatabase(MemoryLocation location, Class type) throws DatabaseException
    {
        Database database = null;
        if(location == MemoryLocation.LOCAL)
            database = getLocalDatabase(type);
//        if(location == MemoryLocation.REMOTE)
//            database = getRemoteDatabase(type);
        return database;
    }
    
    private Database getLocalDatabase(Class type) throws DatabaseException
    {
        if(type.getCanonicalName().equals(Player.class.getCanonicalName()))
            return new LocalPlayerDatabase();
        else if(type.getCanonicalName().equals(Room.class.getCanonicalName()))
            return new LocalRoomDatabase();
        else
            throw new DatabaseException("Undefined database classtype: " + type.getSimpleName());
    }
    
//    private Database getRemoteDatabase(Class type)
//    {
//        if(type.getCanonicalName().equals(Player.class.getCanonicalName()))
//            return new RemotePlayerDatabase();
//        else if(type.getCanonicalName().equals(Room.class.getCanonicalName()))
//            return new RemoteRoomDatabase();
//        else
//            throw new DatabaseException("Undefined database classtype: " + type.getSimpleName());
//    }
}
