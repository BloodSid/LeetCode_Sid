package leetcode.editor.cn;
//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 👍 856 👎 0


import binaryTree.TreeNode;
import linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有序链表转换二叉搜索树
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-09-16 22:00:02 
 */
public class ConvertSortedListToBinarySearchTreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            list.add(cur.val);
        }
        return build(list, 0, list.size() - 1);
    }

    // 递归建树
    private TreeNode build(List<Integer> list, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(list.get(start));
        int mid = start + end >> 1;
        return new TreeNode(list.get(mid), build(list, start, mid - 1), build(list, mid + 1, end));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
