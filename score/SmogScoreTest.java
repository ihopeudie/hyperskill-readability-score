package readability.score;

import readability.text.TextStats;

public class SmogScoreTest extends ScoreTest {

    public SmogScoreTest(TextStats textStats) {
        super(textStats);
        this.name = "Simple Measure of Gobbledygook";
    }

    @Override
    double calcScore() {
        return 1.043 * Math.sqrt((textStats.getPolysyllablesCount() * (30d / textStats.getSentencesCount()))) + 3.1291;
    }
}
