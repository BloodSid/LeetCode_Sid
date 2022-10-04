package Contest1002.T4;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-10-02 10:36
 */
public class Solution {
    public int deleteString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // dp[i] 表示删至剩余 s[i:] 的最大步数
        int[] dp = new int[n];
        //  lcp[i][j] 表示 s[i:] 和 s[j:] 的最长公共后缀
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (ch[i] == ch[j]) lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
        }
        TreeSet<Integer> list = new TreeSet<>((o1, o2) -> {
            if (dp[o1] == dp[o2]) return o1 - o2;
            else return dp[o2] - dp[o1];
        });
        list.add(0);
        int maxD = 0;
        // 将 dp[0] 到 dp[i-1] 排好序，然后从大到小来找合法的转移，这样有一个满足就可跳过后面的遍历
        for (int i = 1; i < n; i++) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (lcp[next][i] >= i - next) {
                    dp[i] = dp[next] + 1;
                    list.add(i);
                    break;
                }
            }
            maxD = Math.max(maxD, dp[i]);
        }
        // 任何位置都可以一步操作删除整个字符串，所以找出步数最大的位置再操作一步就是结果
        return maxD + 1;
    }
}
