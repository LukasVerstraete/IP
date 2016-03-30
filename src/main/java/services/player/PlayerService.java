package services.player;

import db.player.LocalPlayerDatabase;
import db.Database;
import db.DatabaseFactory;
import domain.Player;
import java.util.ArrayList;
import services.Service;
import util.MemoryLocation;
import util.ServiceException;

/**
 * Created by Lukas on 21-2-2016.
 */
public class PlayerService implements Service<Player> {

    private Database<Player> database;

    public PlayerService(MemoryLocation location)
    {
        DatabaseFactory factory = new DatabaseFactory();
        database = factory.getDatabase(location, Player.class);
    }

    public void add(Player player) throws ServiceException 
    {
        try{
            database.add(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Player get(Object username) throws ServiceException 
    {
        try
        {
            return database.get(username);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public ArrayList<Player> getAll() throws ServiceException
    {
        try
        {
            return database.getAll();
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(Player player) throws ServiceException
    {
        try{
            database.update(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(Player player) throws ServiceException
    {
        try{
            database.delete(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
