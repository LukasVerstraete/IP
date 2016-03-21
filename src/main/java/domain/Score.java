package domain;

/**
 * Created by Lukas on 9-2-2016.
 */
public class Score {

    private int _score;
    private int _minutesPlayed;

    public Score()
    {
        this(0);
    }

    public Score(int score)
    {
        setScore(score);
    }

    public void setScore(int score)
    {
        if(score < 0) return;
        _score = score;
    }

    public int getScore()
    {
        return _score;
    }

    public void setMinutesPlayed(int minutesPlayed)
    {
        if(minutesPlayed < 0) return;
        _minutesPlayed = minutesPlayed;
    }

    public int getMinutesPlayed()
    {
        return _minutesPlayed;
    }

    public void addPoints(int amount)
    {
        _score += amount;
    }
}
