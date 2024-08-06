package leetcode.editor.cn;
//给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 5
//输出: 5
//解释: 
//下面列出范围在 [0, 5] 的非负整数与其对应的二进制表示：
//0 : 0
//1 : 1
//2 : 10
//3 : 11
//4 : 100
//5 : 101
//其中，只有整数 3 违反规则（有两个连续的 1 ），其他 5 个满足规则。 
//
// 示例 2: 
//
// 
//输入: n = 1
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: n = 2
//输出: 3
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 👍 394 👎 0


/**
 * 不含连续1的非负整数
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-08-07 00:13:31 
 */
public class NonNegativeIntegersWithoutConsecutiveOnesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int cnt = 1;
    int n;

    public int findIntegers(int n) {
        this.n = n;
        dfs(1);
        return cnt;
    }

    void dfs(int k) {
        if (k > n) {
            return;
        }
        cnt++;
        // 最低位是0
        if ((k & 1) == 0) {
            dfs(k << 1);
            dfs((k << 1) + 1);
        }else{
            dfs(k << 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
