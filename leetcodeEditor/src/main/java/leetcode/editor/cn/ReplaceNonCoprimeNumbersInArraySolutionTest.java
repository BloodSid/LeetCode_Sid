package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ReplaceNonCoprimeNumbersInArraySolution Tester.
 *
 * @author IronSid
 * @since 03/06/2022
 * @version 1.0
 */
public class ReplaceNonCoprimeNumbersInArraySolutionTest {
    ReplaceNonCoprimeNumbersInArraySolution.Solution solution = new ReplaceNonCoprimeNumbersInArraySolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: replaceNonCoprimes(int[] nums)
    */
    @Test
    public void testReplaceNonCoprimes() throws Exception {
        int[] nums = {31,97561,97561,97561,97561,97561,97561,97561,97561};
        Integer[] expected = {31,97561};
        Integer[] actual = solution.replaceNonCoprimes(nums).toArray(new Integer[0]);
        assertArrayEquals(expected, actual);
    }


}
