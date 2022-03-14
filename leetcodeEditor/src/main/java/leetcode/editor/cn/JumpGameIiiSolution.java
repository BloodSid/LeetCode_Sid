package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 跳跃游戏 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-14 00:05:28
 */
public class JumpGameIiiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] arr;
    private int n;
    private HashSet<Integer> visited = new HashSet<>();

    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        n = arr.length;
        return dfs(start);
    }

    boolean dfs(int i) {
        if (i < 0 || i >= n) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        visited.add(i);
        if (!visited.contains(i + arr[i])) {
            if (dfs(i + arr[i])) return true;
        }
        if (!visited.contains(i - arr[i])) {
            if (dfs(i - arr[i])) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
