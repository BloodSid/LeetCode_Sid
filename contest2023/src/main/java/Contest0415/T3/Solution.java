package Contest0415.T3;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-04-15 22:30
 */
public class Solution {

    private List<Integer> sum;

    public TreeNode replaceValueInTree(TreeNode root) {
        sum = new ArrayList<>();
        dfs0(root, null, 0);
        dfs1(root, null, 0);
        root.val = 0;
        return root;
    }

    void dfs0(TreeNode node, TreeNode parent, int depth) {
        if (node == null) return;
        if (sum.size() == depth) sum.add(0);
        sum.set(depth, sum.get(depth) + node.val);
        // 缓存
        sonSum(node);
        dfs0(node.left, node, depth + 1);
        dfs0(node.right, node, depth + 1);
    }

    void dfs1(TreeNode node, TreeNode parent, int depth) {
        if (node == null) return;
        node.val = sum.get(depth) - sonSum(parent);
        dfs1(node.left, node, depth + 1);
        dfs1(node.right, node, depth + 1);
    }


    HashMap<TreeNode, Integer> ss = new HashMap<>();
    int sonSum(TreeNode node) {
        if (ss.containsKey(node)) return ss.get(node);
        if (node == null) return 0;
        int sum = 0;
        if (node.left!= null) sum += node.left.val;
        if (node.right!= null) sum += node.right.val;
        ss.put(node, sum);
        return sum;
    }
}


class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode result = solution.replaceValueInTree(BinaryTree.stringToBinaryTree("5,4,9,1,10,null,7"));
        String rs = BinaryTree.toString(result);
        Assert.assertEquals("0,0,0,7,7,null,11", rs);
    }
}