package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ContainVirusSolution Tester.
 *
 * @author IronSid
 * @since 07/18/2022
 * @version 1.0
 */
public class ContainVirusSolutionTest {
    ContainVirusSolution.Solution solution = new ContainVirusSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: containVirus(int[][] isInfected)
    */
    @Test
    public void testContainVirus1() throws Exception {
        int[][] isInfected = {{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0}};
        int expected = 10;
        int actual = solution.containVirus(isInfected);
        assertEquals(expected, actual);
    }

    @Test
    public void testContainVirus2() throws Exception {
        int[][] isInfected = {{0,1,0,0,0,0,0,1},{0,1,0,1,0,0,0,1},{0,0,0,0,0,0,0,1}};
        int expected = 16;
        int actual = solution.containVirus(isInfected);
        assertEquals(expected, actual);
    }
}
