/**
 * Created by Lukas on 8-2-2016.
 */
public interface Database {

    public void addPlayer(Player player);
    public void updatePlayer(Player player);
    public Player getPlayer(String username);
    public void deletePlayer(String username);

}
