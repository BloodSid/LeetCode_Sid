package leetcode.editor.cn;
//有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。 
//
// 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。 
//
// 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符. 
//
// 请返回一个能打开保险箱的最短字符串。 
//
// 
//
// 示例1: 
//
// 输入: n = 1, k = 2
//输出: "01"
//说明: "10"也可以打开保险箱。
// 
//
// 
//
// 示例2: 
//
// 输入: n = 2, k = 2
//输出: "00110"
//说明: "01100", "10011", "11001" 也能打开保险箱。
// 
//
// 
//
// 提示： 
//
// 
// n 的范围是 [1, 4]。 
// k 的范围是 [1, 10]。 
// k^n 最大可能为 4096。 
// 
//
// 
// 👍 121 👎 0


import java.util.*;

/**
 * 破解保险箱
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-01-10 01:36:21 
 */
public class CrackingTheSafeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashSet<String> v;
    private int n;
    private int k;
    private String start;

    public String crackSafe(int n, int k) {
        this.n = n;
        this.k = k;
        v = new HashSet<>();
        char[] ch = new char[n - 1];
        // 用回溯建立图中所有的点
        getPoints(ch, 0);
        // 遍历所有的边
        Arrays.fill(ch, '0');
        start = new String(ch);
        StringBuilder sb = new StringBuilder(start);
        // 记录遍历过的边
        HashSet<String> vis = new HashSet<>();
        dfs(start, sb, vis);
        return sb.toString();
    }

    private boolean dfs(String cur, StringBuilder sb, HashSet<String> vis) {
        for (char c = '0'; c < '0' + k; c++) {
            String edge = cur + c;
            // 未用过的边
            if (vis.contains(edge)) continue;
            sb.append(c);
            vis.add(edge);
            if (dfs(edge.substring(1), sb, vis)) {
                // 走得通
                return true;
            } else {
                // 走不通
                sb.setLength(sb.length() - 1);
                vis.remove(edge);
            }
        }
        // 若所有的边都被遍历
        return vis.size() == v.size() * k;
    }

    private void getPoints(char[] ch, int i) {
        if (i == ch.length) {
            v.add(new String(ch));
            return;
        }
        for (char c = '0'; c < '0' + k; c++) {
            ch[i] = c;
            getPoints(ch, i + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
