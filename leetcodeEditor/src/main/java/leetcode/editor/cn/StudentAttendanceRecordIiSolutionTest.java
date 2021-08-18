package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * StudentAttendanceRecordIiSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 08/18/2021
 */
public class StudentAttendanceRecordIiSolutionTest {
    StudentAttendanceRecordIiSolution.Solution solution = new StudentAttendanceRecordIiSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: checkRecord(int n)
     */
    @Test
    public void testCheckRecord1() throws Exception {
        int input = 3;
        int expected = 19;
        int actual = solution.checkRecord(input);
        assertEquals(expected, actual);
    }

    /**
     * Method: checkRecord(int n)
     */
    @Test
    public void testCheckRecord2() throws Exception {
        int input = 4;
        int expected = 43;
        int actual = solution.checkRecord(input);
        assertEquals(expected, actual);
    }

    /**
     * Method: checkRecord(int n)
     */
    @Test
    public void testCheckRecord3() throws Exception {
        int input = 10101;
        int expected = 183236316;
        int actual = solution.checkRecord(input);
        assertEquals(expected, actual);
    }

    /**
     * Method: checkRecord(int n)
     */
    @Test
    public void testCheckRecord4() throws Exception {
        int input = 99995;
        int expected = 969766675;
        int actual = solution.checkRecord(input);
        assertEquals(expected, actual);
    }


}
