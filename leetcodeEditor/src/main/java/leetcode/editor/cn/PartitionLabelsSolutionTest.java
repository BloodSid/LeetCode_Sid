package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * PartitionLabelsSolution Tester.
 *
 * @author IronSid
 * @since 11/10/2021
 * @version 1.0
 */
public class PartitionLabelsSolutionTest {
    PartitionLabelsSolution.Solution solution = new PartitionLabelsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: partitionLabels(String s)
    */
    @Test
    public void testPartitionLabels1() throws Exception {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> expected = Arrays.asList(9, 7, 8);
        List<Integer> actual = solution.partitionLabels(s);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.toString(), expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testPartitionLabels2() throws Exception {
        String s = "eccbbbbdec";
        List<Integer> expected = Arrays.asList(10);
        List<Integer> actual = solution.partitionLabels(s);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.toString(), expected.get(i), actual.get(i));
        }
    }

}
