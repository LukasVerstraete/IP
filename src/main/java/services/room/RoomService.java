package services.room;

import db.Database;
import db.DatabaseFactory;
import domain.Room;
import java.util.ArrayList;
import services.Service;
import util.MemoryLocation;
import util.ServiceException;

public class RoomService implements Service<Room> {

    private Database<Room> database;
    
    public RoomService(MemoryLocation location) throws ServiceException
    {
        try 
        {
            DatabaseFactory factory = new DatabaseFactory();
            database = factory.getDatabase(location, Room.class);
        } 
        catch(Exception e)
        {
            throw new ServiceException("Problem while initialising database: ", e);
        }    
    }
    
    public void add(Room room) throws ServiceException 
    {
        try 
        {
            database.add(room);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }

    public Room get(Object id) throws ServiceException 
    {
        try 
        {
            return database.get(id);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Room> getAll() throws ServiceException 
    {
        try 
        {
            return database.getAll();
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }

    public void update(Room room) throws ServiceException 
    {
        try
        {
            database.update(room);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }

    public void delete(Room room) throws ServiceException 
    {
        try
        {
            database.delete(room);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage());
        }
    }
    
}
