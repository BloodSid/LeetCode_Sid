import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-04-24 16:11
 */
public class SolutionTest {
    public static Solution solution = new Solution();

    private static boolean listEquls(List a, List b) {
        return a.containsAll(b);
    }

    @Test
    public void wordSubsetsTest1() {
        List<String> actual = solution.wordSubsets(
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"e", "o"});
        List<String> expected = new ArrayList<>();
        String[] exp =
                new String[]{"facebook", "google", "leetcode"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true, listEquls(actual, expected));

    }

    @Test
    public void wordSubsetsTest2() {
        List<String> actual = solution.wordSubsets(
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"l", "e"});
        List<String> expected = new ArrayList<>();
        String[] exp =
                new String[]{"apple", "google", "leetcode"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true, listEquls(actual, expected));

    }

    @Test
    public void wordSubsetsTest3() {
        List<String> actual = solution.wordSubsets(
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"e", "oo"});
        List<String> expected = new ArrayList<>();
        String[] exp =
                new String[]{"facebook", "google"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true, listEquls(actual, expected));

    }

    @Test
    public void wordSubsetsTest4() {
        List<String> actual = solution.wordSubsets(
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"lo", "eo"});
        List<String> expected = new ArrayList<>();
        String[] exp =
                new String[]{"google", "leetcode"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true, listEquls(actual, expected));

    }

    @Test
    public void wordSubsetsTest5() {
        List<String> actual = solution.wordSubsets(
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"ec", "oc", "ceo"});
        List<String> expected = new ArrayList<>();
        String[] exp =
                new String[]{"ec", "oc", "ceo"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true, listEquls(actual, expected));

    }

    @Test
    //B是空集则返回A全集
    public void wordSubsetsTest6() {
        List<String> actual = solution.wordSubsets(
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{});
        List<String> expected = new ArrayList<>();
        String[] exp =
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true, listEquls(actual, expected));

    }
    @Test
    //A是空集则返回空集
    public void wordSubsetsTest7() {
        List<String> actual = solution.wordSubsets(
                new String[]{},
                new String[]{"lo", "eo"});
        List<String> expected = new ArrayList<>();
        String[] exp =
                new String[]{};
        for (int i = 0; i < exp.length; i++) {
            expected.add(exp[i]);
        }
        assertEquals(true, listEquls(actual, expected));

    }
}
