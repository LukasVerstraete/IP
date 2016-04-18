package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import util.DomainException;

@Entity
public class Room implements Serializable {
    
    public static final int ROOM_CAPACITY = 4;
    
    @Id
    public String name;
    public int gamesHosted;
    private boolean hosting;
    private Player[] players = new Player[ROOM_CAPACITY];
    private int playersInRoom = 0;
    
    public Room(){}
    
    public Room(String name)
    {
        this(name, 0);
    }
    
    public Room(String name, int gamesHosted)
    {
        setName(name);
        setGamesHosted(gamesHosted);
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name) throws DomainException
    {
        if(name == null || name.isEmpty())
            throw new DomainException("Please enter a room name.");
        this.name = name;
    }
    
    public int getGamesHosted()
    {
        return gamesHosted;
    }
    
    public void setGamesHosted(int amount) throws DomainException
    {
        if(amount < 0)
            throw new DomainException("The amount of hosted games can not be below 0.");
        gamesHosted = amount;
    }
    
    public void addToRoom(Player player) throws DomainException
    {
        if(playersInRoom == 4) throw new DomainException("This room is full.");
        else players[playersInRoom] = player;
    }
    
    public void removeFromRoom(Player player)
    {
        for(int i = 0 ; i < ROOM_CAPACITY; i++)
        {
            if(players[i] == player)
            {
                for(int j = i; j < ROOM_CAPACITY; j++)
                {
                    if(j == ROOM_CAPACITY - 1)
                        players[j] = null;
                    else
                        players[j] = players[j + 1];
                }
            }
        }
    }
    
    public void startGame() throws DomainException
    {
        if(playersInRoom == 4)
            hosting = true;
        else
            throw new DomainException("There are not enough players in this room to start playing.");
    }
    
    public void stopGame() throws DomainException
    {
        if(hosting) {
            hosting = false;
            kickAllPlayers();
            gamesHosted++;
        }
        else
        {
            throw new DomainException("There is no game being hosted at the moment");
        }
    }
    
    private void kickAllPlayers()
    {
        for(int i = 0; i < ROOM_CAPACITY; i++)
        {
            players[i] = null;
        }
        playersInRoom = 0;
    }
}
