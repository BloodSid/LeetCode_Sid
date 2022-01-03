package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ZumaGameSolution Tester.
 *
 * @author IronSid
 * @since 01/03/2022
 * @version 1.0
 */
public class ZumaGameSolutionTest {
    ZumaGameSolution.Solution solution = new ZumaGameSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findMinStep(String board, String hand)
    */
    @Test
    public void testFindMinStep1() throws Exception {
        String board ="WRRBBW";
        String hand ="RB";
        int expected = -1;
        int actual = solution.findMinStep(board, hand);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinStep2() throws Exception {
        String board ="WWRRBBWW";
        String hand ="WRBRW";
        int expected = 2;
        int actual = solution.findMinStep(board, hand);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinStep3() throws Exception {
        String board ="G";
        String hand ="GGGGG";
        int expected = 2;
        int actual = solution.findMinStep(board, hand);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinStep4() throws Exception {
        String board ="RBYYBBRRB";
        String hand ="YRBGB";
        int expected = 3;
        int actual = solution.findMinStep(board, hand);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinStep5() throws Exception {
        String board ="RRWWRRBBRR";
        String hand ="WB";
        int expected = 2;
        // 第一步 RBRWWRRBBRR
        // 第二步 RBRWWWRRBBRR -> RBRRRBBRR -> RBBBRR -> RRR
        int actual = solution.findMinStep(board, hand);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveConsecutiveBalls1() throws Exception {
        String board = "WRBBBBRRW";
        String expected = "WW";
        String actual = solution.removeConsecutiveBalls(board);
        assertEquals(expected, actual);
    }

}
