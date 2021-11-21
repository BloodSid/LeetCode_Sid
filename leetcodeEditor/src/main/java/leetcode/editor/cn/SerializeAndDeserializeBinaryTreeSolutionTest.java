package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

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
        BinaryTree binaryTree = new BinaryTree();
        String data = "1,2,3,null,null,4,5";
        TreeNode root = binaryTree.stringToBinaryTree(data);
        String str = solution.serialize(root);
        TreeNode result = solution.deserialize(str);
        assertEquals(data, binaryTree.toString(result));
    }

}
