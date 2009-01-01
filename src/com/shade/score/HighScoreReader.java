package com.shade.score;

public interface HighScoreReader {

    /**
     * Return an ordered list of scores.
     * 
     * @param limit Return this many, set to zero to return all.
     * @return
     */
    public String[][] getScores(int limit);
}
