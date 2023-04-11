package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @since 2023-04-11 14:11
 */
public class WaysToSplitArrayIntoThreeSubarraysSolutionTest {
    WaysToSplitArrayIntoThreeSubarraysSolution.Solution solution = new WaysToSplitArrayIntoThreeSubarraysSolution.Solution();
    WaysToSplitArrayIntoThreeSubarraysSolution.Solution2 solution2 = new WaysToSplitArrayIntoThreeSubarraysSolution.Solution2();
    Random random = new Random();

    @Test
    public void testWaysToSplit1() throws Exception {
        String ns = "[4,3,10]";
        int[] nums = JSON.parseArray(ns, int.class).stream().mapToInt(o -> o).toArray();
        int expected = 0;
        int actual = solution.waysToSplit(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testWaysToSplit2() throws Exception {
        String ns = "[0,0,0,0]";
        int[] nums = JSON.parseArray(ns, int.class).stream().mapToInt(o -> o).toArray();
        int expected = 3;
        int actual = solution.waysToSplit(nums);
        assertEquals(expected, actual);
    }

    // 对拍测试
    @Test
    public void testWaysToSplit3() throws Exception {
        int N = 8;
        int T = (int) 1e8;
        int d = (int) (N * 0.333333);
        int[] nums = new int[N];
        // 生成数的范围 0 - N，但是 0 的概率稍大
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                nums[i] = Math.max(0, random.nextInt(N + d) - d);
            }
            int expected = solution2.waysToSplit(nums);
            int actual = solution.waysToSplit(nums);
            assertEquals(Arrays.toString(nums), expected, actual);
        }
    }

    @Test
    public void testWaysToSplit4() throws Exception {
        String ns = "[5, 7, 2, 0, 0, 0, 0, 2]";
        int[] nums = JSON.parseArray(ns, int.class).stream().mapToInt(o -> o).toArray();
        int expected = 0;
        int actual = solution.waysToSplit(nums);
        assertEquals(expected, actual);
    }


}