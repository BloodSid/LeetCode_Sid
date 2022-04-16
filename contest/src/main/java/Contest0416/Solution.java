package Contest0416;

import binaryTree.TreeNode;
import org.junit.Test;

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
    int cnt;
    int[][] ops;

    public int getNumber(TreeNode root, int[][] ops) {
        this.ops = ops;
        dfs(root);
        return cnt;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (isRed(node.val)) {
            cnt++;
        }
        dfs(node.right);
    }

    boolean isRed(int val) {
        for (int i = ops.length - 1; i >= 0; i--) {
            if (val >= ops[i][1] && val <= ops[i][2]) {
                return ops[i][0] == 1;
            }
        }
        return false;
    }

    // T4
    public int defendSpaceCity(int[] time, int[] position) {
        return 0;
    }

    @Test
    public void test() {
        
    }
}
