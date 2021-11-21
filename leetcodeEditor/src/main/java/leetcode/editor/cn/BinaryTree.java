package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public static TreeNode stringToBinaryTree(String levelTraversal) {
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


    public static String toString(TreeNode root) {
        if (root == null) {
            return "null";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();
        queue.offer(root);
        list.add(Integer.toString(root.val));
        int queueSize = 0;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    list.add(Integer.toString(curr.left.val));
                } else {
                    list.add("null");
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    list.add(Integer.toString(curr.right.val));
                } else {
                    list.add("null");
                }
            }
        }
        // 当逐层遍历到最深一层，这一层的节点即便没有子节点，也不用添加 "null"
        // 所以最后删去最后一层节点数量两倍的 "null"
        int len = list.size();
        list.subList(len - 2 * queueSize, len).clear();
        return String.join(",", list);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"1,null,0,0,1", "1,1,0,1,1,null,1", "1,null,1,null,1"};
        for (String s :
                strings) {
            TreeNode root = stringToBinaryTree(s);
            String s1 = toString(root);
            System.out.println(s1);
        }
    }
}

