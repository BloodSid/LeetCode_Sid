package leetcode.editor.cn;

/**
 * 统计最高分的节点数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-11 00:17:48
 */
public class CountNodesWithTheHighestScoreSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] left, right;
    private long maxScore;
    private int cnt;
    private int n;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        left = new int[n];
        right = new int[n];
        for (int i = 1; i < n; i++) {
            int parent = parents[i];
            if (left[parent] == 0) {
                left[parent] = i;
            } else {
                right[parent] = i;
            }
        }
        maxScore = 0;
        cnt = 0;
        getSize(0);
        return cnt;
    }

    int getSize(int node) {
        int leftSize = 0, rightSize = 0;
        if (left[node] != 0) {
            leftSize = getSize(left[node]);
        }
        if (right[node] != 0) {
            rightSize = getSize(right[node]);
        }
        int size = 1 + rightSize + leftSize;
        long score = 1;
        if (n - size != 0) score = n - size;
        if (leftSize != 0) score *= leftSize;
        if (rightSize != 0) score *= rightSize;
        if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        } else if (score == maxScore) {
            cnt++;
        }
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
