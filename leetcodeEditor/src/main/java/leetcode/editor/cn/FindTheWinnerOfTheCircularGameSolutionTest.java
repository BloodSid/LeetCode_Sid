package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * FindTheWinnerOfTheCircularGameSolution Tester.
 *
 * @author IronSid
 * @since 11/17/2021
 * @version 1.0
 */
public class FindTheWinnerOfTheCircularGameSolutionTest {
    FindTheWinnerOfTheCircularGameSolution.Solution solution = new FindTheWinnerOfTheCircularGameSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findTheWinner(int n, int k)
    */
    @Test
    public void testFindTheWinner1() throws Exception {
        int n = 5;
        int k = 2;
        int expected = 3;
        int actual = solution.findTheWinner(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindTheWinner2() throws Exception {
        int n = 6;
        int k = 5;
        int expected = 1;
        int actual = solution.findTheWinner(n, k);
        assertEquals(expected, actual);
    }

}
