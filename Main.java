package readability;

import readability.score.ScoreTest;
import readability.text.TextProcessor;
import readability.text.TextStats;
import readability.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("No input file name in arguments");
        }
        String fileName = args[0];
        String text = Util.readFile(fileName);
        TextProcessor processor = new TextProcessor();
        System.out.println(processor.getTextStatsString(text));
        List<ScoreTest> tests = Util.readTests(new TextStats(text));
        tests.forEach(System.out::println);
        double average = tests.stream().mapToDouble(e -> TextProcessor.getAgeGroup(e.getScore())).average().orElse(0d);
        System.out.println();
        System.out.println(String.format("This text should be understood in average by %.2f year olds", average));
    }
}
