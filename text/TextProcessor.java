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
        switch ((int) Math.ceil(score)) {
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 9;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            case 12:
                return 18;
            case 13:
            case 14:
                return 24;
            default:
                return 5;
        }
    }
}
