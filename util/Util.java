package readability.util;

import readability.score.*;
import readability.text.TextStats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    public static final String ARI = "ARI";
    public static final String FK = "FK";
    public static final String CL = "CL";
    public static final String SMOG = "SMOG";
    public static final String ALL = "all";

    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<ScoreTest> readTests(TextStats stats) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<ScoreTest> result = new ArrayList<>();
            while (result.isEmpty()) {
                System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all)");
                switch (scanner.nextLine()) {
                    case ARI:
                        result.add(new AriScoreTest(stats));
                        break;
                    case FK:
                        result.add(new FkScoreTest(stats));
                        break;
                    case SMOG:
                        result.add(new SmogScoreTest(stats));
                        break;
                    case CL:
                        result.add(new ClScoreTest(stats));
                        break;
                    case ALL: {
                        result.add(new AriScoreTest(stats));
                        result.add(new FkScoreTest(stats));
                        result.add(new SmogScoreTest(stats));
                        result.add(new ClScoreTest(stats));
                    }
                }
            }
            return result;
        }
    }
}
