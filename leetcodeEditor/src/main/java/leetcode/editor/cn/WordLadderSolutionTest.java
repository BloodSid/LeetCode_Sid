package leetcode.editor.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * WordLadderSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 03/16/2022
 */
public class WordLadderSolutionTest {
    WordLadderSolution.Solution solution = new WordLadderSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: ladderLength(String beginWord, String endWord, List<String> wordList)
     */
    @Test
    public void testLadderLength1() throws Exception {
        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        int expected = 5;
        int actual = solution.ladderLength(beginWord, endWord, wordList);
        assertEquals(expected, actual);
    }

    @Test
    public void testLadderLength2() throws Exception {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        int expected = 0;
        int actual = solution.ladderLength(beginWord, endWord, wordList);
        assertEquals(expected, actual);
    }

}
