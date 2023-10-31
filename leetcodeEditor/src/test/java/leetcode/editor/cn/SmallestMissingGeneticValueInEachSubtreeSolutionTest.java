package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author IronSid
 * @since 2023-10-31 10:55
 */
public class SmallestMissingGeneticValueInEachSubtreeSolutionTest {
    SmallestMissingGeneticValueInEachSubtreeSolution.Solution solution = new SmallestMissingGeneticValueInEachSubtreeSolution.Solution();

    /**
     * Method: SmallestMissingValueSubtree(int[] parents, int[] nums)
     */
    @Test
    public void testSmallestMissingValueSubtree1() throws Exception {
        File file = new File("src/test/java/leetcode/editor/cn/SmallestMissingGeneticValueInEachSubtreeSolutionExample1");
        System.out.println(file.getAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String ps = br.readLine(), ns = br.readLine(), es = br.readLine();
        int[] parents = JSON.parseArray(ps, int.class).stream().mapToInt(o -> o).toArray();
        int[] nums = JSON.parseArray(ns, int.class).stream().mapToInt(o -> o).toArray();
        int[] expected = JSON.parseArray(es, int.class).stream().mapToInt(o -> o).toArray();
        int[] actual = solution.smallestMissingValueSubtree(parents, nums);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}