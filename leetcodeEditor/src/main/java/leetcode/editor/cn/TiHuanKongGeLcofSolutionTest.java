package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * TiHuanKongGeLcofSolution Tester.
 *
 * @author IronSid
 * @since 12/29/2021
 * @version 1.0
 */
public class TiHuanKongGeLcofSolutionTest {
    TiHuanKongGeLcofSolution.Solution solution = new TiHuanKongGeLcofSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: replaceSpace(String s)
    */
    @Test
    public void testReplaceSpace() throws Exception {
        String s = "We are happy.";
        String expected = "We%20are%20happy.";
        String actual = solution.replaceSpace(s);
        assertEquals(expected, actual);
    }


}
