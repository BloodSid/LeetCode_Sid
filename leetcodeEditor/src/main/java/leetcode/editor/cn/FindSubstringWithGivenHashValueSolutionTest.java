package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * FindSubstringWithGivenHashValueSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 01/30/2022
 */
public class FindSubstringWithGivenHashValueSolutionTest {
    FindSubstringWithGivenHashValueSolution.Solution solution = new FindSubstringWithGivenHashValueSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: subStrHash(String s, int power, int modulo, int k, int hashValue)
     */
    @Test
    public void testSubStrHash() throws Exception {
        String s = "fbxzaad";
        int power = 31, modulo = 100, k = 3, hashValue = 32;
        String expected = "fbx";
        String actual = solution.subStrHash(s, power, modulo, k, hashValue);
        assertEquals(expected, actual);
    }


}
