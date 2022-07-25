package leetcode.editor.cn;
//完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。 
//
// 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。 
//
// 实现 CBTInserter 类: 
//
// 
// CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构； 
// CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态
//，并返回插入节点 TreeNode 的父节点的值； 
// CBTInserter.get_root() 将返回树的头节点。 
// 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入
//["CBTInserter", "insert", "insert", "get_root"]
//[[[1, 2]], [3], [4], []]
//输出
//[null, 1, 2, [1, 2, 3, 4]]
//
//解释
//CBTInserter cBTInserter = new CBTInserter([1, 2]);
//cBTInserter.insert(3);  // 返回 1
//cBTInserter.insert(4);  // 返回 2
//cBTInserter.get_root(); // 返回 [1, 2, 3, 4] 
//
// 
//
// 提示： 
//
// 
// 树中节点数量范围为 [1, 1000] 
// 0 <= Node.val <= 5000 
// root 是完全二叉树 
// 0 <= val <= 5000 
// 每个测试用例最多调用 insert 和 get_root 操作 10⁴ 次 
// 
// 👍 111 👎 0


import binaryTree.TreeNode;

import java.util.LinkedList;

/**
 * 完全二叉树插入器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-25 11:51:16 
 */
public class CompleteBinaryTreeInserterSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class CBTInserter {

    private final LinkedList<TreeNode> q;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
        q.offer(root);
        for (TreeNode peek = q.peek(); peek.left != null && peek.right != null; peek = q.peek()) {
            q.offer(peek.left);
            q.offer(peek.right);
            q.poll();
        }
    }
    
    public int insert(int val) {
        TreeNode peek = q.peek();
        int parentVal = peek.val;
        if (peek.left == null) {
            peek.left = new TreeNode(val);
        } else {
            // 右子节点为空
            peek.right = new TreeNode(val);
            q.offer(peek.left);
            q.offer(peek.right);
            q.poll();
        }
        return parentVal;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
