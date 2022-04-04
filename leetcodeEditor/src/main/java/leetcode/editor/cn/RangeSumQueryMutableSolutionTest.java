package leetcode.editor.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RangeSumQueryMutableSolution Tester.
 *
 * @author IronSid
 * @since 04/04/2022
 * @version 1.0
 */
public class RangeSumQueryMutableSolutionTest {
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: lowBit(int x)
    */
    @Test
    public void test1() throws Exception {
        int[] nums = {1, 3, 5};
        RangeSumQueryMutableSolution.NumArray numArray = new RangeSumQueryMutableSolution().new NumArray(nums);
        int a1 = numArray.sumRange(0, 2);
        int e1 = 9;
        assertEquals(e1, a1);
        numArray.update(1, 2);
        int a2 = numArray.sumRange(0, 2);
        int e2 = 8;
        assertEquals(e2, a2);
    }


}
