package db;

import domain.Player;
import java.util.ArrayList;
import util.DatabaseException;

/**
 * Created by Lukas on 21-2-2016.
 */
public class LocalDatabase implements Database {

    public ArrayList<Player> players;

    public LocalDatabase()
    {
        players = new  ArrayList<Player>();
        addPlayer(new Player("lukas", "lukas", "verstraete"));
    }

    public void addPlayer(Player player) throws DatabaseException
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

    public void updatePlayer(Player player) throws DatabaseException
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

    public Player getPlayer(String username) throws DatabaseException
    {
        for(Player player : players)
        {
            if(player.getUsername().equals(username))
                return player;
        }    
        throw new DatabaseException("The player with username " + username + " does not exist.");
    }

    public ArrayList<Player> getAllPlayers() throws DatabaseException
    {
        return players;
    }
    
    public void deletePlayer(Player player) throws DatabaseException
    {
        
        players.remove(player);
    }
}
