/**
 * Created by Lukas on 9-2-2016.
 */
public interface PlayerService {

    public void addPlayer(Player player);
    public Player getPlayer(String username);
    public Player createPlayer(String username, String name, String familyName);
    public Player createPlayer(String username, String name, String familyName, int score);
    public void updatePlayer(Player player);
    public void deletePlayer(String username);

}
