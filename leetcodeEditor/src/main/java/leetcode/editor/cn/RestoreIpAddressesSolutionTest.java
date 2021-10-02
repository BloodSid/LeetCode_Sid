package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

/**
 * RestoreIpAddressesSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/02/2021
 */
public class RestoreIpAddressesSolutionTest {
    RestoreIpAddressesSolution.Solution solution = new RestoreIpAddressesSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: restoreIpAddresses(String s)
     */
    @Test
    public void testRestoreIpAddresses1() throws Exception {
        String s = "25525511135";
        String[] expected = {"255.255.11.135", "255.255.111.35"};
        List<String> actual = solution.restoreIpAddresses(s);
        assertEquals(expected.length, actual.size());
        for (String s1 : expected) {
            assertTrue(s1, actual.contains(s1));
        }
    }

    /**
     * Method: restoreIpAddresses(String s)
     */
    @Test
    public void testRestoreIpAddresses2() throws Exception {
        String s = "0000";
        String[] expected = {"0.0.0.0"};
        List<String> actual = solution.restoreIpAddresses(s);
        assertEquals(expected.length, actual.size());
        for (String s1 : expected) {
            assertTrue(s1, actual.contains(s1));
        }
    }

    /**
     * Method: restoreIpAddresses(String s)
     */
    @Test
    public void testRestoreIpAddresses3() throws Exception {
        String s = "1111";
        String[] expected = {"1.1.1.1"};
        List<String> actual = solution.restoreIpAddresses(s);
        assertEquals(expected.length, actual.size());
        for (String s1 : expected) {
            assertTrue(s1, actual.contains(s1));
        }
    }

    /**
     * Method: restoreIpAddresses(String s)
     */
    @Test
    public void testRestoreIpAddresses4() throws Exception {
        String s = "010010";
        String[] expected = {"0.10.0.10", "0.100.1.0"};
        List<String> actual = solution.restoreIpAddresses(s);
        assertEquals(expected.length, actual.size());
        for (String s1 : expected) {
            assertTrue(s1, actual.contains(s1));
        }
    }

    /**
     * Method: restoreIpAddresses(String s)
     */
    @Test
    public void testRestoreIpAddresses5() throws Exception {
        String s = "101023";
        String[] expected = {"1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"};
        List<String> actual = solution.restoreIpAddresses(s);
        assertEquals(expected.length, actual.size());
        for (String s1 : expected) {
            assertTrue(s1, actual.contains(s1));
        }
    }


}
