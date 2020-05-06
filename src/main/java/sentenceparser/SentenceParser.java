package sentenceparser;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceParser {

    public static Map<List<String>, Integer> longestWordWithLength(String sentence) {
        String[] words = sentence.split("\\W+");

        List<String> longestWords = new ArrayList<String>();

        Map<List<String>, Integer> wordsAndLengths = new HashMap<List<String>, Integer>();

        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(0, word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        wordsAndLengths.put(longestWords, maxLength);

        return wordsAndLengths;
    }

    public static Map<List<String>, Integer> shortestWordWithLength(String sentence) {
        String[] words = sentence.split("\\W+");

        List<String> shortestWord = new ArrayList<String>();

        Map<List<String>, Integer> wordsAndLengths = new HashMap<List<String>, Integer>();

        int minLenght = words[0].length();

        for (String word : words) {
            if (word.length() < minLenght) {
                minLenght = word.length();
                shortestWord.clear();
                shortestWord.add(0, word);
            } else if (word.length() == minLenght) {
                shortestWord.add(word);
            }
        }

        wordsAndLengths.put(shortestWord, minLenght);

        return wordsAndLengths;
    }
}
