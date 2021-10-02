package leetcode.editor.cn;
//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 690 👎 0


import java.util.*;

/**
 * 复原 IP 地址
 *
 * @author IronSid
 * @since 2021-10-02 22:13:45
 * @version 1.0
 */
public class RestoreIpAddressesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new LinkedList<>();
        }
        List<String> ans = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        char[] cs = s.toCharArray();
        dfs(cs,0, 0, sb, ans);
        return ans;
    }
    void dfs(char[] chars, int start, int depth, StringBuffer sb, List<String> ans) {
        if (depth == 4 && start == chars.length) {
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }
        int num = 0;
        for (int i = 0; i < 3 && start + i < chars.length; i++) {
            num = num * 10 + (chars[start + i] - '0');
            if (num <= 255) {
                sb.append(num);
                sb.append('.');
                dfs(chars, start + i + 1, depth + 1, sb, ans);
                // 删去数字和'.'
                sb.delete(sb.length() - i - 2, sb.length());
            }
            if (num == 0) {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
