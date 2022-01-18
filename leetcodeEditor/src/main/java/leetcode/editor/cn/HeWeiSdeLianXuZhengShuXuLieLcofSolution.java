package leetcode.editor.cn;

import java.util.*;

/**
 * 和为s的连续正数序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-18 13:16:33
 */
public class HeWeiSdeLianXuZhengShuXuLieLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        // 存储合法的len
        List<Integer> list = new ArrayList<>();
        int product = target * 2;
        int len = 2;
        while (len * len < product) {
            if (product % len == 0 && ((product / len & 1) != (len & 1))) {
                list.add(len);
            }
            len++;
        }
        int size = list.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            len = list.get(size - 1 - i);
            int[] sequence = new int[len];
            for (int i1 = 0, element = (product / len - len + 1) / 2; i1 < len; i1++, element++) {
                sequence[i1] = element;
            }
            res[i] = sequence;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
