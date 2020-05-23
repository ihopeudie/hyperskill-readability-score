package readability.score;

import readability.text.TextStats;

public class ClScoreTest extends ScoreTest {

    public ClScoreTest(TextStats textStats) {
        super(textStats);
        this.name = "Coleman–Liau index";
    }

    @Override
    double calcScore() {
        double L = (double) textStats.getCharactersCount() / textStats.getWordsCount() * 100;
        double S = (double) textStats.getSentencesCount() / textStats.getWordsCount() * 100;
        return 0.0588 * L - 0.296 * S - 15.8;
    }
}
