package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MinimumMoneyRequiredBeforeTransactionsSolution Tester.
 *
 * @author IronSid
 * @since 09/24/2022
 * @version 1.0
 */
public class MinimumMoneyRequiredBeforeTransactionsSolutionTest {
    MinimumMoneyRequiredBeforeTransactionsSolution.Solution solution = new MinimumMoneyRequiredBeforeTransactionsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minimumMoney(int[][] transactions)
    */
    @Test
    public void testMinimumMoney() throws Exception {
        int[][] transactions = {{7,2},{0,10},{5,0},{4,1},{5,8},{5,9}};
        int expected = 18;
        long actual = solution.minimumMoney(transactions);
        assertEquals(expected, actual);
    }


}
