package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * CrackingTheSafeSolution Tester.
 *
 * @author IronSid
 * @since 01/10/2023
 * @version 1.0
 */
public class CrackingTheSafeSolutionTest {
    CrackingTheSafeSolution.Solution solution = new CrackingTheSafeSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: crackSafe(int n, int k)
    */
    @Test
    public void testCrackSafe1() throws Exception {
        int n = 2;
        int k = 2;
        int pow = (int) Math.pow(k, n);
        int expectedLen = pow + n - 1;
        String actual = solution.crackSafe(n, k);
        assertEquals(expectedLen, actual.length());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pow; i++) {
            String substring = actual.substring(i, i + n);
            assertTrue(substring + " is duplicate", set.add(substring));
        }
        assertEquals(pow, set.size());
    }

    @Test
    public void testCrackSafe2() throws Exception {
        int n = 3;
        int k = 3;
        int pow = (int) Math.pow(k, n);
        int expectedLen = pow + n - 1;
        String actual = solution.crackSafe(n, k);
        assertEquals(expectedLen, actual.length());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pow; i++) {
            String substring = actual.substring(i, i + n);
            assertTrue(substring + " is duplicate", set.add(substring));
        }
        assertEquals(pow, set.size());
    }

    @Test
    public void testCrackSafe3() throws Exception {
        // -Xss2m 以上才能运行
        int n = 4;
        int k = 10;
        int pow = (int) Math.pow(k, n);
        int expectedLen = pow + n - 1;
        String actual = solution.crackSafe(n, k);
        assertEquals(expectedLen, actual.length());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pow; i++) {
            String substring = actual.substring(i, i + n);
            assertTrue(substring + " is duplicate", set.add(substring));
        }
        assertEquals(pow, set.size());
    }

}
