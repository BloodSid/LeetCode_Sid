package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author IronSid
 * @create 2021-04-26 22:51
 */
public class BinaryTree {

    //Definition for a binary tree node.

    /**
     * This method generates a new binary tree with a string from leetcode.
     *
     * @param levelTraversal level-order Traversal of the binary tree. Example: "1,null,0,0,1"
     * @return the root node of the binary tree
     */
    public TreeNode stringToBinaryTree(String levelTraversal) {
        if (levelTraversal == null) return null;

        String[] strings = levelTraversal.split(",");
        if (strings[0].equals("null")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.offer(root);

        for (int i = 1; i < strings.length; i++) {
            if (i % 2 == 1) {
                if (!strings[i].equals("null")) {
                    TreeNode treeNode = queue.peek();
                    treeNode.left = new TreeNode(Integer.parseInt(strings[i]));
                    queue.offer(treeNode.left);
                }
            } else {
                if (!strings[i].equals("null")) {
                    TreeNode treeNode = queue.peek();
                    treeNode.right = new TreeNode(Integer.parseInt(strings[i]));
                    queue.offer(treeNode.right);
                }
                queue.poll();
            }
        }
        return root;
    }



    public String toString(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val == 0) {
            return "0";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        queue.offer(root);
        s.append(root.val);
        while(queue.size()!=0){
            TreeNode thisNode = queue.peek();
            if (thisNode.left == null && thisNode.right == null) {
                queue.poll();
                continue;
            }
            if (thisNode.left != null) {
                queue.offer(thisNode.left);
                s.append(',');
                s.append(thisNode.left.val);
            }else {
                s.append(",null");
            }
            if (thisNode.right != null) {
                queue.offer(thisNode.right);
                s.append(',');
                s.append(thisNode.right.val);
            }else {
                s.append(",null");
            }
            queue.poll();
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"1,null,0,0,1","1,1,0,1,1,null,1","1,null,1,null,1"};
        for (String s:
             strings) {
            BinaryTree binaryTree = new BinaryTree();
            TreeNode root = binaryTree.stringToBinaryTree(s);
            String s1 = binaryTree.toString(root);
            System.out.println(s1);
        }
    }
}

