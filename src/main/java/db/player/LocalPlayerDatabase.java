package db.player;

import db.Database;
import domain.Player;
import java.util.ArrayList;
import util.DatabaseException;

/**
 * Created by Lukas on 21-2-2016.
 */
public class LocalPlayerDatabase implements Database<Player> {

    public ArrayList<Player> players;

    public LocalPlayerDatabase()
    {
        players = new  ArrayList<Player>();
        add(new Player("lukas", "lukas", "verstraete"));
    }

    public void add(Player player) throws DatabaseException
    {
        for(Player p : players)
        {
            if(p.getUsername().equals(player.getUsername()))
                throw new DatabaseException("The player " + player + " already exists.");
        }
        if(player != null)
            players.add(player);
        else
            throw new DatabaseException("Cannot add NULL player;");
    }

    public void update(Player player) throws DatabaseException
    {
        if(player == null)
            throw new DatabaseException("Cannot update NULL player;");
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getUsername().equals(player.getUsername()))
            {
                players.set(i, player);
                return;
            }
        }
        throw new DatabaseException("There is no player with the username: " + player.getUsername());
    }

    public Player get(Object username) throws DatabaseException
    {
        
        for(Player player : players)
        {
            if(player.getUsername().equals((String)username))
                return player;
        }    
        throw new DatabaseException("The player with username " + (String)username + " does not exist.");
    }

    public ArrayList<Player> getAll() throws DatabaseException
    {
        return players;
    }
    
    public void delete(Player player) throws DatabaseException
    {
        
        players.remove(player);
    }

    public void closeConnection() throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
