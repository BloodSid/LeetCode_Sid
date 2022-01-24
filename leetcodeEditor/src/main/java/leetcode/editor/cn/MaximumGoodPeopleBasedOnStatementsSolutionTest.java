package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * MaximumGoodPeopleBasedOnStatementsSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 01/24/2022
 */
public class MaximumGoodPeopleBasedOnStatementsSolutionTest {
    MaximumGoodPeopleBasedOnStatementsSolution.Solution solution = new MaximumGoodPeopleBasedOnStatementsSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: maximumGood(int[][] statements)
     */
    @Test
    public void testMaximumGood() throws Exception {
        int[][] statements = {{2, 1, 0, 0, 2}, {2, 2, 1, 0, 2}, {0, 2, 2, 1, 0}, {2, 0, 0, 2, 0}, {2, 0, 0, 1, 2}};
        int expected = 1;
        int actual = solution.maximumGood(statements);
        assertEquals(expected, actual);
    }

}
