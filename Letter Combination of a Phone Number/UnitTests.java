import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class UnitTests {

    @Test
    public void testExample1() {
        LetterCombinations lc = new LetterCombinations();
        List<String> result = lc.letterCombinations("23");
        List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        assertTrue(result.containsAll(expected) && result.size() == expected.size());
    }

    @Test
    public void testEmptyInput() {
        LetterCombinations lc = new LetterCombinations();
        List<String> result = lc.letterCombinations("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleDigit() {
        LetterCombinations lc = new LetterCombinations();
        List<String> result = lc.letterCombinations("2");
        List<String> expected = Arrays.asList("a", "b", "c");
        assertEquals(expected, result);
    }

    @Test
    public void testAllDigits() {
        LetterCombinations lc = new LetterCombinations();
        List<String> result = lc.letterCombinations("9");
        List<String> expected = Arrays.asList("w", "x", "y", "z");
        assertEquals(expected, result);
    }
}
