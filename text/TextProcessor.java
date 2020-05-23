package readability.text;

public class TextProcessor {

    public String getTextStatsString(String text) {
        TextStats stats = new TextStats(text);
        return String.format("%s%s%s%s%s",
                String.format("Words: %d\r\n", stats.getWordsCount()),
                String.format("Sentences: %d\r\n", stats.getSentencesCount()),
                String.format("Characters: %d\r\n", stats.getCharactersCount()),
                String.format("Syllables: %d\r\n", stats.getSyllablesCount()),
                String.format("Polysyllables: %d\r\n", stats.getPolysyllablesCount())
        );
    }

    public static int getAgeGroup(double score) {
        int[] values = new int[]{6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24};
        int ind = (int) Math.ceil(score) - 1;
        if (ind < 0) {
            ind = 1;
        }
        if (ind > values.length-1) {
            ind = values.length-1;
        }
        return values[ind];
    }
}
