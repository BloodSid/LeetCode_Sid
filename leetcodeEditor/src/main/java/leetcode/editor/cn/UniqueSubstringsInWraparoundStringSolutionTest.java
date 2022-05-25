package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * UniqueSubstringsInWraparoundStringSolution Tester.
 *
 * @author IronSid
 * @since 05/25/2022
 * @version 1.0
 */
public class UniqueSubstringsInWraparoundStringSolutionTest {
    UniqueSubstringsInWraparoundStringSolution.Solution solution = new UniqueSubstringsInWraparoundStringSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findSubstringInWraproundString(String p)
    */
    @Test
    public void testFindSubstringInWraproundString() throws Exception {
        String p = "zab";
        int expected = 6;
        int actual = solution.findSubstringInWraproundString(p);
        assertEquals(expected, actual);
    }


}
