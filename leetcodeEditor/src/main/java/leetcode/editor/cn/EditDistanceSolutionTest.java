package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * EditDistanceSolution Tester.
 *
 * @author IronSid
 * @since 10/02/2021
 * @version 1.0
 */
public class EditDistanceSolutionTest {
    EditDistanceSolution.Solution solution = new EditDistanceSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minDistance(String word1, String word2)
    */
    @Test
    public void testMinDistance1() throws Exception {
        String word1 = "horse";
        String word2 = "ros";
        int expected = 3;
        int actual = solution.minDistance(word1, word2);
        assertEquals(expected, actual);
    }

    /**
    * Method: minDistance(String word1, String word2)
    */
    @Test
    public void testMinDistance2() throws Exception {
        String word1 = "intention";
        String word2 = "execution";
        int expected = 5;
        int actual = solution.minDistance(word1, word2);
        assertEquals(expected, actual);
    }




}
