package leetcode.editor.cn;
//给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 
//。 
//
// 如果满足以下公式，则下标 i 是 好下标： 
//
// 
// 0 <= i < variables.length 
// ((aibi % 10)ci) % mi == target 
// 
//
// 返回一个由 好下标 组成的数组，顺序不限 。 
//
// 
//
// 示例 1： 
//
// 
//输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
//输出：[0,2]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(2³ % 10)³ % 10 = 2 。
//2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(3³ % 10)³ % 1 = 0 。
//3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(6¹ % 10)¹ % 4 = 2 。
//因此，返回 [0,2] 作为答案。
// 
//
// 示例 2： 
//
// 
//输入：variables = [[39,3,1000,1000]], target = 17
//输出：[]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(39³ % 10)¹⁰⁰⁰ % 1000 = 1 。
//因此，返回 [] 作为答案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= variables.length <= 100 
// variables[i] == [ai, bi, ci, mi] 
// 1 <= ai, bi, ci, mi <= 10³ 
// 0 <= target <= 10³ 
// 
//
// 👍 27 👎 0


import java.util.*;

/**
 * 双模幂运算
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-07-30 22:01:25 
 */
public class DoubleModularExponentiationSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] v = variables[i];
            int a = v[0], b = v[1], c = v[2], m = v[3];
            if (pow(pow(a, (b + 3) % 4 + 1, 10), c, m) == target) {
                list.add(i);
            }
        }
        return list;
    }

    private int pow(int a, int b, int M) {
        int res = 1;
        for (a %= M; b > 0; b >>= 1) {
            if ((b & 1) == 1) {
                res = res * a % M;
            }
            a = a * a % M;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
