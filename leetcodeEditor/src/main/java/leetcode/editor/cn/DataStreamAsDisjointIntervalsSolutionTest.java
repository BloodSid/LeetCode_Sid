package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * DataStreamAsDisjointIntervalsSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/10/2021
 */
public class DataStreamAsDisjointIntervalsSolutionTest {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test1() throws Exception {
        DataStreamAsDisjointIntervalsSolution.SummaryRanges summaryRanges
            = new DataStreamAsDisjointIntervalsSolution().new SummaryRanges();
        summaryRanges.addNum(1);
        int[][] actual = summaryRanges.getIntervals();
        int[][] expected = {{1, 1}};
        // assertArrayEquals 对二维数组也可用
        assertArrayEquals(expected, actual);
        summaryRanges.addNum(3);
        // 返回 [[1, 1], [3, 3]]
        actual = summaryRanges.getIntervals();
        expected = new int[][]{{1, 1}, {3, 3}};
        assertArrayEquals(expected, actual);
        summaryRanges.addNum(7);
        // 返回 [[1, 1], [3, 3], [7, 7]]
        actual = summaryRanges.getIntervals();
        expected = new int[][]{{1, 1}, {3, 3}, {7, 7}};
        assertArrayEquals(expected, actual);
        summaryRanges.addNum(2);
        // 返回 [[1, 3], [7, 7]]
        actual = summaryRanges.getIntervals();
        expected = new int[][]{{1, 3}, {7, 7}};
        assertArrayEquals(expected, actual);
        summaryRanges.addNum(6);
        // 返回 [[1, 3], [6, 7]]
        actual = summaryRanges.getIntervals();
        expected = new int[][]{{1, 3}, {6, 7}};
        assertArrayEquals(expected, actual);
    }

}
