package leetcode.editor.cn;
//给你一个正整数 n。 
//
// 如果一个二进制字符串 x 的所有长度为 2 的子字符串中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。 
//
// 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 3 
// 
//
// 输出： ["010","011","101","110","111"] 
//
// 解释： 
//
// 长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。 
//
// 示例 2： 
//
// 
// 输入： n = 1 
// 
//
// 输出： ["0","1"] 
//
// 解释： 
//
// 长度为 1 的有效字符串有："0" 和 "1"。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 18 
// 
//
// 👍 6 👎 0


import java.util.*;

/**
 * 生成不含相邻零的二进制字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-10-29 02:59:02 
 */
public class GenerateBinaryStringsWithoutAdjacentZerosSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<String> res;
    private int n;

    public List<String> validStrings(int n) {
        this.n = n;
        StringBuilder stack = new StringBuilder();
        res = new ArrayList<>();
        // 第1个数可以为0, 添加一个虚拟1元素在最前面
        dfs(1, stack);
        return res;
    }

    void dfs(int pre, StringBuilder stack) {
        if (stack.length() == n) {
            res.add(stack.toString());
            return;
        }
        stack.append(1);
        dfs(1, stack);
        stack.setLength(stack.length() - 1);
        if (pre == 1) {
            stack.append(0);
            dfs(0, stack);
            stack.setLength(stack.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
