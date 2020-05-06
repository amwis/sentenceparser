package sentenceparser;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongestWordsTests {

    @Test
    public void shouldReturnLongestWordFromTheSentence() throws Exception {
        String sentence = "list of words";

        assertEquals("[words]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldReturnAllWordsOfTheLongestLengthInTheSentence() throws Exception {
        String sentence = "words bards coats two four us";

        assertEquals("[words, bards, coats]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldIgnoreMultipleWhiteSpaces() throws Exception {
        String sentence = "two three  four    us      five        twelve";

        assertEquals("[twelve]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldIgnorePunctuation() throws Exception {
        String sentence = "two three. four";

        assertEquals("[three]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldPickUpWordsSeparatedByPunctuation() throws Exception {
        String sentence = "one two abcde,fghij.klmno-pqrst;uvwxy";

        assertEquals("[abcde, fghij, klmno, pqrst, uvwxy]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldIgnoreQuotationMarks() throws Exception {
        String sentence = "two one abcd\" \"efgh' `ijkl`";

        assertEquals("[abcd, efgh, ijkl]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldIncludeUnderscoresInWords() throws Exception {
        String sentence = "two one five_ four";

        assertEquals("[five_]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldIncludeNumbersAsWords() throws Exception {
        String sentence = "two one five_ 666666";

        assertEquals("[666666]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldIncludeNumbersMixedWithLettersAsWords() throws Exception {
        String sentence = "two one five_ 1a2a3a4a";

        assertEquals("[1a2a3a4a]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldReturnNothingForEmptyString() throws Exception {
        String sentence = "";

        assertEquals("[]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldReturnNothingForStringContainingPunctuationAndWhiteSpacesOnly() throws Exception {
        String sentence = ",,, -- ;:|";

        assertEquals("[]", getLongestWordsForSentence(sentence));
    }

    @Test
    public void shouldIgnoreNonLatinLetters() throws Exception {
        String sentence = "a bc Привет";

        assertEquals("[bc]", getLongestWordsForSentence(sentence));
    }

    // helpers
    private String getLongestWordsForSentence(String sentence) {
        Map.Entry<List<String>, Integer> entry = SentenceParser.longestWordWithLength(sentence).entrySet().iterator().next();
        return String.valueOf(entry.getKey());
    }
}
