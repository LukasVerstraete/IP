package db.room;

import db.Database;
import domain.Player;
import domain.Room;
import java.util.ArrayList;
import util.DatabaseException;

public class LocalRoomDatabase implements Database<Room> {
    
    public ArrayList<Room> rooms;
    
    public LocalRoomDatabase()
    {
        rooms = new ArrayList<Room>();
        rooms.add(new Room("The green room"));
        rooms.add(new Room("oval office", 20));
    }
    
    public void add(Room room) throws DatabaseException 
    {
        for(Room r : rooms)
        {
            if(r.getName().equals(room.getName()))
                throw new DatabaseException("The room " + room.getName() + " already exists.");
        }
        if(room != null)
            rooms.add(room);
        else
            throw new DatabaseException("Cannot add NULL room;");
    }

    public void update(Room room) throws DatabaseException 
    {
        if(room == null)
            throw new DatabaseException("Cannot update NULL room;");
        for(int i = 0; i < rooms.size(); i++)
        {
            if(rooms.get(i).getName().equals(room.getName()))
            {
                rooms.set(i, room);
                return;
            }
        }
        throw new DatabaseException("There is no room with the name: " + room.getName());
    }

    public Room get(Object name) throws DatabaseException 
    {
        for(Room room : rooms)
        {
            if(room.getName().equals((String)name))
                return room;
        }    
        throw new DatabaseException("The room with name " + (String)name + " does not exist.");
    }

    public ArrayList<Room> getAll() throws DatabaseException 
    {
        return rooms;
    }

    public void delete(Room room) throws DatabaseException 
    {
        rooms.remove(room);
    }

    public void closeConnection() throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
