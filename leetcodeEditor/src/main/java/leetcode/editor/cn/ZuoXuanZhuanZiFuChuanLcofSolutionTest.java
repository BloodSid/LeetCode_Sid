package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * ZuoXuanZhuanZiFuChuanLcofSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 12/29/2021
 */
public class ZuoXuanZhuanZiFuChuanLcofSolutionTest {
    ZuoXuanZhuanZiFuChuanLcofSolution.Solution solution = new ZuoXuanZhuanZiFuChuanLcofSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: reverseLeftWords(String s, int n)
     */
    @Test
    public void testReverseLeftWords() throws Exception {
        String s = "lrloseumgh";
        int n = 6;
        String expected = "umghlrlose";
        String actual = solution.reverseLeftWords(s, n);
        assertEquals(expected, actual);
    }


}
