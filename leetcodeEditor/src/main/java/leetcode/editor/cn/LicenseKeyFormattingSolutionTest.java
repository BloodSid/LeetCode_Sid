package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * LicenseKeyFormattingSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/04/2021
 */
public class LicenseKeyFormattingSolutionTest {
    LicenseKeyFormattingSolution.Solution solution = new LicenseKeyFormattingSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: licenseKeyFormatting(String s, int k)
     */
    @Test
    public void testLicenseKeyFormatting1() throws Exception {
        String s = "5F3Z-2e-9-w";
        int k = 4;
        String expected = "5F3Z-2E9W";
        String actual = solution.licenseKeyFormatting(s, k);
        assertEquals(expected, actual);
    }

    @Test
    public void testLicenseKeyFormatting2() throws Exception {
        String s = "2-5g-3-J";
        int k = 2;
        String expected = "2-5G-3J";
        String actual = solution.licenseKeyFormatting(s, k);
        assertEquals(expected, actual);
    }

}
