package leetcode.editor.cn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * MaximumTotalBeautyOfTheGardensSolution Tester.
 *
 * @author IronSid
 * @since 04/10/2022
 * @version 1.0
 */
public class MaximumTotalBeautyOfTheGardensSolutionTest {
    MaximumTotalBeautyOfTheGardensSolution.Solution solution = new MaximumTotalBeautyOfTheGardensSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaximumBeauty1() {
        int[] flowers = {1,3,1,1};
        long newFlowers = 7;
        int target = 6;
        int full = 12;
        int partial = 1;
        long expected = 14;
        long actual = solution.maximumBeauty(flowers, newFlowers, target, full, partial);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMaximumBeauty2() {
        int[] flowers = {2,4,5,3};
        long newFlowers = 10;
        int target = 5;
        int full = 2;
        int partial = 6;
        long expected = 30;
        long actual = solution.maximumBeauty(flowers, newFlowers, target, full, partial);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMaximumBeauty3() {
        int[] flowers = {5,5,15,1,9};
        long newFlowers = 36;
        int target = 12;
        int full = 9;
        int partial = 2;
        long expected = 58;
        long actual = solution.maximumBeauty(flowers, newFlowers, target, full, partial);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMaximumBeauty4() {
        int[] flowers = new int[100000];
        Arrays.fill(flowers, 100000);
        long newFlowers = 10000000000L;
        int target = 100000;
        int full = 100000;
        int partial = 100000;
        long expected = 10000000000L;
        long actual = solution.maximumBeauty(flowers, newFlowers, target, full, partial);
        Assert.assertEquals(expected, actual);
    }


}
