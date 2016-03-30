package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import util.DomainException;

@Entity
public class Player implements Serializable {

    @Id
    private String username;
    private String name;
    private String familyName;
    //private Score _score;
    
    public Player() {}

    public Player(String username, String name, String familyName)
    {
        //this(username, name, familyName, new Score());
        setUsername(username);
        setName(name);
        setFamilyName(familyName);
    }

//    public Player(String username, String name, String familyName, int score)
//    {
//        this(username, name, familyName, new Score(score));
//    }
//
//    public Player(String username, String name, String familyName, Score score)
//    {
//        setUsername(username);
//        setName(name);
//        setFamilyName(familyName);
//        setScore(score);
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws DomainException {
        if(username == null || username.isEmpty()) 
            throw new DomainException("Please enter a valid username.");
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws DomainException 
    {
        if(name == null || name.isEmpty())
            throw new DomainException("Please enter a name for this player.");
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) throws DomainException
    {
        if(familyName == null || familyName.isEmpty()) 
            throw new DomainException("Please enter a family name for this player.");
        this.familyName = familyName;
    }

//    public Score getScore() {
//        return _score;
//    }
//
//    public void setScore(Score score) {
//        if(score == null) return;
//        _score = score;
//    }
//
//    public void setScore(int score)
//    {
//        _score.setScore(score);
//    }
//
//    public Rank getRank()
//    {
//        return Rank.getRank(_score.getScore());
//    }
    
    @Override
    public String toString()
    {
        return "Username: " + this.username + "\nName: " + this.name + "\nFamily name: " + this.familyName;
    }
}

