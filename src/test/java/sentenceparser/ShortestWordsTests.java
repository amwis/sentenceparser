package sentenceparser;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShortestWordsTests {

    @Test
    public void shouldReturnLongestWordFromTheSentence() throws Exception {
        String sentence = "list of words";

        assertEquals("[of]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldReturnAllWordsOfTheLongestLengthInTheSentence() throws Exception {
        String sentence = "words bards coats two four us of";

        assertEquals("[us, of]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldIgnoreMultipleWhiteSpaces() throws Exception {
        String sentence = "two three  four    us      five        twelve";

        assertEquals("[us]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldIgnorePunctuation() throws Exception {
        String sentence = "two. three four";

        assertEquals("[two]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldPickUpWordsSeparatedByPunctuation() throws Exception {
        String sentence = "one two ab,cd.ef-gh;ij";

        assertEquals("[ab, cd, ef, gh, ij]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldIgnoreQuotationMarks() throws Exception {
        String sentence = "two one ab\" \"cd' `ef`";

        assertEquals("[ab, cd, ef]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldIncludeUnderscoresInWords() throws Exception {
        String sentence = "two one a_ four";

        assertEquals("[a_]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldIncludeNumbersAsWords() throws Exception {
        String sentence = "two one five_ 12";

        assertEquals("[12]", getShortestWordsForSentence(sentence));
    }

    @Test
    public void shouldIncludeNumbersMixedWithLettersAsWords() throws Exception {
        String sentence = "two one five_ 1a";

        assertEquals("[1a]", getShortestWordsForSentence(sentence));
    }

    // helpers
    private String getShortestWordsForSentence(String sentence) {
        Map.Entry<List<String>, Integer> entry = SentenceParser.shortestWordWithLength(sentence).entrySet().iterator().next();
        return String.valueOf(entry.getKey());
    }
}

