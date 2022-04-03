package leetcode.editor.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * SumOfScoresOfBuiltStringsSolution Tester.
 *
 * @author IronSid
 * @since 04/03/2022
 * @version 1.0
 */
public class SumOfScoresOfBuiltStringsSolutionTest {
    SumOfScoresOfBuiltStringsSolution.Solution solution = new SumOfScoresOfBuiltStringsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: sumScores(String s)
    */
    @Test
    public void testSumScores1() throws Exception {
        String s = "babab";
        long expected = 9;
        long actual = solution.sumScores(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumScores2() throws Exception {
        String s = "azbazbzaz";
        long expected = 14;
        long actual = solution.sumScores(s);
        assertEquals(expected, actual);
    }


}
