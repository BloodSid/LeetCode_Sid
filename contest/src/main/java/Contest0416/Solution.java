package Contest0416;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-04-16 12:09
 */
public class Solution {
    // T1
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int x = operation[0], y = operation[1];
            int sent = gem[x] / 2;
            gem[x] -= sent;
            gem[y] += sent;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : gem) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return max - min;
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int n = cookbooks.length;
        int max = -1;
        loop:
        for (int s = 0; s < 1 << n; s++) {
            int full = 0;
            int delicious = 0;
            for (int i = 0; i < n; i++) {
                if ((s >> i & 1) == 1) {
                    delicious += attribute[i][0];
                    full += attribute[i][1];
                }
            }
            if (full < limit) {
                continue;
            }
            if (delicious <= max) {
                continue;
            }
            int[] cost = new int[5];
            for (int i = 0; i < n; i++) {
                if ((s >> i & 1) == 1) {
                    for (int j = 0; j < 5; j++) {
                        cost[j] += cookbooks[i][j];
                    }
                }
            }
            for (int i = 0; i < 5; i++) {
                if (materials[i] < cost[i]) continue loop;
            }
            max = delicious;
        }
        return max;
    }

    // T3
    HashMap<Integer, Integer> idx;

    public int getNumber(TreeNode root, int[][] ops) {
        idx = new HashMap<>();
        dfs(root);
        int n = idx.size();
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

    // T4
    public int defendSpaceCity(int[] time, int[] position) {
        return 0;
    }

    static Solution solution = new Solution();

    @Test
    public void T3test1() {
        TreeNode root = BinaryTree.stringToBinaryTree("1,null,2,null,3,null,4,null,5");
        int[][] ops = {{1, 2, 4}, {1, 1, 3}, {0, 3, 5}};
        int expected = 2;
        int actual = solution.getNumber(root, ops);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void T3test2() {
        TreeNode root = BinaryTree.stringToBinaryTree("4,2,7,1,null,5,null,null,null,null,6");
        int[][] ops = {{0,2,2},{1,1,5},{0,4,5},{1,5,7}};
        int expected = 5;
        int actual = solution.getNumber(root, ops);
        Assert.assertEquals(expected, actual);
    }

}
