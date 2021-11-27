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
    Random random;
    Set<Integer> set;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        random = new Random();
        set = new HashSet<>();
    }

    public int[] flip() {
        while (true) {
            int i = random.nextInt(m * n);
            if (!set.contains(i)) {
                set.add(i);
                return new int[]{i / n, i % n};
            }
        }
    }

    public void reset() {
        set.clear();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
