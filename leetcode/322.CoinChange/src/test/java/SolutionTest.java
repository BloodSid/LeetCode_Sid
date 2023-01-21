import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-07-08 22:06
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void coinChangeTest1() {
        int[] coins = {1,2,5};
        int amount = 11;
        //5+5+1
        int expeted = 3;
        assertEquals(expeted,solution.coinChange(coins,amount));
    }
    @Test
    public void coinChangeTest2() {
        int[] coins = {2};
        int amount = 3;
        int expeted = -1;
        assertEquals(expeted,solution.coinChange(coins,amount));
    }
    @Test
    public void coinChangeTest3() {
        int[] coins = {1};
        int amount = 0;
        int expeted = 0;
        assertEquals(expeted,solution.coinChange(coins,amount));
    }
    @Test
    public void coinChangeTest4() {
        int[] coins = {1};
        int amount = 1;
        int expeted = 1;
        assertEquals(expeted,solution.coinChange(coins,amount));
    }
    @Test
    public void coinChangeTest5() {
        int[] coins = {1};
        int amount = 2;
        int expeted = 2;
        assertEquals(expeted,solution.coinChange(coins,amount));
    }
}