package Contest1007.T4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author IronSid
 * @since 2022-10-07 15:07
 */
public class Solution {
    public static final int INF = Integer.MAX_VALUE;
    private static final char[] s = "helloleetcode".toCharArray();
    // 预处理: cost[i][j] 表示长度 i, 取法 j 的单词的最少消耗
    public static final int MAX_M = 8;
    private static final int[][] cost = new int[MAX_M + 1][];

    static {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= MAX_M; i++) {
            cost[i] = new int[1 << i];
            for (int j = 0; j < 1 << i; j++) {
                // 表示需要取走的字母
                int[] b = new int[i];
                for (int k = 0; k < i; k++) {
                    if ((j >> k & 1) == 1) {
                        deque.offer(k);
                    }
                }
                int c = 0;
                // 左边和右边已经取出的字母数量
                int left = 0, right = 0;
                while (!deque.isEmpty()) {
                    int first = deque.peekFirst();
                    int last = deque.peekLast();
                    // c1, c2 分别是取出 deque 最左和最右的代价
                    int c1 = (first - left) * (i - first - 1 - right);
                    int c2 = (last - left) * (i - last - 1 - right);
                    if (c1 < c2) {
                        c += c1;
                        left++;
                        deque.pollFirst();
                    } else {
                        c += c2;
                        right++;
                        deque.pollLast();
                    }
                }
                cost[i][j] = c;
            }
        }
    }

    // 预处理: next[i][c] 表示已得到状态 i 时，再得到字符 c 之后的状态
    private static final int[][] next = new int[1 << s.length][26];

    static {
        for (int i = 0; i < next.length; i++) {
            for (int c = 0; c < 26; c++) {
                int j;
                for (j = 0; j < s.length; j++) {
                    if ((i >> j & 1) == 0 && s[j] == c + 'a') {
                        break;
                    }
                }
                next[i][c] = j == s.length ? -1 : (i | (1 << j));
            }
        }
    }

    private char[][] w;
    private int[][] dp;


    public int Leetcode(String[] words) {
        w = new char[words.length][];
        for (int i = 0; i < words.length; i++) w[i] = words[i].toCharArray();
        int n = words.length;
        dp = new int[1 << s.length][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int res = f(0, 0);
        return res == INF ? -1 : res;
    }

    int f(int mask, int idx) {
        if (mask == (1 << s.length) - 1) return 0;
        if (idx == w.length) return INF;
        // 利用 dfs 遍历从 w[idx] 中取字母的所有合法方案
        if (dp[mask][idx] == -1) dp[mask][idx] = dfs(mask, idx, 0, 0);;
        return dp[mask][idx];
    }

    // 利用 next 进行 dfs, 返回最小消耗
    // mask 表示 s 中取了哪些字母，wordMask 表示 w[i] 中 取了那些字母
    int dfs(int mask, int i, int wi, int wordMask) {
        if (wi == w[i].length) {
            int f = f(mask, i + 1);
            if (f == INF) return INF;
            return f + cost[w[i].length][wordMask];
        }
        // 不取 w[i][wi]
        int min = dfs(mask, i, wi + 1, wordMask);
        // 取 w[i][wi]
        int nMask = next[mask][w[i][wi] - 'a'];
        if (nMask != -1) min = Math.min(min, dfs(nMask, i, wi + 1, wordMask | (1 << wi)));
        return min;
    }
}
