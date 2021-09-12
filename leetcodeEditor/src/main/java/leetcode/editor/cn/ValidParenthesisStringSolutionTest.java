package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ValidParenthesisStringSolution Tester.
 *
 * @author IronSid
 * @since 09/12/2021
 * @version 1.0
 */
public class ValidParenthesisStringSolutionTest {
    ValidParenthesisStringSolution.Solution solution = new ValidParenthesisStringSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: checkValidString(String s)
    */
    @Test
    public void testCheckValidString1() throws Exception {
        String s = "()";
        boolean expected = true;
        boolean actual = solution.checkValidString(s);
        assertEquals(expected, actual);
    }

    /**
    * Method: checkValidString(String s)
    */
    @Test
    public void testCheckValidString2() throws Exception {
        String s = "(*)";
        boolean expected = true;
        boolean actual = solution.checkValidString(s);
        assertEquals(expected, actual);
    }

    /**
    * Method: checkValidString(String s)
    */
    @Test
    public void testCheckValidString3() throws Exception {
        String s = "(*))";
        boolean expected = true;
        boolean actual = solution.checkValidString(s);
        assertEquals(expected, actual);
    }

    /**
    * Method: checkValidString(String s)
    */
    @Test
    public void testCheckValidString4() throws Exception {
        String s = "";
        boolean expected = true;
        boolean actual = solution.checkValidString(s);
        assertEquals(expected, actual);
    }

    /**
    * Method: checkValidString(String s)
    */
    @Test
    public void testCheckValidString5() throws Exception {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        boolean expected = true;
        boolean actual = solution.checkValidString(s);
        assertEquals(expected, actual);
    }


}
