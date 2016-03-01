import java.util.HashMap;

/**
 * Created by Lukas on 21-2-2016.
 */
public class LocalDatabase implements Database {

    public HashMap<String, Player> players;

    public LocalDatabase()
    {
        players = new HashMap<String, Player>();
    }

    public void addPlayer(Player player)
    {
        if(player != null)
        {
            players.put(player.getUsername(), player);
        }
    }

    public void updatePlayer(Player player) {
        addPlayer(player);
    }

    public Player getPlayer(String username)
    {
        return players.get(username);
    }

    public void deletePlayer(String username) {
        players.remove(username);
    }
}
