package leetcode.editor.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * MaximumWhiteTilesCoveredByACarpetSolution Tester.
 *
 * @author IronSid
 * @since 05/18/2022
 * @version 1.0
 */
public class MaximumWhiteTilesCoveredByACarpetSolutionTest {
    MaximumWhiteTilesCoveredByACarpetSolution.Solution solution = new MaximumWhiteTilesCoveredByACarpetSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: maximumWhiteTiles(int[][] tiles, int carpetLen)
    */
    @Test
    public void testMaximumWhiteTiles1() {
        int[][] tiles = {{1,5},{10,11},{12,18},{20,25},{30,32}};
        int carpetLen = 10;
        int expected = 9;
        int actual = solution.maximumWhiteTiles(tiles, carpetLen);
        assertEquals(expected, actual);
    }
    @Test
    public void testMaximumWhiteTiles2() {
        int[][] tiles = {{1,1}, {2,2}, {5,5}};
        int carpetLen = 2;
        int expected = 2;
        int actual = solution.maximumWhiteTiles(tiles, carpetLen);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumWhiteTiles3() {
        int[][] tiles = {{1,1}};
        int carpetLen = 1;
        int expected = 1;
        int actual = solution.maximumWhiteTiles(tiles, carpetLen);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumWhiteTiles4() {
        int[][] tiles = {{1,1}, {4,6}};
        int carpetLen = 4;
        int expected = 3;
        int actual = solution.maximumWhiteTiles(tiles, carpetLen);
        assertEquals(expected, actual);
    }



}
