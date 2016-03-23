package domain;

import util.DomainException;

/**
 * Created by Lukas on 8-2-2016.
 */
public class Player {

    private String _username;
    private String _name;
    private String _familyName;
    private Score _score;
    
    public Player() {}

    public Player(String username, String name, String familyName)
    {
        this(username, name, familyName, new Score());
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
        return _username;
    }

    public void setUsername(String username) throws DomainException {
        if(username == null || username.isEmpty()) 
            throw new DomainException("Please enter a valid username.");
        _username = username;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        if(name == null)
            throw new DomainException("Please enter a name for this player.");
        _name = name;
    }

    public String getFamilyName() {
        return _familyName;
    }

    public void setFamilyName(String familyName) {
        if(familyName == null) 
            throw new DomainException("Please enter a family name for this player.");
        this._familyName = familyName;
    }

    public Score getScore() {
        return _score;
    }

    public void setScore(Score score) {
        if(score == null) return;
        _score = score;
    }

    public void setScore(int score)
    {
        _score.setScore(score);
    }

    public Rank getRank()
    {
        return Rank.getRank(_score.getScore());
    }
}

