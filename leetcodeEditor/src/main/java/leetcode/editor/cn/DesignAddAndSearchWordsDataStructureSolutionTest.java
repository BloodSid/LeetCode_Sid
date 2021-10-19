package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * DesignAddAndSearchWordsDataStructureSolution Tester.
 *
 * @author IronSid
 * @since 10/19/2021
 * @version 1.0
 */
public class DesignAddAndSearchWordsDataStructureSolutionTest {
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test1() throws Exception {
        DesignAddAndSearchWordsDataStructureSolution.WordDictionary wordDictionary
        = new DesignAddAndSearchWordsDataStructureSolution().new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertFalse(wordDictionary.search("pad"));
        assertTrue(wordDictionary.search("bad"));
        assertTrue(wordDictionary.search(".ad"));
        assertTrue(wordDictionary.search("b.."));
    }




}
