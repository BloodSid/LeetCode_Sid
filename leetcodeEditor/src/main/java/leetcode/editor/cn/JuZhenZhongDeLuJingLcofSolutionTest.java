package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * JuZhenZhongDeLuJingLcofSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 01/09/2022
 */
public class JuZhenZhongDeLuJingLcofSolutionTest {
    JuZhenZhongDeLuJingLcofSolution.Solution solution = new JuZhenZhongDeLuJingLcofSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: exist(char[][] board, String word)
     */
    @Test
    public void testExist1() throws Exception {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean expected = true;
        boolean actual = solution.exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void testExist2() throws Exception {
        char[][] board = {{'A', 'B'}, {'C', 'D'}};
        String word = "ABCD";
        boolean expected = false;
        boolean actual = solution.exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void testExist3() throws Exception {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        boolean expected = true;
        boolean actual = solution.exist(board, word);
        assertEquals(expected, actual);
    }

}
