package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.HashMap;

/**
 * 二叉搜索树染色
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-17 10:10:22
 */
public class QO5KpGSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, Integer> idx;

    public int getNumber(TreeNode root, int[][] ops) {
        idx = new HashMap<>();
        dfs(root);
        class Node {
            int low, high;
            Node next;

            Node() {
            }

            Node(int low, int high, Node next) {
                this.low = low;
                this.high = high;
                this.next = next;
            }

            @Override
            public String toString() {
                return "{" + low + ", " + high + "}, " + next;
            }
        }
        Node preHead = new Node(-1, -1, null);
        for (int[] op : ops) {
            int low = idx.get(op[1]), high = idx.get(op[2]);
            if (op[0] == 1) {
                // 染红
                Node cur = preHead;
                while (cur.next != null && cur.next.high < low) {
                    cur = cur.next;
                }
                if (cur.next == null) {
                    cur.next = new Node(low, high, null);
                    continue;
                }
                while (cur.next != null) {
                    if (cur.next.high <= high && cur.next.low >= low) {
                        cur.next.next = cur.next;
                    } else if (cur.next.low >= low) {
                        cur.next.low = low;
                        cur = cur.next;
                    } else if (cur.next.high <= high) {
                        cur.next.high = high;
                        cur = cur.next;
                    } else {
                        break;
                    }
                }
            } else {
                // 染蓝
                Node cur = preHead;
                while (cur.next != null && cur.next.high < low) {
                    cur = cur.next;
                }
                while (cur.next != null) {
                    if (cur.next.high <= high && cur.next.low >= low) {
                        cur.next.next = cur.next;
                    } else if (cur.next.low >= low) {
                        cur.next.low = high + 1;
                        cur = cur.next;
                    } else if (cur.next.high <= high) {
                        cur.next.high = low - 1;
                        cur = cur.next;
                    } else {
                        break;
                    }
                }
            }
        }
        int cnt = 0;
        for (Node cur = preHead.next; cur != null; cur = cur.next) {
            cnt += cur.high - cur.low + 1;
        }
        return cnt;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        idx.put(node.val, idx.size());
        dfs(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
