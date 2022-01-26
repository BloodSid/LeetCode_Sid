package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * OneNzhengShuZhong1chuXianDeCiShuLcofSolution Tester.
 *
 * @author IronSid
 * @since 01/26/2022
 * @version 1.0
 */
public class OneNzhengShuZhong1chuXianDeCiShuLcofSolutionTest {
    OneNzhengShuZhong1chuXianDeCiShuLcofSolution.Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcofSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: countDigitOne(int n)
    */
    @Test
    public void testCountDigitOne() throws Exception {
        int n = 123;
        int expected = 57;
        int actual = solution.countDigitOne(123);
        assertEquals(expected, actual);
    }


}
