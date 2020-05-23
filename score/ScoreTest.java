package readability.score;

import readability.text.TextProcessor;
import readability.text.TextStats;

public abstract class ScoreTest {
    String name;
    TextStats textStats;
    double score;

    public ScoreTest(TextStats textStats) {
        this.textStats = textStats;
        this.score = calcScore();
    }

    abstract double calcScore();

    @Override
    public String toString() {
        return String.format("%s: %.2f (about %d year olds).", name, score, TextProcessor.getAgeGroup(score));
    }

    public double getScore() {
        return score;
    }
}
