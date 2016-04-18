package domain;

import java.io.Serializable;

/**
 * Created by Lukas on 9-2-2016.
 */
public class Score implements Serializable{

    private int score;
    private int minutesPlayed;

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
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

    public void setMinutesPlayed(int minutesPlayed)
    {
        if(minutesPlayed < 0) return;
        this.minutesPlayed = minutesPlayed;
    }

    public int getMinutesPlayed()
    {
        return minutesPlayed;
    }

    public void addPoints(int amount)
    {
        score += amount;
    }
}
