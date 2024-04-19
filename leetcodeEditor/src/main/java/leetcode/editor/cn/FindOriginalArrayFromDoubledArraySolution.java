package leetcode.editor.cn;
//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。 
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 
//任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
// 
//
// 示例 2： 
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 示例 3： 
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= changed.length <= 10⁵ 
// 0 <= changed[i] <= 10⁵ 
// 
//
// 👍 65 👎 0


import java.util.Arrays;

/**
 * 从双倍数组中还原原数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-04-20 00:10:00 
 */
public class FindOriginalArrayFromDoubledArraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static int[] empty = new int[]{};
    static int M = (int) 1e5;
    static int[] f = new int[M + 1];

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return empty;
        for (int i : changed) {
            f[i]++;
        }
        int[] res = new int[n / 2];
        int ri = 0;
        for (int i = 0; i <= M; i++) {
            if (f[i] > 0) {
                if (i * 2 <= M && f[i] <= f[i * 2]) {
                    // 特殊处理：i=0时，i=i*2
                    if (i == 0) f[i] /= 2;
                    for (int t = 0; t < f[i]; t++) {
                        res[ri++] = i;
                    }
                    f[i * 2] -= f[i];
                    f[i] = 0;
                } else {
                    Arrays.fill(f, i, M + 1, 0);
                    return empty;
                }
            }
            if (ri == n / 2) return res;
        }
        return empty;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
