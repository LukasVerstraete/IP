/**
 * Created by Lukas on 21-2-2016.
 */
public class BasicPlayerService implements PlayerService {

    private Database database;

    public BasicPlayerService()
    {
        database = new LocalDatabase();
    }

    public void addPlayer(Player player) {
        database.addPlayer(player);
    }

    public Player getPlayer(String username) {
        return database.getPlayer(username);
    }

    public Player createPlayer(String username, String name, String familyName) {
        return createPlayer(username, name, familyName);
    }

    public Player createPlayer(String username, String name, String familyName, int score) {
        Player player = new Player(username, name, familyName, score);
        database.addPlayer(player);
        return player;
    }

    public void updatePlayer(Player player) {
        database.updatePlayer(player);
    }

    public void deletePlayer(String username) {
        database.deletePlayer(username);
    }
}
