package services;

import db.LocalDatabase;
import db.Database;
import domain.Player;
import java.util.ArrayList;
import util.ServiceException;

/**
 * Created by Lukas on 21-2-2016.
 */
public class PlayerService implements Service<Player> {

    private Database database;

    public PlayerService(String databaseType)
    {
        if(databaseType.equals("memory"))
            database = new LocalDatabase();
        else
            database = new LocalDatabase();
    }

    public void add(Player player) throws ServiceException 
    {
        try{
            database.addPlayer(player);
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
            return database.getPlayer((String)username);
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
            return database.getAllPlayers();
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void update(Player player) throws ServiceException
    {
        try{
            database.updatePlayer(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void delete(Player player) throws ServiceException
    {
        try{
            database.deletePlayer(player);
        } 
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
