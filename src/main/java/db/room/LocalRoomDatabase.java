package db.room;

import db.Database;
import domain.Player;
import domain.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.DatabaseException;

public class LocalRoomDatabase implements Database<Room> {
    
    public Map<String,Room> rooms;
    
    public LocalRoomDatabase()
    {
        rooms = new HashMap<String,Room>();
        rooms.put("The green room", new Room("The green room"));
        rooms.put("oval office", new Room("oval office", 20));
    }
    
    public void add(Room room) throws DatabaseException 
    {
        if(room == null)
            throw new DatabaseException("Cannot add NULL room");
        if(rooms.get(room.getName()) != null)
            throw new DatabaseException("This room already exists");
        else
            rooms.put(room.getName(), room);
//        for(Room r : rooms)
//        {
//            if(r.getName().equals(room.getName()))
//                throw new DatabaseException("The room " + room.getName() + " already exists.");
//        }
//        if(room != null)
//            rooms.add(room);
//        else
//            throw new DatabaseException("Cannot add NULL room;");
    }

    public void update(Room room) throws DatabaseException 
    {
        if(room == null)
            throw new DatabaseException("Cannot update NULL room;");
        if(rooms.get(room.getName()) == null)
            throw new DatabaseException("There is no room with the name: " + room.getName());
        else
            rooms.put(room.getName(), room);
    }

    public Room get(Object name) throws DatabaseException 
    {
        if(rooms.get((String)name) == null)   
            throw new DatabaseException("The room with name " + (String)name + " does not exist.");
        else
            return rooms.get((String)name);
    }

    public List<Room> getAll() throws DatabaseException 
    {
        return (List)rooms.values();
    }

    public void delete(Room room) throws DatabaseException 
    {
        rooms.remove(room.getName());
    }

    public void closeConnection() throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
