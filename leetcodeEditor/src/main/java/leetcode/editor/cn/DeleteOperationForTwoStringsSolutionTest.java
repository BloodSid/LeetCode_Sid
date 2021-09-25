package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * DeleteOperationForTwoStringsSolution Tester.
 *
 * @author IronSid
 * @since 09/25/2021
 * @version 1.0
 */
public class DeleteOperationForTwoStringsSolutionTest {
    DeleteOperationForTwoStringsSolution.Solution solution = new DeleteOperationForTwoStringsSolution().new Solution();
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
    public void testMinDistance() throws Exception {
        String word1 = "sea";
        String word2 = "eat";
        int expected = 2;
        int actual = solution.minDistance(word1, word2);
        assertEquals(expected, actual);
    }


}
