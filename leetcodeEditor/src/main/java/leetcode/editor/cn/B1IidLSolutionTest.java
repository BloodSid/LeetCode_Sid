package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * B1IidLSolution Tester.
 *
 * @author IronSid
 * @since 10/14/2021
 * @version 1.0
 */
public class B1IidLSolutionTest {
    B1IidLSolution.Solution solution = new B1IidLSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: peakIndexInMountainArray(int[] arr)
    */
    @Test
    public void testPeakIndexInMountainArray1() throws Exception {
        int[] arr = {0, 1, 0};
        int expected = 1;
        int actual = solution.peakIndexInMountainArray(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testPeakIndexInMountainArray2() throws Exception {
        int[] arr = {1,3,5,4,2};
        int expected = 2;
        int actual = solution.peakIndexInMountainArray(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testPeakIndexInMountainArray3() throws Exception {
        int[] arr = {0,10,5,2};
        int expected = 1;
        int actual = solution.peakIndexInMountainArray(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testPeakIndexInMountainArray4() throws Exception {
        int[] arr = {3,4,5,1};
        int expected = 2;
        int actual = solution.peakIndexInMountainArray(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testPeakIndexInMountainArray5() throws Exception {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        int expected = 2;
        int actual = solution.peakIndexInMountainArray(arr);
        assertEquals(expected, actual);
    }

}
