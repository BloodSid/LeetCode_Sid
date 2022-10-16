package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * FruitIntoBasketsSolution Tester.
 *
 * @author IronSid
 * @since 10/17/2022
 * @version 1.0
 */
public class FruitIntoBasketsSolutionTest {
    FruitIntoBasketsSolution.Solution solution = new FruitIntoBasketsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: totalFruit(int[] fruits)
    */
    @Test
    public void testTotalFruit1() throws Exception {
        int[] fruits = {1,2,1};
        int expected = 3;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }

    @Test
    public void testTotalFruit2() throws Exception {
        int[] fruits = {0,1,2,2};
        int expected = 3;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }

    @Test
    public void testTotalFruit3() throws Exception {
        int[] fruits = {1,2,3,2,2};
        int expected = 4;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }

}
