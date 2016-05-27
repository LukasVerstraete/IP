package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Player implements Serializable {

    @Id
    @NotEmpty(message = "Please provide a username.")
    private String username;
    @NotEmpty(message = "Please provide a name.")
    private String name;
    @NotEmpty(message = "Please provide a family name.")
    private String familyName;
    private Score score;
    
    public Player() {}

    public Player(String username, String name, String familyName)
    {
        //this(username, name, familyName, new Score());
        setUsername(username);
        setName(name);
        setFamilyName(familyName);
    }

    public Player(String username, String name, String familyName, int score)
    {
        this(username, name, familyName, new Score(score));
    }

    public Player(String username, String name, String familyName, Score score)
    {
        setUsername(username);
        setName(name);
        setFamilyName(familyName);
        setScore(score);
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username)  
    {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)  
    {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) 
    {
        this.familyName = familyName;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        if(score == null) return;
        this.score = score;
    }

    public void setScore(int score)
    {
        this.score.setScore(score);
    }

    public Rank getRank()
    {
        return Rank.getRank(score.getScore());
    }
    
    @Override
    public String toString()
    {
        return "Username: " + this.username + "\nName: " + this.name + "\nFamily name: " + this.familyName;
    }
}

