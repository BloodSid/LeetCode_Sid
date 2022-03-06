package leetcode.editor.cn;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * SerializeAndDeserializeBinaryTreeSolution Tester.
 *
 * @author IronSid
 * @since 11/21/2021
 * @version 1.0
 */
public class SerializeAndDeserializeBinaryTreeSolutionTest {
    SerializeAndDeserializeBinaryTreeSolution.Codec solution = new SerializeAndDeserializeBinaryTreeSolution().new Codec();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: serialize(TreeNode root)
    */
    @Test
    public void test1() throws Exception {
        String data = "1,2,3,null,null,4,5";
        TreeNode root = BinaryTree.stringToBinaryTree(data);
        String str = solution.serialize(root);
        TreeNode result = solution.deserialize(str);
        assertEquals(data, BinaryTree.toString(result));
    }

}
