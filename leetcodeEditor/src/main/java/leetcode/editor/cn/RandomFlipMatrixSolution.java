package leetcode.editor.cn;

import java.util.*;

/**
 * 随机翻转矩阵
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-27 12:38:15
 */
public class RandomFlipMatrixSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    int total;
    Random random;
    Map<Integer, Integer> map;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        total = m * n;
        random = new Random();
        map = new HashMap<>();
    }

    public int[] flip() {
        int i = random.nextInt(total);
        total--;
        int index = map.getOrDefault(i, i);
        map.put(i, map.getOrDefault(total, total));
        return new int[]{index / n, index % n};
    }

    public void reset() {
        map.clear();
        total = m * n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
