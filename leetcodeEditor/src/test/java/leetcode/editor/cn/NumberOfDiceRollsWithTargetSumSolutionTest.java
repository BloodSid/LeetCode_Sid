package leetcode.editor.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @since 2023-10-24 17:34
 */
public class NumberOfDiceRollsWithTargetSumSolutionTest {
    NumberOfDiceRollsWithTargetSumSolution.Solution solution = new NumberOfDiceRollsWithTargetSumSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: numRollsToTarget(int n, int k, int target)
     */
    @Test
    public void testnumRollsToTarget1() throws Exception {
        int n = 30;
        int k = 30;
        int target = 500;
        int expected = 222616187;
        int actual = solution.numRollsToTarget(n, k, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testnumRollsToTarget2() throws Exception {
        int n = 2;
        int k = 6;
        int target = 7;
        int expected = 6;
        int actual = solution.numRollsToTarget(n, k, target);
        assertEquals(expected, actual);
    }
}