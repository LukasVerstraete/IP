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
    
    public void startGame()
    {
        hosting = true;
    }
    
    public void stopGame()
    {
        hosting = false;
        gamesHosted++;
    }
}
