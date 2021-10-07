package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

/**
 * RepeatedDnaSequencesSolution Tester.
 *
 * @author IronSid
 * @since 10/08/2021
 * @version 1.0
 */
public class RepeatedDnaSequencesSolutionTest {
    RepeatedDnaSequencesSolution.Solution solution = new RepeatedDnaSequencesSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findRepeatedDnaSequences(String s)
    */
    @Test
    public void testFindRepeatedDnaSequences1() throws Exception {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String[] expected = {"AAAAACCCCC","CCCCCAAAAA"};
        List<String> actual = solution.findRepeatedDnaSequences(s);
        assertEquals(expected.length, actual.size());
        for (String s1 : expected) {
            assertTrue("expected: \"" + s1 + "\"\n", actual.contains(s1));
        }
    }

    @Test
    public void testFindRepeatedDnaSequences2() throws Exception {
        String s = "AAAAAAAAAAAAA";
        String[] expected = {"AAAAAAAAAA"};
        List<String> actual = solution.findRepeatedDnaSequences(s);
        assertEquals(expected.length, actual.size());
        for (String s1 : expected) {
            assertTrue("expected: \"" + s1 + "\"", actual.contains(s1));
        }
    }
}
