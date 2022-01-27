package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * NumberOfValidWordsInASentenceSolution Tester.
 *
 * @author IronSid
 * @since 01/27/2022
 * @version 1.0
 */
public class NumberOfValidWordsInASentenceSolutionTest {
    NumberOfValidWordsInASentenceSolution.Solution solution = new NumberOfValidWordsInASentenceSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: countValidWords(String sentence)
    */
    @Test
    public void testCountValidWords() throws Exception {
        String sentence = " o6 t ";
        int expected = 1;
        int actual = solution.countValidWords(sentence);
        assertEquals(expected, actual);
    }


}
