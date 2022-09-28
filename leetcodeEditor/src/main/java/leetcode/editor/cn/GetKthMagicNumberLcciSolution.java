package leetcode.editor.cn;
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// 👍 100 👎 0


import java.util.*;

/**
 * 第 k 个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-28 00:51:28 
 */
public class GetKthMagicNumberLcciSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur = set.pollFirst();
            if (cur <= Integer.MAX_VALUE / 3) set.add(3 * cur);
            if (cur <= Integer.MAX_VALUE / 5) set.add(5 * cur);
            if (cur <= Integer.MAX_VALUE / 7) set.add(7 * cur);
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
