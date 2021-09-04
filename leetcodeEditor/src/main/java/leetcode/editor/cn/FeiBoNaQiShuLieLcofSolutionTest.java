package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * FeiBoNaQiShuLieLcofSolution Tester.
 *
 * @author IronSid
 * @since 09/04/2021
 * @version 1.0
 */
public class FeiBoNaQiShuLieLcofSolutionTest {
    FeiBoNaQiShuLieLcofSolution.Solution solution = new FeiBoNaQiShuLieLcofSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: fib(int n)
    */
    @Test
    public void testFib() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(solution.fib(i));
        }
    }


}
