package readability.score;

import readability.text.TextStats;

public class FkScoreTest extends ScoreTest {

    public FkScoreTest(TextStats textStats) {
        super(textStats);
        this.name = "Flesch–Kincaid readability tests";
    }

    @Override
    double calcScore() {
        return 0.3 * ((double) textStats.getWordsCount() / textStats.getSentencesCount()) + 11.8 * ((double) textStats.getSyllablesCount() / textStats.getWordsCount()) - 15.59;
    }
}
