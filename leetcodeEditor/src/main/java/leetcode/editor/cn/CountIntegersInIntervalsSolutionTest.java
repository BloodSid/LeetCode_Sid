package leetcode.editor.cn;

import leetcode.editor.cn.CountIntegersInIntervalsSolution.CountIntervals;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * CountIntegersInIntervalsSolution Tester.
 *
 * @author IronSid
 * @since 05/15/2022
 * @version 1.0
 */
public class CountIntegersInIntervalsSolutionTest {

    CountIntegersInIntervalsSolution solution = new CountIntegersInIntervalsSolution();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void CountIntervalsTest1() throws Exception {
        CountIntervals countIntervals = solution.new CountIntervals(); // 用一个区间空集初始化对象
        // 将 [2, 3] 添加到区间集合中
        countIntervals.add(2, 3);
        // 将 [7, 10] 添加到区间集合中
        countIntervals.add(7, 10);
        // 返回 6
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 7、8、9、10 出现在区间 [7, 10] 中
        assertEquals(6, countIntervals.count());
        // 将 [5, 8] 添加到区间集合中
        countIntervals.add(5, 8);
        // 返回 8
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 5 和 6 出现在区间 [5, 8] 中
        // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
        // 整数 9 和 10 出现在区间 [7, 10] 中
        assertEquals(8, countIntervals.count());
    }

    @Test
    public void CountIntervalsTest2() throws Exception {
        CountIntervals countIntervals = solution.new CountIntervals(); // 用一个区间空集初始化对象
        Assert.assertEquals(0, countIntervals.count());
        countIntervals.add(8, 43);
        countIntervals.add(13, 16);
        countIntervals.add(26,33);
        countIntervals.add(28,36);
        countIntervals.add(29,37);
        Assert.assertEquals(36, countIntervals.count());
        countIntervals.add(34,46);
        countIntervals.add(10,23);
    }


}
