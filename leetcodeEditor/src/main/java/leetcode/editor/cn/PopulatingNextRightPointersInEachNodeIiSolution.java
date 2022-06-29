package leetcode.editor.cn;
//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// 👍 593 👎 0


/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 17:18:43 
 */
public class PopulatingNextRightPointersInEachNodeIiSolution {
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Node pre;
    private Node head;

    public Node connect(Node root) {
        if (root == null) return null;
        // 层序遍历，遍历完一层后，这一层形成一个链表，再利用这个链表填充下一层
        head = root;
        while (head != null) {
            Node cur = head;
            pre = null;
            head = null;
            for (; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    add(cur.left);
                }
                if (cur.right != null) {
                    add(cur.right);
                }
            }
        }
        return root;
    }

    void add(Node node) {
        if (head == null) head = node;
        if (pre != null) pre.next = node;
        pre = node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
