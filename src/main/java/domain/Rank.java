package domain;

/**
 * Created by Lukas on 8-2-2016.
 */
public enum  Rank {

    NOOB("noob", 0, 200),
    APPRENTICE("apprentice", 201, 600),
    BEGINNER("beginner", 601, 1000),
    MASTER("master", 1001, 2000);

    private String name;
    private int beginRange;
    private int endRange;

    Rank(String name, int beginRange, int endRange)
    {
        this.name = name;
        this.beginRange = beginRange;
        this.endRange = endRange;
    }

    public String get_name()
    {
        return name;
    }

    public int get_beginRange()
    {
        return beginRange;
    }

    public int get_endRange()
    {
        return endRange;
    }

    public static Rank getRank(int score)
    {
        Rank[] ranks = Rank.values();
        for(int i = 0; i < ranks.length; i++) if(score >= ranks[i].get_beginRange() && score <= ranks[i].get_endRange()) return ranks[i];

        return null;
    }
}
