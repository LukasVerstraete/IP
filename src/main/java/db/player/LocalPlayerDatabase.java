package db.player;

import db.Database;
import domain.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.DatabaseException;

/**
 * Created by Lukas on 21-2-2016.
 */
public class LocalPlayerDatabase implements Database<Player> {

    public Map<String,Player> players;

    public LocalPlayerDatabase()
    {
        players = new  HashMap<String,Player>();
        add(new Player("lukas", "lukas", "verstraete"));
    }

    public void add(Player player) throws DatabaseException
    {
        if(player == null)
            throw new DatabaseException("Cannot add NULL player");
        if(players.get(player.getName()) != null)
            throw new DatabaseException("This player already exists");
        else
            players.put(player.getUsername(), player);
    }

    public void update(Player player) throws DatabaseException
    {
        if(player == null)
            throw new DatabaseException("Cannot update NULL player;");
        if(players.get(player.getUsername()) == null)
            throw new DatabaseException("There is no player with the username: " + player.getUsername());
        else
            players.put(player.getName(), player);
    }

    public Player get(Object username) throws DatabaseException
    {
        
        if(players.get((String)username) == null)   
            throw new DatabaseException("The player with username " + (String)username + " does not exist.");
        else
            return players.get((String)username);
    }

    public List<Player> getAll() throws DatabaseException
    {
        return (List)players.values();
    }
    
    public void delete(Player player) throws DatabaseException
    {
        
        players.remove(player.getUsername());
    }

    public void closeConnection() throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
