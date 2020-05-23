package readability.score;

import readability.text.TextStats;

public class AriScoreTest extends ScoreTest {

    public AriScoreTest(TextStats stats) {
        super(stats);
        this.name = "Automated Readability Index";
    }

    @Override
    double calcScore() {
        return (4.71 * (double) textStats.getCharactersCount() / textStats.getWordsCount()) + (0.5 * (double) textStats.getWordsCount() / textStats.getSentencesCount()) - 21.43;
    }
}
