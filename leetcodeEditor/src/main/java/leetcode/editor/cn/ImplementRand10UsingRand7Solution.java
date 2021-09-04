package leetcode.editor.cn;
//已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。 
//
// 不要使用系统的 Math.random() 方法。 
//
// 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: 1
//输出: [7]
// 
//
// 示例 2: 
//
// 
//输入: 2
//输出: [8,4]
// 
//
// 示例 3: 
//
// 
//输入: 3
//输出: [8,1,10]
// 
//
// 
//
// 提示: 
//
// 
// rand7 已定义。 
// 传入参数: n 表示 rand10 的调用次数。 
// 
//
// 
//
// 进阶: 
//
// 
// rand7()调用次数的 期望值 是多少 ? 
// 你能否尽量少调用 rand7() ? 
// 
// Related Topics 数学 拒绝采样 概率与统计 随机化 
// 👍 233 👎 0


import java.util.*;

/**
 * 用 Rand7() 实现 Rand10()
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-05 02:03:08
 */
public class ImplementRand10UsingRand7Solution {
    public static void main(String[] args) {
        Solution s = new ImplementRand10UsingRand7Solution().new Solution();
        int[] cnt = new int[11];
        for (int i = 0; i < 100000; i++) {
            cnt[s.rand10()]++;
        }
        System.out.println(Arrays.toString(cnt));
    }
    class SolBase {
        public int rand7() {
            return (int) (Math.random() * 7) + 1;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */

    class Solution extends SolBase {
        public int rand10() {
            while (true) {
                int a = rand7();
                int b = rand7();
                int c = (a - 1) * 7 + b;
                if (c <= 40) {
                    return c % 10 + 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
