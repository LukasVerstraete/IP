package db;

import domain.Player;
import java.util.ArrayList;
import util.DatabaseException;

/**
 * Created by Lukas on 8-2-2016.
 */
public interface Database {

    public void addPlayer(Player player) throws DatabaseException;
    public void updatePlayer(Player player) throws DatabaseException;
    public Player getPlayer(String username) throws DatabaseException;
    public ArrayList<Player> getAllPlayers() throws DatabaseException;
    public void deletePlayer(Player player) throws DatabaseException;

}
