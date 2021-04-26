import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-04-26 23:40
 */
public class SolutionTest {
public static Solution solution = new Solution();

    @Test
    public void pruneTreeTest1() {
        String input="1,null,0,null,null,0,1";
        String output="1,null,0,null,null,null,1";
        String actualOutput = new BinaryTree().toString(solution.pruneTree(new BinaryTree().stringToBinaryTree("input")));
        assertTrue(output.equals(actualOutput));
    }
    @Test
    public void pruneTreeTest2() {
        String input="1,0,1,0,0,0,1";
        String output="1,null,1,null,null,null,1";
        String actualOutput = new BinaryTree().toString(solution.pruneTree(new BinaryTree().stringToBinaryTree("input")));
        assertTrue(output.equals(actualOutput));
    }
    @Test
    public void pruneTreeTest3() {
        String input="1,1,0,1,1,0,1,0";
        String output="1,1,0,1,1,null,1";
        String actualOutput = new BinaryTree().toString(solution.pruneTree(new BinaryTree().stringToBinaryTree("input")));
        assertTrue(output.equals(actualOutput));
    }


}