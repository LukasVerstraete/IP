/**
 * Created by Lukas on 8-2-2016.
 */
public class Player {

    private String _username;
    private String _name;
    private String _familyName;
    private Score _score;

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

    public void setUsername(String username) {
        if(username == null) return;
        _username = username;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        if(name == null) return;
        _name = name;
    }

    public String getFamilyName() {
        return _familyName;
    }

    public void setFamilyName(String familyName) {
        if(familyName == null) return;
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

