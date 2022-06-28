package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * SubstringWithConcatenationOfAllWordsSolution Tester.
 *
 * @author IronSid
 * @since 06/28/2022
 * @version 1.0
 */
public class SubstringWithConcatenationOfAllWordsSolutionTest {
    SubstringWithConcatenationOfAllWordsSolution.Solution solution = new SubstringWithConcatenationOfAllWordsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findSubstring(String s, String[] words)
    */
    @Test
    public void testFindSubstring() throws Exception {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        List<Integer> expected = Arrays.asList(6, 9, 12);
        List<Integer> actual = solution.findSubstring(s, words);
        assertEquals(expected, actual);
    }


}
