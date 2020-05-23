package readability.text;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextStats {
    String text;
    List<String> words;
    int wordsCount;
    int sentencesCount;
    int charactersCount;
    int syllablesCount;
    int polysyllablesCount;

    public TextStats(String text) {
        this.text = text;
        this.words = splitTextToWords(this.text);
        this.wordsCount = words.size();
        this.sentencesCount = splitTextToSentences().size();
        this.charactersCount = countCharacters();
        this.syllablesCount = countSyllables();
        this.polysyllablesCount = countPolysyllables();
    }

    private int countPolysyllables() {
        return (int) words.stream().filter(w -> countSyllablesInWord(w) > 2).count();
    }

    private int countSyllables() {
        return words.stream().mapToInt(this::countSyllablesInWord).sum();
    }

    private int countSyllablesInWord(String word) {
        Pattern vowels = Pattern.compile("[aeiouyAEIOUY]");
        Matcher vowelMatcher = vowels.matcher(word);
        int counter = (int) vowelMatcher.results().count();
        Pattern doubleVowels = Pattern.compile("[aeiouyAEIOUY]{2}");
        Matcher doubleVowelsMatcher = doubleVowels.matcher(word);
        int from = 0;
        int count = 0;
        while (doubleVowelsMatcher.find(from)) {
            count++;
            from = doubleVowelsMatcher.start() + 1;
        }
        int doubleVowelsCount = count;
        counter -= doubleVowelsCount;
        if (word.endsWith("e")) {
            counter--;
        }
        return Math.max(counter, 1);
    }

    private int countCharacters() {
        return text.replaceAll("\\s+", "").length();
    }

    private List<String> splitTextToSentences() {
        return Arrays.asList(this.text.split("!+\\s*|\\?+\\s*|\\.+\\s*"));
    }

    private List<String> splitTextToWords(String text) {
        return Arrays.asList(text.replaceAll("[.?!,:]", "").split("\\s+"));
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public int getSentencesCount() {
        return sentencesCount;
    }

    public void setSentencesCount(int sentencesCount) {
        this.sentencesCount = sentencesCount;
    }

    public int getCharactersCount() {
        return charactersCount;
    }

    public void setCharactersCount(int charactersCount) {
        this.charactersCount = charactersCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSyllablesCount() {
        return syllablesCount;
    }

    public void setSyllablesCount(int syllablesCount) {
        this.syllablesCount = syllablesCount;
    }

    public int getPolysyllablesCount() {
        return polysyllablesCount;
    }

    public void setPolysyllablesCount(int polysyllablesCount) {
        this.polysyllablesCount = polysyllablesCount;
    }
}
